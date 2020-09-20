package com.linmou.log;

import com.linmou.anno.anno;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author linmou
 * @date 2020/9/19 - 22:05
 */
@Component
@Aspect
@Slf4j
public class log {
    @Pointcut("execution(* com.linmou.conterler..*.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        anno annotation = method.getAnnotation(anno.class);
        if(null!=annotation){
            StringBuilder stringBuilder=new StringBuilder();
            String declaringTypeName = signature.getDeclaringTypeName();
            String name = signature.getName();
            stringBuilder.append("declaringTypeName:"+declaringTypeName);
            stringBuilder.append("  name:"+name);
            stringBuilder.append("  agrs:"+ Arrays.toString(joinPoint.getArgs()));
            log.error(stringBuilder.toString());
            System.out.println("bbb");
        }
        System.out.println("aaa");
    }
}
