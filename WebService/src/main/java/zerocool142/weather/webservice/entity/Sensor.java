package zerocool142.weather.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sensor {

    @Id
    private Integer id;

    private String name;

    private String comment;
}
