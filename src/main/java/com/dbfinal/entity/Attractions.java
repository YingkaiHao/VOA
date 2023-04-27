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
@TableName("attractions")
@ApiModel(value = "Attractions对象", description = "")
public class Attractions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE ATTRACTION ID")
    @TableId(value = "a_id", type = IdType.AUTO)
    private Byte aId;

    @ApiModelProperty("ATTRACTION NAME")
    @TableField("name")
    private String name;

    @ApiModelProperty("ATTRACTION DESCTIPTION")
    @TableField("des")
    private String des;

    @ApiModelProperty("ATTRACTION TYPE")
    @TableField("atype")
    private String atype;

    @ApiModelProperty("ATTRACTION STATUS")
    @TableField("status")
    private String status;

    @ApiModelProperty("ATTRACTION CAPACITY")
    @TableField("capacity")
    private Byte capacity;

    @ApiModelProperty("MININUM HEIGHT (CM)")
    @TableField("mheight")
    private Short mheight;

    @ApiModelProperty("ATTRACTION DURATOIN (MIN)")
    @TableField("dur")
    private Byte dur;

    @ApiModelProperty("LOCATION SECTION CAN BE LOTA, LOTB, LOTC, AND ETC")
    @TableField("loc")
    private String loc;
}
