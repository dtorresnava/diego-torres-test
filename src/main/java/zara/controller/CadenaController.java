package zara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zara.model.cadena.Cadena;
import zara.repository.CadenaRepository;
import zara.service.CadenaService;

import java.util.List;

@RestController
@RequestMapping("/")
public class CadenaController {

    @Autowired
    CadenaService cadenaService;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Hola mundo";
    }

    @GetMapping("cadena")
    public ResponseEntity<List<Cadena>> all() {
        try {
            List<Cadena> cadenaList = this.cadenaService.all();
            if (cadenaList.isEmpty() || cadenaList.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cadenaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
