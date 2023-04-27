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
@TableName("tickets")
@ApiModel(value = "Tickets对象", description = "")
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE TICKET ID")
    @TableId(value = "t_id", type = IdType.AUTO)
    private String tId;

    @ApiModelProperty("Ticket method: online or onsite")
    @TableField("method")
    private String method;

    @ApiModelProperty("PURCHASE DATE")
    @TableField("pdate")
    private Timestamp pdate;

    @ApiModelProperty("VISIT DATE")
    @TableField("vdate")
    private Timestamp vdate;

    @ApiModelProperty("TICKET TYPE IS AMONG CHILD, ADULT, SENIOR, AND MEMBER")
    @TableField("ttype")
    private String ttype;

    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("Weekends or holidays or not")
    @TableField("whornot")
    private Byte whornot;

    @ApiModelProperty("DISCOUNT")
    @TableField("discount")
    private BigDecimal discount;

    @TableField("v_id")
    private Long vId;

    @TableField("o_id")
    private String oId;
}
