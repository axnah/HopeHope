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
    public String importExcel() {
        try {
            excelService.importExcelData();
            return "Data imported successfully!";
        } catch (RuntimeException e) {
            return "Failed to import data: " + e.getMessage();
        }
    }

    @GetMapping("/view")
    public String viewExcelData(Model model) {
        List<Tool> tools = excelService.getAllTools();
        System.out.println("Data retrieved: " + tools.size() + " items");
        model.addAttribute("tools", tools);
        return "excelView";
    }

    @GetMapping("/search")
    public String searchTools(@RequestParam("keyword") String keyword, Model model) {
        List<Tool> filteredTools = toolService.searchTools(keyword);
        model.addAttribute("tools", filteredTools);
        return "excelView";
    }

}