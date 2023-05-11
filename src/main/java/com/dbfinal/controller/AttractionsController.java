package com.dbfinal.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Attractions;
import com.dbfinal.service.AttractionsService;
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
@RequestMapping("/attractions")
public class AttractionsController {

    @Autowired
    AttractionsService attractionsService;

    @GetMapping("/index")
    public Object index() {
        return attractionsService.getById(1L);
    }

    @GetMapping("/all")
    public Result getSelectedAttractions(Integer curPage) {
        Page page = new Page(curPage, 5);

        IPage ip = attractionsService.page(page, new QueryWrapper<Attractions>());

        return Result.success(ip);
    }

    @PostMapping("/getvisitorTickets")
    public Result getVisitorTickets(@RequestBody Integer curVisitor) {
        return Result.success(null);
    }
}
