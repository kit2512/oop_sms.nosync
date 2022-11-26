package dev.kit2512.oop_sms.services.FileService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileServiceImpl implements FileService {
    @Override
    public void exportToExcel(String path, AbstractExcelFileModel excelFileModel) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(excelFileModel.getTitle());
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue(excelFileModel.getTitle());
            row = sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellValue(excelFileModel.getSubTitle());
            row = sheet.createRow(2);
            Class<?>[] columnTypes = excelFileModel.getColumnTypes();
            for (int i = 0; i < columnTypes.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(columnTypes[i].getSimpleName());
            }
            Map<Integer, ArrayList<Object>> data = excelFileModel.getData();
            int rowNumber = 3;
            for (Map.Entry<Integer, ArrayList<Object>> entry : data.entrySet()) {
                row = sheet.createRow(rowNumber);
                for (int i = 0; i < entry.getValue().size(); i++) {
                    cell = row.createCell(i);
                    cell.setCellValue(entry.getValue().get(i).toString());
                }
                rowNumber++;
            }
            workbook.write(new FileOutputStream(path));
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AbstractExcelFileModel importFromExcel(String path) {
        return null;
    }


    public static void main(String[] args) {
        FileServiceImpl fileService = new FileServiceImpl();
        ExcelFileModel excelFileModel = new ExcelFileModel();
        excelFileModel.setTitle("Test");
        excelFileModel.setSubTitle("Test");
        excelFileModel.setColumnTypes(new Class<?>[]{Integer.class, String.class});
        HashMap<Integer, ArrayList<Object>> data = new HashMap<>();
        ArrayList<Object> row = new ArrayList<>();
        row.add(1);
        row.add("Test");
        data.put(0, row);
        excelFileModel.setData(data);
        fileService.exportToExcel("./src/res/test.xlsx", excelFileModel);
    }
}
