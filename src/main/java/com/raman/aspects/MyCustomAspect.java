package com.raman.aspects;

import com.raman.dao.DaoException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyCustomAspect {

    @AfterThrowing(throwing = "t", pointcut = "execution(* com.raman..*Dao.*(..))")
    public void convertToDaoException(Throwable t) throws DaoException {
        throw new DaoException(t);
    }

    @Around("execution(* com.raman.dao.ProductDao.get*(Double, Double))")
    public Object swapMinAndMax(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Double min = (Double) args[0];
        Double max = (Double) args[1];
        if(min > max) {
            args = new Object[] {max, min};
        }
        return pjp.proceed(args);
    }
}
