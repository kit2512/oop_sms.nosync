/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.config.injectors;

import dagger.Module;
import dagger.Provides;
import dev.kit2512.oop_sms.services.FileService.FileService;
import javax.inject.Singleton;
/**
 *
 * @author macpro13
 */

@Module
public class ServiceModule {
    private final FileService fileService;
    
    public ServiceModule(FileService fileService) {
        this.fileService = fileService;
    }
    
    @Provides
    @Singleton
    public FileService getFileService() {
        return this.fileService;
    }
}
