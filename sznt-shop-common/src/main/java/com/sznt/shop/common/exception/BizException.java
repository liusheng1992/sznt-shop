//package com.sznt.shop.common.exception;
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
///**
// * 业务异常类
// *
// * @author S Mr.L
// * @since 2021-06-01
// */
//@Data
//@EqualsAndHashCode(callSuper = true)
//public class BizException extends RuntimeException {
//
//    private static final long serialVersionUID = 2298930954722392662L;
//
//    private String errorCode;
//
//    private String errorMessage;
//
//    public BizException() {
//        super();
//    }
//
//    public BizException(BaseErrorInfo errorInfo) {
//        super(errorInfo.getErrorCode());
//        this.errorCode = errorInfo.getErrorCode();
//        this.errorMessage = errorInfo.getErrorMessage();
//    }
//
//    public BizException(BaseErrorInfo errorInfo, Throwable cause) {
//        super(errorInfo.getErrorCode(), cause);
//        this.errorCode = errorInfo.getErrorCode();
//        this.errorMessage = errorInfo.getErrorMessage();
//    }
//
//}
