package altn72.hopehope.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/main")
    String getMain(Model model) {
        return "main";
    }
    @GetMapping("/bonjour")
    String getBonjour(Model model) {
        return "bonjour";
    }

}
