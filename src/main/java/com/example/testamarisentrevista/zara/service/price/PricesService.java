package com.example.testamarisentrevista.zara.service.price;

import com.example.testamarisentrevista.zara.entity.price.Prices;
import com.example.testamarisentrevista.zara.repository.price.PricesRepository;
import com.example.testamarisentrevista.zara.request.PricesRequest;
import com.example.testamarisentrevista.zara.response.PricesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PricesService {

    private static final String PATTERN = "yyyy-MM-dd hh:mm:ss.SS";

    @Autowired
    private PricesRepository pricesRepository;

    public List<PricesResponse> getAllPrices() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Prices> pricesList = this.pricesRepository.findAll();
        return objectMapper.convertValue(pricesList, new TypeReference<List<PricesResponse>>() {});
    }

    public List<PricesResponse> getPricesWithParams(PricesRequest pricesRequest) throws ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new SimpleDateFormat(PATTERN).parse(pricesRequest.getStartDate());
        List<Prices> pricesList = this.pricesRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                pricesRequest.getProductId(), pricesRequest.getBrandId(), date, date);
        return objectMapper.convertValue(pricesList, new TypeReference<List<PricesResponse>>() {});
    }

    public PricesResponse getOne(Integer id) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<Prices> prices = this.pricesRepository.findById(id);
        return prices.map(value -> objectMapper.convertValue(value, PricesResponse.class)).orElse(null);
    }
}
