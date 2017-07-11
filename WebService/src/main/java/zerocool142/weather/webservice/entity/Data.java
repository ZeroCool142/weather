package zerocool142.weather.webservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Sensor sensor;
    @Column
    private Double temp;
    @Column
    private Integer preassure;
    @Column
    private Integer humidity;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
