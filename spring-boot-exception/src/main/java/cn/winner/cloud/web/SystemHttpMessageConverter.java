package cn.winner.cloud.web;

import cn.winner.cloud.controller.vo.BaseVO;
import cn.winner.cloud.utils.JsonResult;
import cn.winner.cloud.exception.domain.ErrorInfo;
import javafx.scene.control.Pagination;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class SystemHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    protected boolean canWrite(MediaType mediaType) {
        return true;
    }


    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if(supportType(object)) {//对支持的类型做转换
            JsonResult result = new JsonResult(object);
            if(object instanceof  ErrorInfo){
                result.setSuccess(Boolean.FALSE);
            }
            super.writeInternal(result,type, outputMessage);
        }else{
            super.writeInternal(object,type,outputMessage);
        }
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(o, outputMessage);
    }

    /**
     * 支持基础类和Pagination，BaseVO
     * @param object
     * @return
     */
    private boolean supportType(Object object){
        if(object instanceof Pagination
                || object instanceof ErrorInfo
                || object instanceof BaseVO
                || object instanceof String
                || object instanceof Integer
                || object instanceof Long
                || object instanceof Boolean
                || object instanceof Double
                || object instanceof Float
                || object instanceof List
                || object instanceof Map){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
