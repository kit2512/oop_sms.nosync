package dev.kit2512.oop_sms.services.FileService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;



public class FileServiceImpl implements FileService {
    
    @Inject
    public FileServiceImpl() {
        
    }
    
    @Override
    public void exportToExcel(AbstractExcelFileModel excelFileModel) throws FileServiceException{
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
                cell.setCellValue(excelFileModel.getColumnNames()[i]);
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
            workbook.write(new FileOutputStream(excelFileModel.getPath()));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AbstractExcelFileModel importFromExcel(String path) throws FileServiceException{
        return null;
    }

}
