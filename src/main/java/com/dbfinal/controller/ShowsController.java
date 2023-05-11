package com.dbfinal.controller;

import com.dbfinal.VO.ShowsVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Shows;
import com.dbfinal.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@RestController
@RequestMapping("/shows")
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @GetMapping("/getAllShows")
    public Result getAllShows() {
        List<Shows> showsList = showsService.getAllShows();
        return Result.success(200, "Get shows successful", showsList);
    }

    @PostMapping("/buyShows")
    public Result buyShows(@RequestBody ShowsVO showsVO) {
        try {
            Orders o = showsService.buyShows(showsVO);
            return Result.success(200, "Purchase successful!", o);
        } catch (Exception e) {
            return Result.fail("Ticket Purchase Failure!");
        }
    }

}
