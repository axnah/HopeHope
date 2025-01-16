package altn72.hopehope.Mapper;

import altn72.hopehope.Model.Tool;
import altn72.hopehope.Dto.ToolDTO;

public class ToolMapper {
    public static ToolDTO toDTO(Tool tool) {
        return new ToolDTO(
                tool.getId(),
                tool.getTitle(),
                tool.getDomain(),
                tool.getSimpleDescription(),
                tool.getLink()
        );
    }
}
