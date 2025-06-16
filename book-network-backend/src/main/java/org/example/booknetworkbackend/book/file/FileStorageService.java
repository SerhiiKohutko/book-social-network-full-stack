package org.example.booknetworkbackend.book.file;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStorageService {
    @Value("${application.file.upload.photos-output-path}")
    private String fileUploadPath;

    public String saveFile(@NotNull MultipartFile source,
                           @NotNull Long userId){
        final String fileUploadSubPath = "users" + File.separator + userId;

        return fileUpload(source, fileUploadSubPath);
    }

    private String fileUpload(MultipartFile source, String fileUploadSubPath){
        final String finalUploadPath = fileUploadPath + File.separator + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);
        if (!targetFolder.exists()){
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                log.warn("Failed to create the target folder:: " + finalUploadPath);
                return null;
            }
        }

        final String fileExtension = getFileExtension(source.getOriginalFilename());
        String targetFilePath = finalUploadPath + File.separator + System.currentTimeMillis() + "." + fileExtension;
        Path targetPath = Paths.get(targetFilePath);

        try {
            Files.write(targetPath, source.getBytes());
            log.info("File saved to " + targetFilePath);
        } catch (IOException e){
            log.error("File was not save", e);
        }
        return null;
    }

    private String getFileExtension(String fileName){
        if (fileName == null || fileName.isEmpty()){
            return "";
        }

        int lastDotIndex = fileName.lastIndexOf(".");

        if (lastDotIndex == -1){
            return "";
        }

        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }

}
