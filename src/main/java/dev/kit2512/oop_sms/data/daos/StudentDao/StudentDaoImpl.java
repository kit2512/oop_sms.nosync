package dev.kit2512.oop_sms.data.daos.StudentDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.entities.StudentEntity;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDaoImpl extends BaseDaoImpl<StudentEntity, Integer> implements StudentDao {

    public StudentDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, StudentEntity.class);
        try {
            TableUtils.createTableIfNotExists(connectionSource, StudentEntity.class);

        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}