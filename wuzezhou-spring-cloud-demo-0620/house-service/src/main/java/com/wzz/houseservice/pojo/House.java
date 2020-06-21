package com.wzz.houseservice.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 吴泽洲
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_house")
public class House implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    /**
     * 省
     */
    @TableField("province")
    private Integer province;

    /**
     * 市
     */
    @TableField("city")
    private Integer city;

    /**
     * 区
     */
    @TableField("county")
    private Integer county;

    /**
     * 小区名称
     */
    @TableField("community")
    private String community;

    /**
     * 几室
     */
    @TableField("room")
    private Integer room;

    /**
     * 几厅
     */
    @TableField("hall")
    private Integer hall;

    /**
     * 几卫
     */
    @TableField("toilet")
    private Integer toilet;

    /**
     * 房屋朝向
     */
    @TableField("orientation")
    private String orientation;

    /**
     * 装修类型
     */
    @TableField("decorate")
    private Integer decorate;

    /**
     * 每月租金
     */
    @TableField("rent")
    private BigDecimal rent;

    /**
     * 图片
     */
    @TableField("pic")
    private String pic;

    /**
     * 房屋介绍
     */
    @TableField("introduction")
    private String introduction;

    /**
     * 面积
     * */
    @TableField("area")
    private Integer area;

    @TableField(exist = false)
    private BigDecimal lastRent;

    @TableField(exist = false)
    private String decorateName;

}
