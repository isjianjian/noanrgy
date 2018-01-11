package io.renren.modules.media.exception;


import io.renren.modules.media.entity.Status;

/**
 * Created by yihui on 2017/9/12.
 */
public class Markdown2HtmlError extends IError {

    @Override
    public Status.StatusEnum getStatus() {
        return Status.StatusEnum.BIZ_MARK2HTML_ERROR;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
