package cn.winner.cloud.exception;

import cn.winner.cloud.exception.domain.ErrorInfo;

/**
 * 业务异常基类
 */
public class BizException extends BaseRuntimeException {

    public BizException(ErrorInfo errorInfo){
        super(errorInfo);
    }

    public BizException() {
    }
}
