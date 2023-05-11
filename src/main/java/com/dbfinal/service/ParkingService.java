package com.dbfinal.service;

import com.dbfinal.VO.ParkingVO;
import com.dbfinal.entity.Orders;
import com.dbfinal.entity.Parking;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
public interface ParkingService extends IService<Parking> {

    Orders buyParking(ParkingVO parkingVO);
}
