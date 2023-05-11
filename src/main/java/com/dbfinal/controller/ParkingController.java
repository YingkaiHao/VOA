package com.dbfinal.controller;

import com.dbfinal.VO.ParkingVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.service.ParkingService;
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
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/buyParking")
    public Result buyParking(@RequestBody ParkingVO parkingVO) {
        try {
            Orders o = parkingService.buyParking(parkingVO);
            return Result.success(200, "Purchase successful!", o);
        } catch (Exception e) {
            return Result.fail("Parking Purchase Failure!");
        }
    }
}
