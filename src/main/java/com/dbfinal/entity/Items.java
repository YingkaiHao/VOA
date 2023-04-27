package com.dbfinal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("items")
@ApiModel(value = "Items对象", description = "")
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE ITEM ID")
    @TableId(value = "i_id", type = IdType.AUTO)
    private Integer iId;

    @ApiModelProperty("ITEM PRICE")
    @TableField("price")
    private BigDecimal price;

    @TableField("st_id")
    private Short stId;
}
