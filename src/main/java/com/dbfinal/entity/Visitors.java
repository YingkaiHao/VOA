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
@TableName("visitors")
@ApiModel(value = "Visitors对象", description = "")
public class Visitors implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UNIQUE VISITORS ID")
    @TableId(value = "v_id", type = IdType.AUTO)
    private Long vId;

    @ApiModelProperty("FIRST NAME")
    @TableField("fname")
    private String fname;

    @ApiModelProperty("LAST NAME")
    @TableField("lname")
    private String lname;

    @ApiModelProperty("ADDRESS STREET")
    @TableField("street")
    private String street;

    @ApiModelProperty("ADDRESS CITY")
    @TableField("city")
    private String city;

    @ApiModelProperty("ADDRESS STATE")
    @TableField("state")
    private String state;

    @ApiModelProperty("ADDRESS COUNTRY")
    @TableField("country")
    private String country;

    @ApiModelProperty("EMAIL ADDRESS")
    @TableField("email")
    private String email;

    @ApiModelProperty("PHONE NUMBER")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("DATE OF BIRTH")
    @TableField("bdate")
    private Timestamp bdate;

    @ApiModelProperty("VISITOR TYPE")
    @TableField("v_type")
    private String vType;
}
