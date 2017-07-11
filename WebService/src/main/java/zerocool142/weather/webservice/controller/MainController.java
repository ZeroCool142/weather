package zerocool142.weather.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerocool142.weather.webservice.entity.Data;
import zerocool142.weather.webservice.entity.Sensor;
import zerocool142.weather.webservice.service.DataService;
import zerocool142.weather.webservice.service.SensorService;
import zerocool142.weather.webservice.util.ErrorResponse;

import java.util.Calendar;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    DataService dataService;
    @Autowired
    SensorService sensorService;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<?> info() {
        return ResponseEntity.ok(dataService.findAll());
    }

    @RequestMapping(path = "/{sensorId}", method = RequestMethod.GET)
    public ResponseEntity<?> infoBySensor(@PathVariable Integer sensorId) {
        List<Data> dataList = dataService.findBySensorId(sensorId);
        if (dataList == null || dataList.size()==0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Sensor not found!"));
        return ResponseEntity.ok(dataList);
    }

    @RequestMapping(path = "/data/add/{sensorId}", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Data data,
                                 @PathVariable Integer sensorId){
        Sensor s = sensorService.findOne(sensorId);
        if (s==null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("Sensor not found!"));
        data.setSensor(s);
        if (data.getDate() == null) data.setDate(Calendar.getInstance().getTime());
        return ResponseEntity.ok(dataService.save(data));
    }
}
