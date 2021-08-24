package zara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zara.model.cadena.Cadena;
import zara.repository.CadenaRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CadenaController {

    @Autowired
    private CadenaRepository cadenaRepository;


    @GetMapping("/cadena")
    public ResponseEntity<List<Cadena>> all() {
        try {
            List<Cadena> cadenaList = this.cadenaRepository.findAll();
            if (cadenaList.isEmpty() || cadenaList.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cadenaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
