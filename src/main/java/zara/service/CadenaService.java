package zara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zara.model.cadena.Cadena;
import zara.repository.CadenaRepository;

import java.util.List;

@Service
public class CadenaService {

    @Autowired
    CadenaRepository cadenaRepository;


    public List<Cadena> all() {
        return this.cadenaRepository.findAll();
    }
}
