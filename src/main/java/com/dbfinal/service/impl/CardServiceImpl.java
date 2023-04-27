package com.dbfinal.service.impl;

import com.dbfinal.entity.Card;
import com.dbfinal.mapper.CardMapper;
import com.dbfinal.service.CardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {

}
