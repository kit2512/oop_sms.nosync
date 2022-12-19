package dev.kit2512.oop_sms.services.FileService;

public interface FileService {
    void exportToExcel( AbstractExcelFileModel excelFileModel) throws FileServiceException;

    AbstractExcelFileModel importFromExcel(String path) throws FileServiceException;
}
