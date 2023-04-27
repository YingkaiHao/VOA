package com.dbfinal.service.impl;

import com.dbfinal.entity.Payments;
import com.dbfinal.mapper.PaymentsMapper;
import com.dbfinal.service.PaymentsService;
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
public class PaymentsServiceImpl extends ServiceImpl<PaymentsMapper, Payments> implements PaymentsService {

}
