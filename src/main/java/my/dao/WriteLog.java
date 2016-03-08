package my.dao;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

/**
 * Created by cdpmac on 16/3/7.
 */
@Aspect
public class WriteLog {
    @Before("execution(* saveAccount(..))")
    public void  Before(){
        System.out.println("before");

    }
    @After("execution(* saveAccount(..))")
    public  void After(){
        System.out.println("after");
    }
    @AfterReturning(value = "target(my.dao.AccountDaoHibernateTxDao)&&execution(* saveAccount(..))",returning ="retval")
    public  void AfterReturn(boolean retval){

        System.out.println("after return ");
        System.out.println(retval);
    }
}
