package com.dbfinal.service;

import com.dbfinal.VO.TicketsVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Tickets;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
public interface TicketsService extends IService<Tickets> {

    Orders buyTickets(TicketsVO ticketsVO);

    Result getTicketById(Long visitorId);
}
