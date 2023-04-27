package com.dbfinal.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("int_tic_atr")
@ApiModel(value = "IntTicAtr对象", description = "")
public class IntTicAtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("START TIME")
    @TableField("stime")
    private Timestamp stime;

    @TableField("t_id")
    private String tId;

    @TableField("a_id")
    private Byte aId;
}
