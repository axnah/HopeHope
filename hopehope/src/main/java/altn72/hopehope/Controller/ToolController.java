package altn72.hopehope.Controller;

import altn72.hopehope.Service.ToolService;
import altn72.hopehope.Dto.ToolDTO;
import altn72.hopehope.Model.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping
    public List<ToolDTO> getAllTools() {
        try {
            return toolService.getAllTools();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching tools");
        }
    }

    @GetMapping("/{id}")
    public Tool getToolById(@PathVariable Long id) {
        try {
            return toolService.getToolById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tool not found");
        }
    }

    @PostMapping
    public Tool createOrUpdateTool(@RequestBody Tool tool) {
        try {
            return toolService.saveTool(tool);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving tool");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTool(@PathVariable Long id) {
        try {
            toolService.deleteTool(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting tool");
        }
    }
}
