package dev.kit2512.oop_sms.services;

public interface FileService {
    void exportToExcel(String path);

    void importFromExcel(String path);
}
