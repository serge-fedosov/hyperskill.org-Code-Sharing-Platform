package platform.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeDTO {

    private String code;
    private LocalDateTime date;

    public CodeDTO() {
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
