package altn72.hopehope.Controller;

import altn72.hopehope.Model.Tool;
import altn72.hopehope.Model.User;
import altn72.hopehope.Repository.ToolRepository;
import altn72.hopehope.Repository.UserRepository;
import altn72.hopehope.Service.FeedBackService;
import altn72.hopehope.Model.FeedBack;
import altn72.hopehope.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/form/{toolId}")
    public String showFeedbackForm(@PathVariable Long toolId, Model model) {
        List<FeedBack> feedBacks = feedBackService.getFeedBacksByTool(toolId);
        System.out.println("FeedBacks: " + feedBacks);
        model.addAttribute("feedBacks", feedBacks);
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
            feedback.setUser(userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found")));
            feedBackService.saveFeedBack(feedback);

            return "redirect:/api/excel/view";
        } catch (RuntimeException e) {
            model.addAttribute("message", "Erreur lors de l'ajout du feedback : " + e.getMessage());
            return "error";
        }
    }

}
