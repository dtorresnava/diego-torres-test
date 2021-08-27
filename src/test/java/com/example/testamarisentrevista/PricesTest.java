package com.example.testamarisentrevista;

import com.example.testamarisentrevista.zara.repository.price.PricesRepository;
import com.example.testamarisentrevista.zara.request.PricesRequest;
import com.example.testamarisentrevista.zara.response.PricesResponse;
import com.example.testamarisentrevista.zara.service.price.PricesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PricesRepository pricesRepositoryTest;

    @Test
    void search() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS").parse("2020-06-14 10:00:00.00");
        this.pricesRepositoryTest.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(35455, 1, date, date);
    }

    @Test
    void getAllPricesTest() {
        String url = "http://localhost:" + port + "/api-zara/prices/all";
        List<PricesResponse> pricesList = Arrays.stream(this.restTemplate.getForObject(url, PricesResponse[].class)).collect(Collectors.toList());
        Assertions.assertTrue(pricesList.size() > 0);
    }

    @Test
    void getAllPriceWithIdAndTestResponseData() throws ParseException {
        String url = "http://localhost:" + port + "/api-zara/prices/one/1";
        PricesResponse pricesResponse = this.restTemplate.getForObject(url, PricesResponse.class);
        Assertions.assertTrue(pricesResponse != null);
        Assertions.assertEquals(35.50, pricesResponse.getPrice());
        Assertions.assertEquals(35455, pricesResponse.getProductId());
        Assertions.assertEquals(1, pricesResponse.getBrandId());
        Assertions.assertEquals(35455, pricesResponse.getProductId());

        Date expectedstartDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS").parse("2020-06-14 00:00:00.00");
        Assertions.assertEquals(expectedstartDate, pricesResponse.getStartDate());
        Date expectedsendDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS").parse("2020-12-31 23:59:59.00");
        Assertions.assertEquals(expectedsendDate, pricesResponse.getEndDate());

    }

    @Test
    public void searchPricesWithParamsProdictIdBrandIdAndDate() {
        List<PricesResponse> pricesResponseList;
        PricesRequest pricesRequest = PricesRequest.builder()
                .brandId(1)
                .productId(35455)
                .build();
        String url = "http://localhost:" + port + "/api-zara/prices/search";


        // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        pricesRequest.setStartDate("2020-06-14 10:00:00.00");

        pricesResponseList = Arrays.stream(Objects.requireNonNull(this.restTemplate.postForEntity(url, pricesRequest, PricesResponse[].class).getBody())).collect(Collectors.toList());
        Assertions.assertTrue(pricesResponseList.size() == 1);

        // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        pricesRequest.setStartDate("2020-06-14 16:00:00.00");

        pricesResponseList = Arrays.stream(Objects.requireNonNull(this.restTemplate.postForEntity(url, pricesRequest, PricesResponse[].class).getBody())).collect(Collectors.toList());
        Assertions.assertTrue(pricesResponseList.size() == 2);


        // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        pricesRequest.setStartDate("2020-06-14 21:00:00.00");

        pricesResponseList = Arrays.stream(Objects.requireNonNull(this.restTemplate.postForEntity(url, pricesRequest, PricesResponse[].class).getBody())).collect(Collectors.toList());
        Assertions.assertTrue(pricesResponseList.size() == 1);

        // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        pricesRequest.setStartDate("2020-06-15 10:00:00.00");

        pricesResponseList = Arrays.stream(Objects.requireNonNull(this.restTemplate.postForEntity(url, pricesRequest, PricesResponse[].class).getBody())).collect(Collectors.toList());
        Assertions.assertTrue(pricesResponseList.size() == 2);

        // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        pricesRequest.setStartDate("2020-06-15 21:00:00.00");

        pricesResponseList = Arrays.stream(Objects.requireNonNull(this.restTemplate.postForEntity(url, pricesRequest, PricesResponse[].class).getBody())).collect(Collectors.toList());
        Assertions.assertTrue(pricesResponseList.size() == 2);
    }

}
