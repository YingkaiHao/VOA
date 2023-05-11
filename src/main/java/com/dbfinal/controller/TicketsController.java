package com.dbfinal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dbfinal.VO.TicketsVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Tickets;
import com.dbfinal.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@RestController
@RequestMapping("/tickets")
public class TicketsController {


    @Autowired
    private TicketsService ticketsService;

    @PostMapping("/buytickets")
    public Result buyTickets(@RequestBody TicketsVO ticketsVO) {
        try {
            Orders o = ticketsService.buyTickets(ticketsVO);
            return Result.success(200, "Purchase successful!", o);
        } catch (Exception e) {
            return Result.fail("Ticket Purchase Failure!");
        }
    }

    @GetMapping("/showTicketsById")
    public Result showTicketsById(Long visitorId) {
        return ticketsService.getTicketById(visitorId);
    }

}
