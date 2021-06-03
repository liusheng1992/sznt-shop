package com.sznt.shop.mybatis.resolver;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 解决Mybatis Plus Order By SQL注入问题
 *
 * @author S Mr.L 
 * @since 2021-06-01
 */
@Slf4j
public class SqlFilterArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * sql keywords
     */
    private static final String[] KEYWORDS = {"master", "truncate", "insert", "select", "delete", "update", "declare",
            "alter", "drop", "sleep"};

    /**
     * 判断Controller是否包含page 参数
     * @param parameter 入参
     * @return 是否过滤
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Page.class);
    }

    /**
     * 参数解析
     * @param parameter 入参
     * @param mavContainer model view
     * @param webRequest web相关
     * @param binderFactory 入参解析
     * @return {@link Object}
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if (request == null) {
            return null;
        }

        String[] ascs = request.getParameterValues("ascs");
        String[] descs = request.getParameterValues("descs");
        String current = request.getParameter("current");
        String size = request.getParameter("size");

        Page<?> page = new Page<>();
        if (StrUtil.isNotBlank(current)) {
            page.setCurrent(Long.parseLong(current));
        }

        if (StrUtil.isNotBlank(size)) {
            page.setSize(Long.parseLong(size));
        }

        List<OrderItem> orderItemList = new ArrayList<>();
        Optional.ofNullable(ascs).ifPresent(s -> orderItemList.addAll(
                Arrays.stream(s).filter(sqlInjectPredicate()).map(OrderItem::asc).collect(Collectors.toList())));
        Optional.ofNullable(descs).ifPresent(s -> orderItemList.addAll(
                Arrays.stream(s).filter(sqlInjectPredicate()).map(OrderItem::desc).collect(Collectors.toList())));
        page.addOrder(orderItemList);

        return page;
    }

    /**
     * 判断用户输入里面有没有关键字
     * @return Predicate
     */
    private Predicate<String> sqlInjectPredicate() {
        return sql -> {
            for (String keyword : KEYWORDS) {
                if (StrUtil.containsIgnoreCase(sql, keyword)) {
                    return false;
                }
            }
            return true;
        };
    }

}
