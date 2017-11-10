package app.configuration;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面统一异常管理与请求方法URL显示
 *
 */
@Component
@Aspect
public class UnifiedExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(UnifiedExceptionHandle.class);

    /**
     * 切入点定义
     */
    @Pointcut(value = "execution(* app..*.*(..))")
    public void point(){}

    /**
     * 织入切面前置方法
     */
    @Before("point()")
    public void before(){
        if(RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            logger.info("请求方法:{};请求URL:{};",request.getMethod(),request.getRequestURI());
        }
    }

    /**
     * 织入切面异常处理方法
     */
    @AfterThrowing("point()")
    public void exceptionHandle(){
        logger.info("error");
    }
}
