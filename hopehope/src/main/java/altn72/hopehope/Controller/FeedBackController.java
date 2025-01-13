package altn72.hopehope.Controller;

import altn72.hopehope.Service.FeedBackService;
import altn72.hopehope.Dto.FeedBackDTO;
import altn72.hopehope.Model.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedBacks")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @GetMapping("/tool/{toolId}")
    public List<FeedBackDTO> getFeedBacksByTool(@PathVariable Long toolId) {
        return feedBackService.getFeedBacksByTool(toolId);
    }

    @PostMapping
    public ResponseEntity<FeedBack> createFeedBack(@RequestBody FeedBack feedBack) {
        FeedBack savedFeedBack = feedBackService.saveFeedBack(feedBack);
        return ResponseEntity.ok(savedFeedBack);
    }
}
