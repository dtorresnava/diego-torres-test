package com.example.testamarisentrevista.zara.controller.price;

import com.example.testamarisentrevista.zara.request.PricesRequest;
import com.example.testamarisentrevista.zara.response.PricesResponse;
import com.example.testamarisentrevista.zara.service.price.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-zara/prices")
public class PricesController {

    @Autowired
    PricesService pricesService;

    @PostMapping("/search")
    public @ResponseBody ResponseEntity<List<PricesResponse>> searchPrices(@RequestBody PricesRequest pricesRequest) {
        try {
            List<PricesResponse> pricesResponseList = this.pricesService.getPricesWithParams(pricesRequest);
            if (pricesResponseList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pricesResponseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<List<PricesResponse>> all() {
        try {
            List<PricesResponse> pricesResponseList = this.pricesService.getAllPrices();
            if (pricesResponseList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pricesResponseList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/one/{id}")
    public @ResponseBody ResponseEntity<PricesResponse> one(@PathVariable Integer id) {
        try {
            PricesResponse pricesResponse = this.pricesService.getOne(id);
            if (pricesResponse == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pricesResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
