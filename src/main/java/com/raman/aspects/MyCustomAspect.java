package com.raman.aspects;

import com.raman.dao.DaoException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyCustomAspect {

    @AfterThrowing(throwing = "t", pointcut = "execution(* com.raman..*Dao.*(..))")
    public void convertToDaoException(Throwable t) throws DaoException {
        throw new DaoException(t);
    }

}
