package spring.service.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Slf4j
public class LoggingAspect {

    @Before("@annotation(Logging)")
    public void logService(JoinPoint joinPoint) {
        log.info("Class " + joinPoint.getTarget().getClass().getSimpleName() +
                "; method " + joinPoint.getSignature().getName());
    }
}
