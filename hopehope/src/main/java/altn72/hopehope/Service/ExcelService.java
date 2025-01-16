package altn72.hopehope.Service;

import altn72.hopehope.Model.Tool;
import altn72.hopehope.Model.User;
import altn72.hopehope.Repository.ToolRepository;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ToolService toolService;

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private UserService userService;

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

            User user = new User();
            user.setId(1L);
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setPassword("admin");
            user.setRole("ADMIN");
            user.setEmail("admin@admin.com");
            userService.saveUser(user);



        }  catch (IOException e) {
            throw new RuntimeException("Erreur d'accès au fichier Excel : " + e.getMessage(), e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde des données en base : " + e.getMessage(), e);
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return null;
        String value;
        switch (cell.getCellType()) {
            case STRING -> value = cell.getStringCellValue();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue().toString();
                } else {
                    value = String.valueOf(cell.getNumericCellValue());
                }
            }
            case BOOLEAN -> value = String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> value = cell.getCellFormula();
            default -> value = null;
        }
        return (value != null && value.length() > 255) ? value.substring(0, 255) : value;
    }

    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }
}
