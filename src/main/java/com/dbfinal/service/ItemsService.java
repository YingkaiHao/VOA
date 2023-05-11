package com.dbfinal.service;

import com.dbfinal.VO.ItemVO;
import com.dbfinal.entity.Items;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dbfinal.entity.Orders;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
public interface ItemsService extends IService<Items> {

    Orders buyStoreItem(ItemVO itemVO);
}
