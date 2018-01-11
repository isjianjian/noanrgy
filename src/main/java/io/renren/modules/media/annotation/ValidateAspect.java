package io.renren.modules.media.annotation;


import io.renren.modules.media.entity.IValidate;
import io.renren.modules.media.exception.ParameterError;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 校验切面
 * <p>
 * Created by yihui on 2017/9/12.
 */
@Aspect
@Component
public class ValidateAspect {


    /**
     * 参数校验
     *
     * @param joinPoint
     * @param validate
     * @throws Throwable
     */
    @Before("@annotation(validate)")
    public void beforeExec(JoinPoint joinPoint, ValidateDot validate) throws ParameterError {
        Object[] args = joinPoint.getArgs();

        for (Object obj : args) {
            if (obj instanceof IValidate) {
                if (!((IValidate) obj).validate()) {
                    throw new ParameterError();
                }
            }
        }
    }


}
