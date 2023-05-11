package com.dbfinal.service.impl;

import com.dbfinal.VO.ItemVO;
import com.dbfinal.common.GenerateId;
import com.dbfinal.entity.*;
import com.dbfinal.mapper.CardMapper;
import com.dbfinal.mapper.ItemsMapper;
import com.dbfinal.mapper.OrdersMapper;
import com.dbfinal.mapper.PaymentsMapper;
import com.dbfinal.service.ItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemsService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PaymentsMapper paymentsMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public Orders buyStoreItem(ItemVO itemVO) {
        Timestamp date = itemVO.getVdate();
        String oId = GenerateId.getId("Order", date);
        String pId = GenerateId.getId("Payment", date);
        String cId = GenerateId.getId("Card", date);
        System.out.println(oId + " " + pId + " " + cId);
        Byte a = 1;
        Byte b = 0;

        if (itemVO.getCashOrCard().equals("Card")) {
            Card c = new Card();
            c.setCardId(cId);
            c.setCname(itemVO.getCardName());
            c.setCnumber(itemVO.getCardNumber());
            c.setEdate(itemVO.getEdate());
            c.setCardType(itemVO.getCardType());
            c.setCvv(itemVO.getCvv());

            cardMapper.insert(c);
            System.out.println("card insert successful");
        }

        Payments p = new Payments();
        Items i = itemsMapper.selectById(itemVO.getSId());
        p.setPId(pId);
        p.setPdate(itemVO.getOdate());
        p.setPamount(i.getPrice().multiply(new BigDecimal(itemVO.getQuantity())));
        p.setCash(itemVO.getCashOrCard().equals("Cash") ? b : a);
        p.setCardId(p.getCash() == a ? cId : null);

        paymentsMapper.insert(p);
        System.out.println("payment insert successful");

        Orders o = new Orders();
        o.setOId(oId);
        o.setOdate(itemVO.getOdate());
        o.setQuan((byte) itemVO.getQuantity());
        o.setSource("Stores");
        o.setSid(String.valueOf(itemVO.getSId()));
        o.setPrice(i.getPrice().multiply(new BigDecimal(itemVO.getQuantity())));
        o.setVId(itemVO.getVId());
        o.setPId(pId);

        ordersMapper.insert(o);
        System.out.println("order insert successful");

        return o;
    }
}
