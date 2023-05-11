package com.dbfinal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dbfinal.VO.ShowsVO;
import com.dbfinal.common.GenerateId;
import com.dbfinal.common.Result;
import com.dbfinal.entity.*;
import com.dbfinal.mapper.*;
import com.dbfinal.service.ShowsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@Service
public class ShowsServiceImpl extends ServiceImpl<ShowsMapper, Shows> implements ShowsService {

    @Autowired
    private ShowTimeMapper showTimeMapper;

    @Autowired
    private ShowsMapper showsMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PaymentsMapper paymentsMapper;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public Result getShowByDate(Date date) {
        return null;
    }

    @Override
    public List<Shows> getAllShows() {
        List<Shows> showsList = showsMapper.selectList(new QueryWrapper<Shows>());
        return showsList;
    }

    @Override
    public Orders buyShows(ShowsVO showsVO) {

        Timestamp date = showsVO.getVdate();
        String oId = GenerateId.getId("Order", date);
        String pId = GenerateId.getId("Payment", date);
        String cId = GenerateId.getId("Card", date);
//        System.out.println(tId + " " + oId + " " + pId + " " + cId);
        Byte a = 1;
        Byte b = 0;

        Card c = new Card();
        c.setCardId(cId);
        c.setCname(showsVO.getCardName());
        c.setCnumber(showsVO.getCardNumber());
        c.setEdate(showsVO.getEdate());
        c.setCardType(showsVO.getCardType());
        c.setCvv(showsVO.getCvv());

        cardMapper.insert(c);
//        System.out.println("card insert successful");

        Payments p = new Payments();
        p.setPId(pId);
        p.setPdate(showsVO.getOdate());
        p.setPamount(new BigDecimal(100));
        p.setCash(showsVO.getMethod().equals("Online") ? b : a);
        p.setCardId(cId);

        paymentsMapper.insert(p);
//        System.out.println("payment insert successful");

        Orders o = new Orders();
        Shows shows = showsMapper.selectById(showsVO.getSId());
        o.setOId(oId);
        o.setOdate(showsVO.getOdate());
        o.setQuan((byte) showsVO.getQuantity());
        o.setSource("Shows");
        o.setSid(String.valueOf(showsVO.getSId()));
        o.setPrice(shows.getPrice().multiply(new BigDecimal(showsVO.getQuantity())));
        o.setVId(showsVO.getVId());
        o.setPId(pId);

        ordersMapper.insert(o);
//        System.out.println("order insert successful");
        p.setPamount(o.getPrice());
        paymentsMapper.updateById(p);

        return o;
    }
}
