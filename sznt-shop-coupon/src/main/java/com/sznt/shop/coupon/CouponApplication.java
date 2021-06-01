package com.sznt.shop.coupon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 优惠券服务
 *
 * @author S Mr.L 
 * @since 2021-06-01
 */
@Slf4j
@SpringBootApplication
public class CouponApplication {
    public static void main(String[] args) {
        log.info("===sznt-coupon 优惠券服务开始启动===");
        new SpringApplicationBuilder(CouponApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        log.info("===sznt-coupon 优惠券服务开始启动===");
    }
}
