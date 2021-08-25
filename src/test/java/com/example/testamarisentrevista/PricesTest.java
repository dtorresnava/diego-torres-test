package com.example.testamarisentrevista;

import com.example.testamarisentrevista.zara.entity.price.Prices;
import com.example.testamarisentrevista.zara.service.price.PricesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class PricesTest {

    @Autowired
    private PricesService pricesService;

    @Test
    void getAllPricesTest() {

        List<Prices> pricesList = this.pricesService.getPricesWithParams();
    }

}
