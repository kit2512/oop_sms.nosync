package dev.kit2512.oop_sms.domain.repositories.StaffRepository;

import dev.kit2512.oop_sms.domain.entities.StaffEntity;

import java.util.HashMap;
import java.util.List;

public interface StaffRepository {
    List<StaffEntity> getStaffs() throws StaffException;

    List<StaffEntity> getStaffs(HashMap<String, Object> filter) throws StaffException;

    StaffEntity removeStaff(StaffEntity userEntity) throws StaffException;

    StaffEntity addStaff(StaffEntity userEntity) throws StaffException;

    StaffEntity updateStaff(StaffEntity oldStaffModel, StaffEntity newStaffModel) throws StaffException;
}
