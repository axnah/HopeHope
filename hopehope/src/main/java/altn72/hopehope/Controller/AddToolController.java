package altn72.hopehope.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddToolController {

    @GetMapping("/addTool")
    String showAddToolForm(Model model) {
        return "addTool";
    }
}
