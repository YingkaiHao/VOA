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
@TableName("orders")
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE ORDER ID")
    @TableId(value = "o_id", type = IdType.AUTO)
    private String oId;

    @ApiModelProperty("ORDER DATE")
    @TableField("odate")
    private Timestamp odate;

    @ApiModelProperty("ORDER QUANTITY")
    @TableField("quan")
    private Byte quan;

    @ApiModelProperty("ORDER SOURCE SUCH AS TICKET, SHOW, STORE, PARKING")
    @TableField("source")
    private String source;

    @ApiModelProperty("SOURCE ID")
    @TableField("sid")
    private String sid;

    @ApiModelProperty("ORDER PRICE")
    @TableField("price")
    private BigDecimal price;

    @TableField("v_id")
    private Long vId;

    @TableField("p_id")
    private String pId;
}
