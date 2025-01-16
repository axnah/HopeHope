package altn72.hopehope.Service;

import altn72.hopehope.Model.FeedBack;
import altn72.hopehope.Repository.FeedBackRepository;
import altn72.hopehope.Dto.FeedBackDTO;
import altn72.hopehope.Mapper.FeedBackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    public List<FeedBack> getFeedBacksByTool(Long toolId) {
        return feedBackRepository.findByToolId(toolId);
    }

    public void saveFeedBack(FeedBack feedBack) {
        feedBackRepository.save(feedBack);
    }
}
