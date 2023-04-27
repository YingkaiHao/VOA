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
@TableName("show_time")
@ApiModel(value = "ShowTime对象", description = "")
public class ShowTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE SHOW TIME ID")
    @TableId(value = "s_no", type = IdType.AUTO)
    private Byte sNo;

    @ApiModelProperty("START TIME")
    @TableField("stime")
    private Timestamp stime;

    @ApiModelProperty("END TIME")
    @TableField("etime")
    private Timestamp etime;

    @TableField("s_id")
    private Byte sId;
}
