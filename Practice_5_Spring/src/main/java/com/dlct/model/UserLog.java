package com.dlct.model;

import com.dlct.pojo.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

@Service
public class UserLog {

    @Resource
    DBBase dbBase;

    public int insertLog(String log, Date utilDate) throws SQLException, ClassNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sqlDate = sdf.format(utilDate);
        String sql = "insert into javaee_practice.log(log_text, time_log) " +
                "VALUES ( '" + log + "', str_to_date('" + sqlDate + "', '%Y-%m-%d %H:%i:%s'))";
        return dbBase.updataUser(sql);
    }

    public List<Log> selectLog() throws SQLException, ClassNotFoundException {
        List<Log> logs = new ArrayList<Log>();
        String sql = "select * from javaee_practice.log";
        ResultSet resultSet = dbBase.selectAll(sql);
        while (resultSet.next()){
            Log log = new Log();
            log.setId(resultSet.getInt("id"));
            log.setLog_text(resultSet.getString("log_text"));
            log.setTime(resultSet.getTimestamp("time_log"));
            logs.add(log);
        }
        return logs;
    }
}
