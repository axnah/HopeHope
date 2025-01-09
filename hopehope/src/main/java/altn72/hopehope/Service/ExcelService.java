package altn72.hopehope.Service;

import altn72.hopehope.Model.Tool;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ToolService toolService;

    public void importExcelData() {
        try {
            InputStream inputStream = new ClassPathResource("HOPE_Excel.xlsx").getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            List<Tool> tools = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Tool tool = new Tool();
                tool.setTitle(getCellValueAsString(row.getCell(0)));
                tool.setDomain(getCellValueAsString(row.getCell(1)));
                tool.setSimpleDescription(getCellValueAsString(row.getCell(2)));
                tool.setDetailedDescription(getCellValueAsString(row.getCell(3)));
                tool.setLink(getCellValueAsString(row.getCell(4)));
                tool.setAccessTutorial(getCellValueAsString(row.getCell(5)));

                tools.add(tool);
            }

            toolService.saveAll(tools);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to import Excel data: " + e.getMessage());
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case STRING -> {
                return cell.getStringCellValue();
            }
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            }
            case BOOLEAN -> {
                return String.valueOf(cell.getBooleanCellValue());
            }
            case FORMULA -> {
                return cell.getCellFormula();
            }
            default -> {
                return null;
            }
        }
    }
}
