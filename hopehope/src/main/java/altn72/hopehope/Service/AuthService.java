package altn72.hopehope.Service;

import altn72.hopehope.Model.User;
import altn72.hopehope.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> login(String email, String password) {
        System.out.println("Tentative de connexion avec l'email : " + email);
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            System.out.println("Utilisateur trouvé : " + user.get().getEmail());
            if (passwordEncoder.matches(password, user.get().getPassword())) {
                System.out.println("Mot de passe correct pour l'utilisateur : " + email);
                return user;
            } else {
                System.out.println("Mot de passe incorrect pour l'utilisateur : " + email);
            }
        } else {
            System.out.println("Utilisateur non trouvé avec l'email : " + email);
        }
        return Optional.empty();
    }

}

