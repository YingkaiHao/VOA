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
@TableName("summary")
@ApiModel(value = "Summary对象", description = "")
public class Summary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "summary_id", type = IdType.AUTO)
    private Long summaryId;

    @TableField("v_id")
    private Long vId;

    @TableField("v_date")
    private Timestamp vDate;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("sce")
    private String sce;

    @TableField("s_id")
    private String sId;
}
