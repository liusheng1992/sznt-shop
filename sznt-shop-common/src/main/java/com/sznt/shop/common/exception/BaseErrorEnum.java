//package com.sznt.shop.common.exception;
//
//import lombok.AllArgsConstructor;
//
///**
// * 错误枚举类</br>
// * <p>由于枚举是不可变对象, 所以里面的属性用final标识</p>
// *
// * @author S Mr.L
// * @since 2021-05-31
// */
//@AllArgsConstructor
//public enum BaseErrorEnum implements BaseErrorInfo {
//
//    SUCCESS("100000", "成功"),
//    PARAM_INVALID("100001", "请求参数不合法"),
//    INNER_LOGIC_ERROR("100002", "内部逻辑出错"),
//    CAN_NOT_FOUND_RESOURCE("100003", "找不到对应的资源")
//    ;
//
//    private final String errorCode;
//
//    private final String errorMessage;
//
//    @Override
//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    @Override
//    public String getErrorMessage() {
//        return errorMessage;
//    }
//}
