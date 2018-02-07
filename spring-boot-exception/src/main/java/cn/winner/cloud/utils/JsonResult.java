package cn.winner.cloud.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResult {

    /**
     * 标示请求结果为成功
     */
    private Boolean success = Boolean.TRUE;

    /**
     * controller 方法返回数据对象
     */
    private Object data;

    public JsonResult(Object object) {
        this.data = object;
    }
}
