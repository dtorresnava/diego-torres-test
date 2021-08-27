package com.example.testamarisentrevista.zara.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricesRequest {
    private Integer productId;
    private Integer brandId;
    private String startDate;
}
