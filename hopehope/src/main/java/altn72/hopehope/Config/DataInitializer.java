package altn72.hopehope.Config;

import altn72.hopehope.Model.Role;
import altn72.hopehope.Model.User;
import altn72.hopehope.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Vérifiez si les utilisateurs existent déjà pour éviter les doublons
            if (userRepository.findByEmail("admin@example.com").isEmpty()) {
                userRepository.save(new User(null, "Admin", "User", "admin@example.com", 
                    passwordEncoder.encode("password"), Role.ADMIN));
            }
            if (userRepository.findByEmail("student@example.com").isEmpty()) {
                userRepository.save(new User(null, "Student", "User", "student@example.com", 
                    passwordEncoder.encode("password"), Role.STUDENT));
            }
        };
    }
}
