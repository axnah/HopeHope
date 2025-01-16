package altn72.hopehope.Controller;

import altn72.hopehope.Dto.ToolDTO;
import altn72.hopehope.Model.Tool;
import altn72.hopehope.Service.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/tools")
public class ToolDetailsController {

    @Autowired
    private ToolService toolService;

    @GetMapping("/{id}/details")
    public String getToolDetails(@PathVariable Long id, Model model) {
        Optional<ToolDTO> tool = toolService.getToolById(id);
        if (tool.isPresent()) {
            model.addAttribute("tool", tool.get());
            return "toolDetails";
        } else {
            return "redirect:/api/excel/view";
        }
    }
}
