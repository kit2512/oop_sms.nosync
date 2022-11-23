package dev.kit2512.oop_sms.data.daos.UserDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.entities.UserEntity;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl extends BaseDaoImpl<UserEntity, Integer> implements UserDao {
    
    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, UserEntity.class);
        try {
            TableUtils.createTableIfNotExists(connectionSource, UserEntity.class);

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
