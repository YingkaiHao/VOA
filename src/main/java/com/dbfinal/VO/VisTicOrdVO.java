package com.dbfinal.VO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VisTicOrdVO {

    private Byte visitorId;

    private String ticketsId;

    private String orderId;

    private BigDecimal price;

}
