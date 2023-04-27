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
@TableName("shows")
@ApiModel(value = "Shows对象", description = "")
public class Shows implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE SHOE ID")
    @TableId(value = "s_id", type = IdType.AUTO)
    private Byte sId;

    @ApiModelProperty("SHOW NAME")
    @TableField("name")
    private String name;

    @ApiModelProperty("DESCRIPTION")
    @TableField("des")
    private String des;

    @ApiModelProperty("SHOW TYPE")
    @TableField("stype")
    private String stype;

    @ApiModelProperty("Wheelchair accessible can has only two values Yes or No")
    @TableField("wheel")
    private String wheel;

    @TableField("price")
    private BigDecimal price;
}
