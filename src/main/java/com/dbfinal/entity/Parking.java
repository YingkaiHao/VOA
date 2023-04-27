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
@TableName("parking")
@ApiModel(value = "Parking对象", description = "")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE PARKING ID")
    @TableId(value = "pa_id", type = IdType.AUTO)
    private String paId;

    @ApiModelProperty("PARKING LOT SUCH AS A, B, C AND ETC")
    @TableField("lot")
    private String lot;

    @ApiModelProperty("SPOT NUMBER")
    @TableField("snum")
    private Short snum;

    @ApiModelProperty("TIME IN")
    @TableField("itime")
    private Timestamp itime;

    @ApiModelProperty("TIME OUT")
    @TableField("otime")
    private Timestamp otime;

    @ApiModelProperty("ONE DAY PARKING FEE")
    @TableField("fee")
    private BigDecimal fee;

    @TableField("o_id")
    private String oId;
}
