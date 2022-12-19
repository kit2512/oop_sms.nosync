package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.MajorDao.MajorDao;
import dev.kit2512.oop_sms.data.models.MajorModel;
import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorException;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorRepository;
import dev.kit2512.oop_sms.domain.repositories.UserRepository.UserException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class MajorRepositoryImpl implements MajorRepository {
    private MajorDao majorDao;

    @Inject
    public MajorRepositoryImpl(MajorDao majorDao) {
        this.majorDao = majorDao;
    }

    @Override
    public List<MajorEntity> getMajors() throws MajorException {
        try {
            final List<MajorModel> majorModels = majorDao.queryForAll();
            final ArrayList<MajorEntity> majorEntitys = new ArrayList<>();
            for (MajorModel model : majorModels) {
                majorEntitys.add(model.mapToEntity());
            }
            return majorEntitys;
        } catch (SQLException ex) {
            throw new MajorException(ex.getMessage());
        }
    }

    @Override
    public List<MajorEntity> getMajors(HashMap<String, Object> filter) throws MajorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MajorEntity removeMajor(MajorEntity userEntity) throws MajorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MajorEntity addMajor(MajorEntity userEntity) throws MajorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MajorEntity updateMajor(MajorEntity oldMajorModel, MajorEntity newMajorModel) throws MajorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
