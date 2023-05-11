package com.dbfinal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dbfinal.VO.TicketsVO;
import com.dbfinal.common.GenerateId;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Card;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Payments;
import com.dbfinal.entity.Tickets;
import com.dbfinal.mapper.CardMapper;
import com.dbfinal.mapper.OrdersMapper;
import com.dbfinal.mapper.PaymentsMapper;
import com.dbfinal.mapper.TicketsMapper;
import com.dbfinal.service.TicketsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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
public class TicketsServiceImpl extends ServiceImpl<TicketsMapper, Tickets> implements TicketsService {

    @Autowired
    private TicketsMapper ticketsMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PaymentsMapper paymentsMapper;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public Orders buyTickets(TicketsVO ticketsVO) {
        Timestamp date = ticketsVO.getVdate();
        String tId = GenerateId.getId("Tickets", date);
        String oId = GenerateId.getId("Order", date);
        String pId = GenerateId.getId("Payment", date);
        String cId = GenerateId.getId("Card", date);
//        System.out.println(tId + " " + oId + " " + pId + " " + cId);
        Byte a = 1;
        Byte b = 0;

        Card c = new Card();
        c.setCardId(cId);
        c.setCname(ticketsVO.getCardName());
        c.setCnumber(ticketsVO.getCardNumber());
        c.setEdate(ticketsVO.getEdate());
        c.setCardType(ticketsVO.getCardType());
        c.setCvv(ticketsVO.getCvv());

        cardMapper.insert(c);
//        System.out.println("card insert successful");

        Payments p = new Payments();
        p.setPId(pId);
        p.setPdate(ticketsVO.getPdate());
        p.setPamount(new BigDecimal(100));
        p.setCash(ticketsVO.getMethod().equals("Online") ? b : a);
        p.setCardId(cId);

        paymentsMapper.insert(p);
//        System.out.println("payment insert successful");

        Orders o = new Orders();
        o.setOId(oId);
        o.setOdate(ticketsVO.getOdate());
        o.setQuan(a);
        o.setSource("Tickets");
        o.setSid(tId);
        o.setPrice(new BigDecimal(100));
        o.setVId(ticketsVO.getVId());
        o.setPId(pId);

        ordersMapper.insert(o);
//        System.out.println("order insert successful");

        String d = String.valueOf(ticketsVO.getVdate());
        TicketsServiceImpl tsi = new TicketsServiceImpl();
        Byte who = tsi.isWeekend(d) ? (byte)1 : (byte)0;

        Tickets t = new Tickets();
        t.setTId(tId);
        t.setMethod(ticketsVO.getMethod());
        t.setPdate(ticketsVO.getPdate());
        t.setVdate(ticketsVO.getVdate());
        t.setVId(ticketsVO.getVId());
        t.setOId(oId);
        t.setTtype(ticketsVO.getTtype());
        t.setPrice(new BigDecimal(100));
        t.setWhornot(who);
        t.setDiscount(new BigDecimal(0));

        ticketsMapper.insert(t);
//        System.out.println("ticket insert successful");

        Tickets curT = ticketsMapper.selectById(tId);
        o.setPrice(curT.getPrice());
        p.setPamount(curT.getPrice());
        ordersMapper.updateById(o);
        paymentsMapper.updateById(p);

        return o;
    }

    @Override
    public Result getTicketById(Long visitorId) {
        List<Tickets> ticketsList = ticketsMapper.selectList(new QueryWrapper<Tickets>()
                .eq("v_id", visitorId));
        if (ticketsList.isEmpty() || ticketsList.size() == 0) {
            return Result.fail("No tickets history");
        }
        return Result.success(200, "Search tickets history Success", ticketsList);
    }

    public boolean isWeekend(String startTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(startTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
            return true;
        }
        return false;
    }
}
