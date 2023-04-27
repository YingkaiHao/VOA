package com.dbfinal.controller;

import com.dbfinal.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/attractions")
public class AttractionsController {

    @Autowired
    AttractionsService attractionsService;

    @GetMapping("/index")
    public Object index() {
        return attractionsService.getById(1L);
    }

}
