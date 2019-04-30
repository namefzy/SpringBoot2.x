package com.example.demo.web.interceptor;

import com.example.demo.config.LocalLock;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Aspect:作用是把当前类标识为一个切面供容器读取(类)
 * @JointPoint(连接点)：程序执行过程中明确的点，一般是方法的调用
 * @Advice(通知)：AOP在特定的切入点上执行的增强处理
 * @Pointcut：Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
 * @Around：环绕增强，相当于MethodInterceptor
 * @AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行
 * @Before：标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
 * @AfterThrowing：异常抛出增强，相当于ThrowsAdvice
 * @After: final增强，不管是抛出异常或者正常退出都会执行
 *先基于本地缓存
 *
 * 这个类类似于@Transactional注解作用
 */
@Aspect
@Configuration
public class LockMethodInterceptor {
    private static final Cache<String,Object> CACHES = CacheBuilder.newBuilder()
            .maximumSize(1000).expireAfterWrite(5, TimeUnit.SECONDS)
            .build();

    /**
     * aspectJ切面通过ProceedingJoinPoint想要获取当前执行的方法：Controller 中query方法
     *
     * proceedingJoinPoint.getArgs()：获取参数中的值
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(public * *(..))&& @annotation(com.example.demo.config.LocalLock))")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(),proceedingJoinPoint.getArgs());
        if(!StringUtils.isEmpty(key)){
            if(CACHES.getIfPresent(key)!=null){
                throw new RuntimeException("请勿请求重复");
            }
             CACHES.put(key,key);
        }
        try{
            return proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            throw new RuntimeException("服务器运行异常");
        }finally {

        }
    }
    /**
     * key 的生成策略,如果想灵活可以写成接口与实现类的方式（TODO 后续讲解）
     *
     * @param keyExpress 表达式
     * @param args       参数
     * @return 生成的key
     */
    private String getKey(String keyExpress, Object[] args) {
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
        }
        return keyExpress;
    }
}
