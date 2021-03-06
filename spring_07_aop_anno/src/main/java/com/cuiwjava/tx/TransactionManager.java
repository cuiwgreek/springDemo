package com.cuiwjava.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Classname TransactionManager
 * @Description TODO
 * @Date 2019/4/21/021 23:58
 * @Created by cuiwjava
 */
// 模拟事务管理器
@Component
@Aspect
public class TransactionManager {

//    @Pointcut("execution(*  com.cuiwjava.service.*Service.*(..))")// JDK代理模式
    /**
     * 如果采用CGLIB代理 不需要实现接口 需要注解在测试时候修改此处的Pointcut
     *
     */
    @Pointcut("execution(*  com.cuiwjava.service.impl.*.*(..))")
    public void txPoint(){
    }

    @Before("txPoint()")
    public void begin(JoinPoint joinPoint){
//        System.out.println("代理对象"+joinPoint.getThis().getClass());
//        System.out.println("目标对象"+joinPoint.getTarget().getClass());
//        System.out.println("被增强方法的参数"+ Arrays.toString(joinPoint.getArgs()));
//        System.out.println("连接点方法签名"+joinPoint.getSignature());
//        System.out.println("当前连接点的类型"+joinPoint.getKind());
        System.out.println("开启事务");
    }
    @AfterReturning("txPoint()")
    public void commit(JoinPoint joinPoint){
        System.out.println("提交事务");
    }
    @AfterThrowing(value="txPoint()",throwing = "ex")
    public void rollback(JoinPoint joinPoint,Throwable ex){
        System.out.println("回滚事务,异常信息"+ ex.getMessage());
    }
    @After("txPoint()")
    public void close(JoinPoint joinPoint){
        System.out.println("释放资源");
    }
//    @Around("txPoint()")
    public Object aroundMethod(ProceedingJoinPoint pjp){
        Object ret = null;
        System.out.println("开启事务");
        try {
            ret = pjp.proceed();
            System.out.println("提交事务");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("回滚事务");
        } finally {
            System.out.println("释放资源");
        }
       return ret;
    }
}
