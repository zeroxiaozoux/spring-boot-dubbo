package com.zero.api.exception;

import com.zero.api.exception.BaseException;

/**
 * @author admin
 * @date 2020/8/14-17:16
 */
public class DubboServiceException extends BaseException {
    private static final long serialVersionUID = 8532872328396705246L;

    public DubboServiceException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public DubboServiceException(String errorMsg) {
        super(errorMsg);
    }

    public DubboServiceException(Throwable cause, int errorCode, String errorMsg,
                                 String traceId) {
        super(cause, errorCode, errorMsg, traceId);
    }

    public DubboServiceException(Throwable cause, int errorCode, String errorMsg) {
        super(cause, errorCode, errorMsg);
    }

    public DubboServiceException(Throwable cause, String errorMsg) {
        super(cause, errorMsg);
    }

    public DubboServiceException(Throwable cause) {
        super(cause);
    }
}
