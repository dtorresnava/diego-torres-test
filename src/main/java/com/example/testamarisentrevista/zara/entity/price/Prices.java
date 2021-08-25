package com.example.testamarisentrevista.zara.entity.price;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@Setter
@Getter
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "BRAND_ID")
    private  Integer brandId;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "PRICE_LIST")
    private Integer priceList;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    private Integer priority;
    private Double price;
    private String curr;

}
