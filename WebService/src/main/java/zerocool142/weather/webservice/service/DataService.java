package zerocool142.weather.webservice.service;

import org.springframework.data.repository.CrudRepository;
import zerocool142.weather.webservice.entity.Data;

import java.util.List;

public interface DataService extends CrudRepository<Data, Integer>{
    List<Data> findBySensorId(Integer id);
}
