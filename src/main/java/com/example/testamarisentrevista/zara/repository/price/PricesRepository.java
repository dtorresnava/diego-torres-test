package com.example.testamarisentrevista.zara.repository.price;

import com.example.testamarisentrevista.zara.entity.price.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

    List<Prices> findByProductIdAndBrandIdAndStartDate(Integer productId, Integer brandId, Date date);

    List<Prices> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Integer productId, Integer brandId, Date startDate, Date endDate);
}
