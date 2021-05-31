package com.sznt.shop.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 用户服务
 *
 * @author S Mr.L 
 * @since 2021-05-31
 */
@Slf4j
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        log.info("===sznt-shop 用户服务开始启动===");
        new SpringApplicationBuilder(UserApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
        log.info("===sznt-shop 用户服务启动成功===");
    }
}
