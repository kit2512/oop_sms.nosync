package dev.kit2512.oop_sms.services.FileService;

public interface FileService {
    void exportToExcel(String path, AbstractExcelFileModel excelFileModel);

    AbstractExcelFileModel importFromExcel(String path);
}
