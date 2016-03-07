package my.dao;

import my.entity.Account;
import my.idao.IAccountDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by cdpmac on 30/3/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mvc-mybatis.xml", "classpath:spring-mvc-hibernate.xml"})
public class AccountDaoJDBCDaoTest {
    //    @Resource(type = AccountDaoJDBCDao.class)
//    @Resource(type = AccountDaoJDBCTemplateDao.class)
//    @Resource(type = AccountDaoHibernateDao.class)
//    @Resource(type = AccountDaoMybatisDao.class)
//    @Resource(type = AccountDaoMybatisTemplateDao.class)
//    @Resource(type = AccountDaoMybatisMapperDao.class)
    @Resource(type = AccountDaoMybatisMapperIocDao.class)

    private IAccountDao dao;


    @Before
    public void setUp() throws Exception {
        System.out.println(dao.getClass());
    }

    @Test
    public void testSaveAccount() throws Exception {
        Account ac = new Account();
        ac.setId(30);
        ac.setUsername("cuidapeng");
        dao.saveAccount(ac);
    }

    @Test
    public void testupdateUser() throws Exception {
        Account ac = new Account();
        ac.setUsername("cuidapeng3");
        ac.setId(30);
        dao.updateUser(ac);
    }


    @Test
    public void testGetAccountById() throws Exception {
        Account acc = dao.getAccountById(30);
        System.out.println("get");
        System.out.println(acc.getUsername());
    }

    @Test
    public void testDelAccount() throws Exception {
        Account ac = new Account();
        ac.setId(30);
        dao.delAccount(ac);
    }


}