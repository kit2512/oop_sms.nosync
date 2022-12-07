/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.domain.usecases;

import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorException;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class GetMajorListUseCase {
    private final MajorRepository majorRepository;

    @Inject
    public GetMajorListUseCase(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }
    
    public List<MajorEntity> execute() throws MajorException {
        try {
            return majorRepository.getMajors();
        } catch (MajorException exception) {
            throw exception;
        }
    }
} 
