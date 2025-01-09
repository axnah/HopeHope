package altn72.hopehope.Controller;

import altn72.hopehope.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/import")
    public String importExcel() {
        try {
            excelService.importExcelData();
            return "Data imported successfully!";
        } catch (RuntimeException e) {
            return "Failed to import data: " + e.getMessage();
        }
    }
}