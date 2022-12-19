/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.services.FileService.ExcelFileModel;
import dev.kit2512.oop_sms.services.FileService.FileService;
import dev.kit2512.oop_sms.services.FileService.FileServiceException;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class ExportExcelUseCase {
    private final FileService fileService;
    
    @Inject
    public ExportExcelUseCase(FileService fileService) {
        this.fileService = fileService;
    }
    
    public void execute(ExcelFileModel model) throws FileServiceException {
        fileService.exportToExcel(model);
    }
}
