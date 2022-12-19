package dev.kit2512.oop_sms.data.repositories;

import dev.kit2512.oop_sms.data.daos.StaffDao.StaffDao;
import dev.kit2512.oop_sms.domain.entities.StaffEntity;
import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.StaffRepository.StaffException;
import dev.kit2512.oop_sms.domain.repositories.StaffRepository.StaffRepository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class StaffRepositoryImpl implements StaffRepository {
    private StaffDao staffDao;

    @Inject
    public StaffRepositoryImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public StaffRepositoryImpl() {

    }

    @Override
    public List<StaffEntity> getStaffs() throws StaffException {
        return null;
    }

    @Override
    public List<StaffEntity> getStaffs(HashMap<String, Object> filter) throws StaffException {
        return null;
    }

    @Override
    public StaffEntity removeStaff(StaffEntity userEntity) throws StaffException {
        return null;
    }

    @Override
    public StaffEntity addStaff(StaffEntity userEntity) throws StaffException {
        return null;
    }

    @Override
    public StaffEntity updateStaff(StaffEntity oldStaffModel, StaffEntity newStaffModel) throws StaffException {
        return null;
    }

    @Override
    public UserEntity getStaff(Integer userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
