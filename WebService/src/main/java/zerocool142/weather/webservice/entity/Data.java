package zerocool142.weather.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Data {

    @Id
    private Integer id;

    private Double temp;
    private Integer preassure;
    private Integer humidity;
    private Date date;

    public Data(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getPreassure() {
        return preassure;
    }

    public void setPreassure(Integer preassure) {
        this.preassure = preassure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
