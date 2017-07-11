package zerocool142.weather.webservice.service;

import org.springframework.data.repository.CrudRepository;
import zerocool142.weather.webservice.entity.Data;

public interface DataService extends CrudRepository<Data, Integer>{

}
