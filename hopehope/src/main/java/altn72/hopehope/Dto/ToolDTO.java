package altn72.hopehope.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToolDTO {
    private Long id;
    private String title;
    private String domain;
    private String simpleDescription;
    private String detailedDescription;
    private String link;
    private String accessTutorial;

}
