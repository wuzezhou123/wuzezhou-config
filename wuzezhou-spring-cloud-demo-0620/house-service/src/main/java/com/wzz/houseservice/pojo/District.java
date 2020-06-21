package com.wzz.houseservice.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_district")
public class District implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("parent")
    private Integer parent;


}
