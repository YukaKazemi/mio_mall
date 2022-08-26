package com.mio.mall.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @description: 订单超时取消并解锁库存的定时器
 * 用户对某商品进行下单操作；
 * 系统需要根据用户购买的商品信息生成订单并锁定商品的库存；
 * 系统设置了60分钟用户不付款就会取消订单；
 * 开启一个定时任务，每隔10分钟检查下，如果有超时还未付款的订单，就取消订单并取消锁定的商品库存。
 * #整合S
 * @author: miosakura
 * @date: 2022-08-26 12:03
 */
public class OrderTimeOutCancelTask {
    private Logger LOGGER= LoggerFactory.getLogger(OrderTimeOutCancelTask.class);
    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        // TODO: 2019/5/3 此处应调用取消订单的方法，具体查看mall项目源码
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }

}
