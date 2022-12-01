package dev.kit2512.oop_sms.data.daos.StaffDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.models.StaffModel;

import java.sql.SQLException;

public class StaffDaoImpl extends BaseDaoImpl<StaffModel, Integer> implements StaffDao {
    public StaffDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, StaffModel.class);
        TableUtils.createTableIfNotExists(connectionSource, StaffModel.class);
    }
}
