package dev.kit2512.oop_sms.data.daos.ResultDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dev.kit2512.oop_sms.data.models.ResultModel;

import java.sql.SQLException;

public class ResultDaoImpl extends BaseDaoImpl<ResultModel, Integer> implements ResultDao {

    public ResultDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ResultModel.class);
        TableUtils.createTableIfNotExists(connectionSource, ResultModel.class);
    }

}
