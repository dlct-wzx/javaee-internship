package com.dlct.pojo;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Log {
    private int id;
    private String log_text;
    private Timestamp time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLog_text() {
        return log_text;
    }

    public void setLog_text(String log_text) {
        this.log_text = log_text;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", log_text='" + log_text + '\'' +
                ", time=" + time +
                '}';
    }
}
