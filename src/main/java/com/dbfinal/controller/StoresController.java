package com.dbfinal.controller;

import com.dbfinal.VO.ItemVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@RestController
@RequestMapping("/stores")
public class StoresController {

    @Autowired
    private ItemsService itemsService;

    @PostMapping("/buyStoreItem")
    public Result buyStoreItem(@RequestBody ItemVO itemVO) {
        try {
            Orders o = itemsService.buyStoreItem(itemVO);
            return Result.success(200, "Purchase successful!", o);
        } catch (Exception e) {
            return Result.fail("Ticket Purchase Failure!");
        }
    }

}
