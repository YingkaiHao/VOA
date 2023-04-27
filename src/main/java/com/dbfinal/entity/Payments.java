package com.dbfinal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
@TableName("payments")
@ApiModel(value = "Payments对象", description = "")
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE PAYMENT ID")
    @TableId(value = "p_id", type = IdType.AUTO)
    private String pId;

    @ApiModelProperty("PAYMENT DATE")
    @TableField("pdate")
    private Timestamp pdate;

    @ApiModelProperty("PAYMENT AMOUNT")
    @TableField("pamount")
    private BigDecimal pamount;

    @ApiModelProperty("CASH OR NOT : 1 represent cast, 0 represent other")
    @TableField("cash")
    private Byte cash;

    @TableField("card_id")
    private String cardId;
}
