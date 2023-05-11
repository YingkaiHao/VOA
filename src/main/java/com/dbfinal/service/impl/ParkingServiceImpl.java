package com.dbfinal.service.impl;

import com.dbfinal.VO.ParkingVO;
import com.dbfinal.common.GenerateId;
import com.dbfinal.entity.*;
import com.dbfinal.mapper.CardMapper;
import com.dbfinal.mapper.OrdersMapper;
import com.dbfinal.mapper.ParkingMapper;
import com.dbfinal.mapper.PaymentsMapper;
import com.dbfinal.service.ParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements ParkingService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PaymentsMapper paymentsMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private ParkingMapper parkingMapper;

    @Override
    public Orders buyParking(ParkingVO parkingVO) {
        Timestamp date = parkingVO.getVdate();
        String oId = GenerateId.getId("Order", date);
        String pId = GenerateId.getId("Payment", date);
        String cId = GenerateId.getId("Card", date);
        String parkingId = GenerateId.getId("Parking", date);
        System.out.println(oId + " " + pId + " " + cId);
        Byte a = 1;
        Byte b = 0;

        Card c = new Card();
        c.setCardId(cId);
        c.setCname(parkingVO.getCardName());
        c.setCnumber(parkingVO.getCardNumber());
        c.setEdate(parkingVO.getEdate());
        c.setCardType(parkingVO.getCardType());
        c.setCvv(parkingVO.getCvv());

        cardMapper.insert(c);
        System.out.println("card insert successful");

        Payments p = new Payments();
        p.setPId(pId);
        p.setPdate(parkingVO.getOdate());
        p.setPamount(new BigDecimal(10));
        p.setCash(parkingVO.getMethod().equals("Online") ? b : a);
        p.setCardId(cId);

        paymentsMapper.insert(p);
        System.out.println("payment insert successful");

        Orders o = new Orders();
//        Shows shows = showsMapper.selectById(parkingVO.getSId());
        o.setOId(oId);
        o.setOdate(parkingVO.getOdate());
        o.setQuan(a);
        o.setSource("Parking");
        o.setSid(parkingId);
        o.setPrice(new BigDecimal(10));
        o.setVId(parkingVO.getVId());
        o.setPId(pId);

        ordersMapper.insert(o);
        System.out.println("order insert successful");

        int cur = new Random().nextInt(1000);
//        Timestamp t = parkingVO.getVdate();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(t);
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), calendar.get(Calendar.HOUR) + 1, calendar.get(Calendar.MINUTE));
//        System.out.println((Timestamp) calendar.getTime());
        Parking parking = new Parking();
        parking.setPaId(parkingId);
        parking.setLot("A");
        parking.setSnum((short) cur);
        parking.setItime(parkingVO.getVdate());
        parking.setOtime(parkingVO.getVdate());
        parking.setFee(new BigDecimal(10));
        parking.setOId(oId);
        parkingMapper.insert(parking);
        System.out.println("parking insert successful");

        return o;
    }
}
