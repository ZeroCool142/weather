package zerocool142.weather.webservice.service;

import org.springframework.data.repository.CrudRepository;
import zerocool142.weather.webservice.entity.Sensor;

public interface SensorService extends CrudRepository<Sensor, Integer>{
}
