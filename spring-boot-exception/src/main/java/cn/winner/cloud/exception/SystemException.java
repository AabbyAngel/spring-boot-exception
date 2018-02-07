package cn.winner.cloud.exception;

import cn.winner.cloud.exception.domain.ErrorInfo;

/**
 * 系统性异常基类
 */
public class SystemException extends BaseRuntimeException {


    public SystemException(ErrorInfo error) {
        super(error);
    }

    public SystemException() {
    }
}
