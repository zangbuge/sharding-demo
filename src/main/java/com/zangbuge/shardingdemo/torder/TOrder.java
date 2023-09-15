package com.zangbuge.shardingdemo.torder;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("t_order")
public class TOrder {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer userId;

}
