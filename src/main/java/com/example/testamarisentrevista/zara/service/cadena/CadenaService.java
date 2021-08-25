package com.example.testamarisentrevista.zara.service.cadena;

import com.example.testamarisentrevista.zara.entity.cadena.Cadena;
import com.example.testamarisentrevista.zara.repository.cadena.CadenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadenaService {

    @Autowired
    private CadenaRepository cadenaRepository;

    public List<Cadena> getCadenaList() {
        return this.cadenaRepository.findAll();
    }
}
