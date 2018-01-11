package io.renren.modules.media.exception;


import io.renren.modules.media.entity.Status;

/**
 * Created by yihui on 2017/9/12.
 */
public class Html2ImageError extends IError {
    @Override
    public Status.StatusEnum getStatus() {
        return Status.StatusEnum.BIZ_HTML2IMAGE_ERROR;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
