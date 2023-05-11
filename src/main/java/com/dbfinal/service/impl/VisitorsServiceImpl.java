package com.dbfinal.service.impl;

import com.dbfinal.VO.VisitorVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Visitors;
import com.dbfinal.exception.InvalidCredentialException;
import com.dbfinal.mapper.VisitorsMapper;
import com.dbfinal.service.VisitorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-05-02 04:22:32
 */
@Service
public class VisitorsServiceImpl extends ServiceImpl<VisitorsMapper, Visitors> implements VisitorsService {

    @Autowired
    private VisitorsMapper visitorsMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Result registorUser(Visitors visitors) {
        if (visitorsMapper.selectById(visitors.getVId()) != null) {
            return Result.fail("Register user is already exist!");
        }

        visitors.setPassword(passwordEncoder.encode(visitors.getPassword()));

        visitorsMapper.insert(visitors);
        return Result.success("Register Successful");
    }

    @Override
    public Visitors loginUser(VisitorVO visitorVO) {
        Visitors v = visitorsMapper.selectById(visitorVO.getVisitorId());
        if (v == null || !passwordEncoder.matches(visitorVO.getPassword(), v.getPassword())) {
            Result.fail("Invalid credential");
        }
        return v;
    }

    @Override
    public String getToken(Visitors user) {
        String secretKey = "your_secret_key"; // Replace with a secure secret key
        long expirationTimeInMs = 3600000; // Token will expire after 1 hour (3600000 ms)

        String token = Jwts.builder()
                .setSubject(user.getFname())
                .claim("isEmployee", user.getIsEmployee())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }
}
