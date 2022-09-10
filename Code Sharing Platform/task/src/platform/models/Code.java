package platform.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "time")
    private int time;

    @Column(name = "views")
    private int views;

    @Column(name = "date_from")
    private LocalDateTime dateFrom;

    @Column(name = "restrictions")
    private boolean restrictions;

    @Column(name = "time_restriction")
    private boolean timeRestriction;

    @Column(name = "views_restriction")
    private boolean viewsRestriction;

    public Code() {
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

    public String getDateString() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isRestrictions() {
        return restrictions;
    }

    public void setRestrictions(boolean restrictions) {
        this.restrictions = restrictions;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public boolean isTimeRestriction() {
        return timeRestriction;
    }

    public void setTimeRestriction(boolean timeRestriction) {
        this.timeRestriction = timeRestriction;
    }

    public boolean isViewsRestriction() {
        return viewsRestriction;
    }

    public void setViewsRestriction(boolean viewsRestriction) {
        this.viewsRestriction = viewsRestriction;
    }
}
