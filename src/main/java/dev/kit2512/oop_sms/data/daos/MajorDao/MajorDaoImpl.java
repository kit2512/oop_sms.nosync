package dev.kit2512.oop_sms.data.daos.MajorDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.models.MajorModel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MajorDaoImpl extends BaseDaoImpl<MajorModel, Integer> implements MajorDao {
    public MajorDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, MajorModel.class);
        try {
            TableUtils.createTableIfNotExists(connectionSource, MajorModel.class);

        } catch (SQLException ex) {
            Logger.getLogger(MajorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}