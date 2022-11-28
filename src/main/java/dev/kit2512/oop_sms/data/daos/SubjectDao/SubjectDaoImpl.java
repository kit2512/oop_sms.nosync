package dev.kit2512.oop_sms.data.daos.SubjectDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.daos.UserDao.UserDaoImpl;
import dev.kit2512.oop_sms.data.models.SubjectModel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubjectDaoImpl extends BaseDaoImpl<SubjectModel, Integer> implements SubjectDao  {
    public SubjectDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SubjectModel.class);
        try {
            TableUtils.createTableIfNotExists(connectionSource, SubjectModel.class);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
