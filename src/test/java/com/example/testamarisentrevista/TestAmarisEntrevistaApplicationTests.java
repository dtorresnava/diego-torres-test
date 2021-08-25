package com.example.testamarisentrevista;

import com.example.testamarisentrevista.zara.entity.Cadena;
import com.example.testamarisentrevista.zara.repository.CadenaRepository;
import com.example.testamarisentrevista.zara.service.CadenaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
class TestAmarisEntrevistaApplicationTests {

    @Autowired
    private CadenaService cadenaService;

    @Test
    void getAllCadenasTest() {
        List<Cadena> cadenaList = this.cadenaService.getCadenaList();
        Assertions.assertTrue(cadenaList.size() > 0);
    }

}
