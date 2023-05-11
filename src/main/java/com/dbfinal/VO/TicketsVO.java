package com.dbfinal.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
public class TicketsVO {

    private String method;

    private Timestamp pdate;

    private Timestamp vdate;

    private String ttype;

    private Long vId;

    private Timestamp odate;

    private String cardName;

    private String cardNumber;

    private Timestamp edate;

    private Short cvv;

    private String cardType;

}
