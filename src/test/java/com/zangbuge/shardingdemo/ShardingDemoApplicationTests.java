package com.zangbuge.shardingdemo;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zangbuge.shardingdemo.torder.TOrder;
import com.zangbuge.shardingdemo.torder.TOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShardingDemoApplicationTests {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void insertTest() {
        TOrder order = new TOrder();
        // 数据库：userId 偶数分到 sharding-order，奇数分到 sharding-order1
        order.setUserId(19);
        // 表：id 偶数分到 t_order_1, 奇数分到 t_order_2
        order.setId(2L);
        order.setOrderAmount(BigDecimal.TEN);
        order.setOrderStatus(1);
        tOrderMapper.insert(order);
    }

    @Test
    void queryTest() {
        List<TOrder> tOrders = tOrderMapper.selectList(Wrappers.<TOrder>lambdaQuery().eq(TOrder::getId, 2L).eq(TOrder::getUserId, 19L));
        System.out.println(JSONUtil.toJsonStr(tOrders));
    }

}
