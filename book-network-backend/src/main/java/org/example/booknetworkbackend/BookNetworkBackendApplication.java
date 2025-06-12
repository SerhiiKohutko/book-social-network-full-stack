package org.example.booknetworkbackend;

import org.example.booknetworkbackend.role.Role;
import org.example.booknetworkbackend.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BookNetworkBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookNetworkBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository repository){
        return args -> {
          if (repository.findByName("USER").isEmpty()){
              repository.save(
                      Role.builder().name("USER").build()
              );
          }
        };
    }
}
