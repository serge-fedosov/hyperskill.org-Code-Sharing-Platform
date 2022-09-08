package platform.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Code {

    private int id;
    private String code;
    private LocalDateTime date;

    public Code() {
    }

    public Code(int id, String code, LocalDateTime date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
//        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
