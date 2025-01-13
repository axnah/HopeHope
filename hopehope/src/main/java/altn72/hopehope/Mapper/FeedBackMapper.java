package altn72.hopehope.Mapper;

import altn72.hopehope.Model.FeedBack;
import altn72.hopehope.Dto.FeedBackDTO;

public class FeedBackMapper {

    public static FeedBackDTO toDTO(FeedBack feedBack) {
        return new FeedBackDTO(
                feedBack.getId(),
                feedBack.getComment(),
                feedBack.getTool().getId(),
                feedBack.getTool().getTitle(),
                feedBack.getUser().getId(),
                feedBack.getUser().getFirstName() + " " + feedBack.getUser().getLastName()
        );
    }
}
