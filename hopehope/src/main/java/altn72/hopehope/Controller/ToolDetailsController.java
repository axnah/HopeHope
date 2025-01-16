package altn72.hopehope.Controller;

import altn72.hopehope.Model.Tool;
import altn72.hopehope.Service.ToolService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/tools")
public class ToolDetailsController {

    @Autowired
    private ToolService toolService;

    @GetMapping("/{id}/details")
    public String getToolDetails(@PathVariable Long id, Model model) {
        try {
            Tool tool = toolService.getToolById(id);
            if (tool != null) {
                model.addAttribute("tool", tool);
                return "toolDetails";
            } else {
                return "redirect:/api/excel/view";
            }
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR,
                    "An error occurred while fetching tool details",
                    e
            );
        }
    }
}
