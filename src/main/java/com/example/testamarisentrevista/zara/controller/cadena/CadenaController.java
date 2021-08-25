package com.example.testamarisentrevista.zara.controller.cadena;

import com.example.testamarisentrevista.zara.entity.cadena.Cadena;
import com.example.testamarisentrevista.zara.service.cadena.CadenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-zara")
public class CadenaController {

    @Autowired
    CadenaService cadenaService;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Hola mundo";
    }

    @GetMapping("/cadenas")
    public ResponseEntity<List<Cadena>> all() {
        try {
            List<Cadena> cadenaList = this.cadenaService.getCadenaList();
            if (cadenaList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cadenaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
