package com.dbfinal.VO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ShowsVO {

    private Byte sId;

    private String method;

    private Timestamp vdate;

    private Long vId;

    private Timestamp odate;

    private String cardName;

    private String cardNumber;

    private Timestamp edate;

    private Short cvv;

    private String cardType;

    private int quantity;

}
