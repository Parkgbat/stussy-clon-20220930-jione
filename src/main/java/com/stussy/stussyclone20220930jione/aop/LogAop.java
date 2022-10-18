package com.stussy.stussyclone20220930jione.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAop {


    @Pointcut("execution(* com.stussy.stussyclone20220930jione.api.*Api.*(..))")
    private void pointCut() {}

//    @Pointcut("@annotation(com.stussy.stussyclone20220930jione.aop.annotation.LogAspect)")
//    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs();

        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] argNames = codeSignature.getParameterNames();

        StringBuilder argNameString = new StringBuilder();
        StringBuilder argDataString = new StringBuilder();

        for(int i = 0; i < args.length; i++) {
            argNameString.append(argNames[i]);
            argDataString.append(args[i].toString());
            if(i < args.length - 1) {
                argNameString.append(", ");
                argDataString.append(", ");
            }
        }
        log.info("Method Call -- {}.{}({}) >> {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                argNameString.toString(),
                argDataString.toString());

        Object result = joinPoint.proceed();

        log.info("Method Return -- {}.{}({}) >> {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                argNameString.toString(),
                result);

        return result;
    }

}
