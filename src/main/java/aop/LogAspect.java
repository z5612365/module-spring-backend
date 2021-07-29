package aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    final static Logger log = Logger.getLogger("LogAspect");

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerPointcut() {
    }

    @Around("restControllerPointcut()")
    public Object restControllerPointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String annotatedMethodName = joinPoint.getSignature().getName();

        log.info("start Controller " + className + annotatedMethodName);
        Object object = joinPoint.proceed();
        log.info("end Controller " + className + annotatedMethodName);

        return object;

    }

}