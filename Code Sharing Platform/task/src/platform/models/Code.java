package platform.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "code")
public class Code {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "date")
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
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
