package io.renren.modules.media.exception;


import io.renren.modules.media.entity.Status;

/**
 * Created by yihui on 2017/9/12.
 */
public abstract class IError extends Exception {

    public abstract Status.StatusEnum getStatus();

}
