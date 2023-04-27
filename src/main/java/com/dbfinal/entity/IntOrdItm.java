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
@TableName("int_ord_itm")
@ApiModel(value = "IntOrdItm对象", description = "")
public class IntOrdItm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE GOODS ID")
    @TableId(value = "g_id", type = IdType.AUTO)
    private String gId;

    @TableField("o_id")
    private String oId;

    @TableField("i_id")
    private Integer iId;

    @TableField("st_id")
    private Short stId;
}
