package com.dbfinal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Tickets;
import com.dbfinal.mapper.OrdersMapper;
import com.dbfinal.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Result getTicketById(Long visitorId) {
        List<Orders> ordersList = ordersMapper.selectList(new QueryWrapper<Orders>()
                .eq("v_id", visitorId));
        Collections.sort(ordersList, new Comparator<Orders>() {
            @Override
            public int compare(Orders o1, Orders o2) {
                return o2.getOdate().compareTo(o1.getOdate());
            }
        });
        if (ordersList.isEmpty() || ordersList.size() == 0) {
            return Result.fail("No tickets history");
        }
        return Result.success(200, "Search tickets history Success", ordersList);
    }

    @Override
    public Result getTicketsByIdEMP(Long visitorId) {
        List<Orders> ordersList = ordersMapper.selectList(new QueryWrapper<Orders>()
                .eq("v_id", visitorId));
        Collections.sort(ordersList, new Comparator<Orders>() {
            @Override
            public int compare(Orders o1, Orders o2) {
                return o2.getOdate().compareTo(o1.getOdate());
            }
        });
        if (ordersList.isEmpty() || ordersList.size() == 0) {
            return Result.fail("No tickets history");
        }
        return Result.success(200, "Search tickets history Success", ordersList);
    }
}
