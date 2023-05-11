package com.dbfinal.VO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ParkingVO {

//    private Byte sId;

    private Timestamp vdate;

    private Long vId;

    private Timestamp odate;

    private String cardName;

    private String cardNumber;

    private Timestamp edate;

    private Short cvv;

    private String cardType;

    private String method;


}
