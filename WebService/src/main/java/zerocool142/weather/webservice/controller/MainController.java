package zerocool142.weather.webservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<?> info() {
        return ResponseEntity.ok("Ok");
    }
}
