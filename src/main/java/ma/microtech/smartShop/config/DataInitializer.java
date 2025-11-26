package ma.microtech.smartShop.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.microtech.smartShop.entities.Client;
import ma.microtech.smartShop.entities.User;
import ma.microtech.smartShop.entities.enums.CustomerTier;
import ma.microtech.smartShop.entities.enums.UserRole;
import ma.microtech.smartShop.repositories.ClientRepository;
import ma.microtech.smartShop.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            log.info("Initializing default data...");
            createAdminUser();
            createClientUser();
            log.info("Default data initialized successfully!");
        } else {
            log.info("Data already exists, skipping initialization.");
        }
    }

    private void createAdminUser() {
        User admin = User.builder()
                .username("admin")
                .name("System Administrator")
                .password(passwordEncoder.encode("123456"))
                .role(UserRole.ADMIN)
                .build();

        userRepository.save(admin);
        log.info("Admin user created: username=admin, password=123456");
    }

    private void createClientUser() {
        // Create client user
        User clientUser = User.builder()
                .username("clientTest")
                .name("Test Client")
                .password(passwordEncoder.encode("123456"))
                .role(UserRole.CLIENT)
                .build();

        User savedClientUser = userRepository.save(clientUser);

        // Create client profile
        Client client = Client.builder()
                .user(savedClientUser)
                .email("clienttest@example.com")
                .tier(CustomerTier.BASIC)
                .totalOrders(0)
                .totalSpent(0.0)
                .build();

        clientRepository.save(client);
        log.info("Client user created: username=clientTest, password=123456, tier=BASIC");
    }
}
