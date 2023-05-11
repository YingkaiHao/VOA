package com.dbfinal.service;

import com.dbfinal.VO.VisitorVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Visitors;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-05-02 04:22:32
 */
public interface VisitorsService extends IService<Visitors> {

    Result registorUser(Visitors visitors);

    Visitors loginUser(VisitorVO visitorVO);

    String getToken(Visitors user);
}
