package com.dbfinal.controller;

import com.dbfinal.VO.LoginVO;
import com.dbfinal.VO.OrderVO;
import com.dbfinal.VO.VisitorVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Visitors;
import com.dbfinal.exception.InvalidCredentialException;
import com.dbfinal.service.VisitorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-05-02 04:22:32
 */
@RestController
//@RequestMapping("/visitors")
public class VisitorsController {

    @Autowired
    private VisitorsService visitorsService;

    @PostMapping("/register")
    public Result register(@RequestBody Visitors visitors) {
        return visitorsService.registorUser(visitors);
    }

    @PostMapping("/registerEMP")
    public Result registerEMP(@RequestBody Visitors visitors) {
        return visitorsService.registorUser(visitors);
    }

    @PostMapping("/login")
    public Result login(@RequestBody VisitorVO visitorVO) {
        try {
            Visitors user = visitorsService.loginUser(visitorVO);
            String token = visitorsService.getToken(user);
            LoginVO l = new LoginVO();
            l.setVisitors(user);
            l.setToken(token);
            if (user.getIsEmployee()) {
                return Result.success(200, "Employee", l);
            } else {
                return Result.success(200, "Customer", l);
            }
        } catch (Exception e) {
            return Result.fail("Incorrect Credential.");
        }
    }

    @PostMapping("/searchVInfo")
    public Result searchVInfo(@RequestBody OrderVO orderVO) {
        Visitors v = visitorsService.getById(orderVO.getVisitorId());
        List<Visitors> l = new ArrayList<>();
        l.add(v);
        if (v == null) {
            return Result.fail(200, "The user doesn't exist!", l);
        }
        return Result.success(200, "Find user success!", l);
    }

//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login"; // Return the name of the login page view
//    }
//
//    @GetMapping("/register")
//    public String showRegisterForm() {
//        return "register"; // Return the name of the register page view
//    }
}
