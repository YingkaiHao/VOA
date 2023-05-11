package com.dbfinal.controller;

import com.dbfinal.VO.OrderVO;
import com.dbfinal.common.Result;
import com.dbfinal.service.OrdersService;
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
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/showOrdersById")
    public Result showOrdersById(Long visitorId) {
        return ordersService.getTicketById(visitorId);
    }

    @PostMapping("/showOrderByIdEMP")
    public Result showOrderByIdEMP(@RequestBody OrderVO orderVO) {
        return ordersService.getTicketsByIdEMP(orderVO.getVisitorId());
    }

}
