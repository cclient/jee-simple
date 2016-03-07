package my.dao;

import my.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by cdpmac on 16/3/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//{“xx/yy/beans1.xml”,” xx/yy/beans2.xml”}
//@ContextConfiguration(locations={“xx/yy/beans1.xml”,” xx/yy/beans2.xml”})
//classpath:
//@ContextConfiguration(locations = {"../spring-mvc2.xml", "../spring-mvc-datasource.xml", "../spring-mvc-mybatis.xml"})
@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mvc-mybatis.xml","classpath:spring-mvc-hibernate.xml"})
public class AccountDaoJDBCDaoTest {
    @Resource
//    @Resource(type = AccountDaoJDBCDao.class)
    private AccountDaoJDBCDao dao;

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void testSaveAccount() throws Exception {
        Account ac = new Account();
        ac.setUsername("cuidapeng");
        dao.saveAccount(ac);
    }

    @Test
    public void testGetAccountById() throws Exception {
        Account acc = dao.getAccountById(1);
        System.out.println("get");
        System.out.println(acc);
    }

    @Test
    public void testDelAccount() throws Exception {
        Account ac = new Account();
        ac.setId(1);
        dao.delAccount(ac);
    }

    @Test
    public void testupdateUser() throws Exception {
        Account ac = new Account();
        ac.setUsername("cuidapeng2");
        dao.updateUser(ac);
    }


}