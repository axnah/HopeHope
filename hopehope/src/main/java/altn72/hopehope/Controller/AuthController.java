package altn72.hopehope.Controller;

import altn72.hopehope.Model.User;
import altn72.hopehope.Service.AuthService;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> user = authService.login(email, password);
        if (user.isPresent()) {
            return "redirect:/api/auth/bonjour";
        } else {
            return "login"; // Vue HTML pour le formulaire de connexion
        }
    }

    @GetMapping("/bonjour")
    public String getBonjour(Model model) {
        return "bonjour"; // Vue HTML nommée "bonjour.html"
    }
}
