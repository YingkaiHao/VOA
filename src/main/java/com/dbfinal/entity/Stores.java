package com.dbfinal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yingkai Hao
 * @since 2023-04-27 02:44:50
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("stores")
@ApiModel(value = "Stores对象", description = "")
public class Stores implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE STORE ID")
    @TableId(value = "st_id", type = IdType.AUTO)
    private Short stId;

    @ApiModelProperty("STORE NAME")
    @TableField("name")
    private String name;

    @ApiModelProperty("CATEGORY CAN BE FOOD STALL, ICECREAM PARLOT, RESTRAURAUT, GIFT SHOP, APPARELS")
    @TableField("cate")
    private String cate;

    @ApiModelProperty("DESCRIPTION")
    @TableField("des")
    private String des;
}
