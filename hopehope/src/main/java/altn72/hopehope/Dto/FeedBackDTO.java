package altn72.hopehope.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedBackDTO {
    private Long id;
    private String comment;
    private Long toolId;
    private String toolTitle;
    private Long userId;
    private String userName;
}
