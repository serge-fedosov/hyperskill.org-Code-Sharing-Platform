package platform.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Code {

    private String code;
    private LocalDateTime date;

    public Code() {
    }

    public Code(String code, LocalDateTime date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
