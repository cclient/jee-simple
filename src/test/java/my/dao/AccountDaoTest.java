//package my.dao;
//
//import my.entity.Account;
//import my.idao.IAccountDao;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//
///**
// * Created by cdpmac on 30/3/4.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mvc-mybatis.xml", "classpath:spring-mvc-hibernate.xml", "classpath:spring-mvc-txaop.xml"})
////@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mvc-mybatis.xml", "classpath:spring-mvc-hibernate.xml"})
//public class AccountDaoTest {
//    //    @Resource(type = AccountJDBCDao.class, name = "AccountJDBCDao")
////    @Resource(type = AccountJDBCTemplateDao.class)
////    @Resource(type = AccountHibernateDao.class)
////    @Resource(type = AccountMybatisDao.class)
////    @Resource(type = AccountMybatisTemplateDao.class)
////    @Resource(type = AccountMybatisMapperDao.class,name="AccountMybatisMapperDao")
////    @Resource(type = AccountMybatisMapperIocDao.class)
//
////    设置AOP事务管理后,默认不在有AccountHibernateDao.class的实例,用type失效,但是可以用name标识,name标识的是AOP包装后的实例
////    @Resource(type = AccountHibernateDao.class)
//    @Resource(name = "AccountHibernateDao")
////    @Resource()
//
//    private IAccountDao dao;
//
//
//    @Before
//    public void setUp() throws Exception {
//        System.out.println(dao.getClass());
//    }
//
//    @Test
//    public void testSaveAccount() throws Exception {
//        Account ac = new Account();
//        ac.setId(30);
//        ac.setUsername("cuidapeng");
//        dao.saveAccount(ac);
//    }
//
//    @Test
//    public void testupdateUser() throws Exception {
//        Account ac = new Account();
//        ac.setUsername("cuidapeng3");
//        ac.setId(30);
//        dao.updateUser(ac);
//    }
//
//
//    @Test
//    public void testGetAccountById() throws Exception {
//        System.out.println("dao.getClass()");
//        System.out.println(dao.getClass());
//        Account acc = dao.getAccountById(59);
//        System.out.println("get");
//        System.out.println(acc.getUsername());
//    }
//
//    @Test
//    public void testDelAccount() throws Exception {
//        Account ac = new Account();
//        ac.setId(30);
//        dao.delAccount(ac);
//    }
//
//
//}