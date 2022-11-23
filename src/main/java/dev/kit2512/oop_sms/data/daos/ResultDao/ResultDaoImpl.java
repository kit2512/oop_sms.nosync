package dev.kit2512.oop_sms.data.daos.ResultDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.entities.ResultEntity;

import java.sql.SQLException;

public class ResultDaoImpl extends BaseDaoImpl<ResultEntity, Integer> implements ResultDao {

    public ResultDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ResultEntity.class);
        TableUtils.createTableIfNotExists(connectionSource, ResultEntity.class);
    }

}
