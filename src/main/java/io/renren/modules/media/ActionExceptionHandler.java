package io.renren.modules.media;

import io.renren.modules.media.entity.ResponseWrapper;
import io.renren.modules.media.entity.Status;
import io.renren.modules.media.exception.IError;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * Created by yihui on 2017/9/12.
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class ActionExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseWrapper<?> defaultHandler(HttpServletRequest request, Exception e) {
        log.error("some error {}", e);

        if (e instanceof UndeclaredThrowableException
                && ((UndeclaredThrowableException) e).getUndeclaredThrowable() instanceof IError) {
            return ResponseWrapper.errorReturn(((IError) ((UndeclaredThrowableException) e).getUndeclaredThrowable()).getStatus());
        }

        if (e instanceof IError) {
            return ResponseWrapper.errorReturn(((IError) e).getStatus());
        }


        log.error("unexpected exception! request: {}, params: {} refer: {}, e: {}",
                request.getRequestURI(),
                request.getParameterMap(),
                request.getHeader("referer"),
                e);

        if (StringUtils.isBlank(e.getMessage())) {
            return ResponseWrapper.errorReturn(new Status(500, "内部异常"));
        } else {
            return ResponseWrapper.errorReturn(new Status(500, e.getMessage()));
        }
    }
}
