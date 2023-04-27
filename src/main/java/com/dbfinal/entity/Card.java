package com.dbfinal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("card")
@ApiModel(value = "Card对象", description = "")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE CARD ID")
    @TableId(value = "card_id", type = IdType.AUTO)
    private String cardId;

    @ApiModelProperty("NAME ON CARD")
    @TableField("cname")
    private String cname;

    @ApiModelProperty("CARD NUMBER")
    @TableField("cnumber")
    private String cnumber;

    @ApiModelProperty("EXPIRATION DATE")
    @TableField("edate")
    private Timestamp edate;

    @ApiModelProperty("CVV NUMBER")
    @TableField("cvv")
    private Short cvv;

    @TableField("card_type")
    private String cardType;
}
