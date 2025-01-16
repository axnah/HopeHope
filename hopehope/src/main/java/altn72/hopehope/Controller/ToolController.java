package altn72.hopehope.Controller;

import altn72.hopehope.Service.ToolService;
import altn72.hopehope.Dto.ToolDTO;
import altn72.hopehope.Model.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping
    public List<ToolDTO> getAllTools() {
        return toolService.getAllTools();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tool> getToolById(@PathVariable Long id) {
        Tool tool = toolService.getToolById(id);
        return ResponseEntity.ok(tool);
    }

    @PostMapping
    public ResponseEntity<Tool> createOrUpdateTool(@RequestBody Tool tool) {
        Tool savedTool = toolService.saveTool(tool);
        return ResponseEntity.ok(savedTool);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Tool> searchTools(@RequestParam String keyword) {
        return toolService.searchTools(keyword);
    }
}
