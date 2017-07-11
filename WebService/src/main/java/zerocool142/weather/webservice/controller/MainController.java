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

@RestController
public class MainController {

    @Autowired
    DataService ds;
    @Autowired
    SensorService ss;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<?> info() {
        return ResponseEntity.ok(ds.findAll());
    }

    @RequestMapping(path = "/data/add/{sensorId}", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Data data,
                                 @PathVariable Integer sensorId){
        Sensor s = ss.findOne(sensorId);
        if (s==null) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("Sensor not found!"));
        data.setSensor(s);
        if (data.getDate() == null) data.setDate(Calendar.getInstance().getTime());
        return ResponseEntity.ok(ds.save(data));
    }
}
