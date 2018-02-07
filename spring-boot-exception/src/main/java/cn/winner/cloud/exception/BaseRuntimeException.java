package cn.winner.cloud.exception;

import cn.winner.cloud.exception.domain.ErrorInfo;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * 基础异常类
 */
@Getter
@Setter
public class BaseRuntimeException extends RuntimeException {

    private ErrorInfo error;

    public BaseRuntimeException() {
    }

    public BaseRuntimeException(ErrorInfo error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        if (ObjectUtils.nullSafeEquals(null, error)) {
            return super.getMessage();
        } else {
            return StringUtils.isNotBlank(error.getMessage()) ? error.getMessage() : super.getMessage();
        }
    }

    public ErrorInfo getError() {
        return error;
    }

    /**
     * 设置异常类
     * @param error
     * @return
     */
    public BaseRuntimeException setError(ErrorInfo error) {
        this.error = error;
        return this;
    }
}
