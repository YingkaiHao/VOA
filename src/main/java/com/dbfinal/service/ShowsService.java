package com.dbfinal.service;

import com.dbfinal.VO.ShowsVO;
import com.dbfinal.common.Result;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Shows;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
public interface ShowsService extends IService<Shows> {

    Result getShowByDate(Date date);

    List<Shows> getAllShows();

    Orders buyShows(ShowsVO showsVO);
}
