package app.configuration;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
@Component
@Aspect
public class UnifiedExceptionHandle {

    Logger logger = LoggerFactory.getLogger(UnifiedExceptionHandle.class);

    @Pointcut(value = "execution(* app..*.*(..))")
    public void point(){}

    @Before("point()")
    public void before(){
        if(RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            logger.info("请求方法:{};请求URL:{};",request.getMethod(),request.getRequestURI());
        }
    }

    @AfterThrowing("point()")
    public void exceptionHandle(){
        logger.info("error");
    }
}
