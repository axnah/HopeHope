package altn72.hopehope.Controller;

import altn72.hopehope.Dto.ToolDTO;
import altn72.hopehope.Model.Tool;
import altn72.hopehope.Service.ExcelService;
import altn72.hopehope.Service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private ToolService toolService;

    @PostMapping("/import")
    public String importExcel(Model model) {
        try {
            excelService.importExcelData();
            model.addAttribute("notification", "Data imported successfully!");
        } catch (RuntimeException e) {
            model.addAttribute("error", "Failed to import data: " + e.getMessage());
        }
        return "redirect:/api/excel/view"; // Redirige vers la page de visualisation
    }

    @GetMapping("/view")
    public String viewExcelData(Model model) {
        List<Tool> tools = excelService.getAllTools();
        model.addAttribute("tools", tools);
        return "excelView";
    }

    @GetMapping("/search")
    public String searchTools(@RequestParam("keyword") String keyword, Model model) {
        List<Tool> filteredTools = toolService.searchTools(keyword);
        model.addAttribute("tools", filteredTools);
        return "excelView";
    }

    @GetMapping("/delete/{id}")
    public String deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return "redirect:/api/excel/view"; // Redirige vers la liste mise à jour
    }


}