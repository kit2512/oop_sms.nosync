package dev.kit2512.oop_sms.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService{
    @Override
    public void exportToExcel(String path) {
        try  {
            FileInputStream file = new FileInputStream(path);
            final Workbook workbook = new XSSFWorkbook(file);
            final Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> data.get(i).add(cell.getStringCellValue());
                        case NUMERIC -> data.get(i).add(String.valueOf(cell.getNumericCellValue()));
                        case BOOLEAN -> data.get(i).add(String.valueOf(cell.getBooleanCellValue()));
                        default -> {
                        }
                    }
                }
                i++;
            }

            System.out.println(data);
            file.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void importFromExcel(String path) {

    }

    public static void main(String[] args) {
        FileServiceImpl fileService = new FileServiceImpl();
        fileService.exportToExcel("./src/res/dummy_excel.xlsx");

    }
}
