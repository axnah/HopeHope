package altn72.hopehope.Controller;

import altn72.hopehope.Model.Tool;
import altn72.hopehope.Repository.ToolRepository;
import altn72.hopehope.Service.FeedBackService;
import altn72.hopehope.Model.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private ToolRepository toolRepository;

    @GetMapping("/form/{toolId}")
    public String showFeedbackForm(@PathVariable Long toolId, Model model) {
        model.addAttribute("toolId", toolId);
        return "feedbackForm";
    }

    @PostMapping("/add")
    public String addFeedBack(@RequestParam Long toolId, @RequestParam String comment, Model model) {
        try {
            Tool tool = toolRepository.findById(toolId)
                    .orElseThrow(() -> new RuntimeException("Tool not found"));

            FeedBack feedback = new FeedBack();
            feedback.setComment(comment);
            feedback.setTool(tool);
            feedBackService.saveFeedBack(feedback);

            return "redirect:/api/excel/view";
        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de l'ajout du feedback : " + e.getMessage());
            return "error";
        }
    }

}
