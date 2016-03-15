//package my.dao;
//
//import my.entity.Account;
//import my.entity.Shop;
//import my.idao.IAccountDao;
//import my.idao.IShopDao;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.annotation.Resource;
//
//import static org.junit.Assert.*;
//
///**
// * Created by cdpmac on 16/3/14.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mvc-mgo.xml"})
//public class ShopMgoDaoTest {
//
//    //    @Resource(type = ShopMgoTemplateDao.class,name = "ShopMgoTemplateDao")
//    @Resource(type = ShopMgoDao.class, name = "ShopMgoDao")
//    private IShopDao dao;
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
//    @Test
//    public void testSaveShop() throws Exception {
//        Shop shop = new Shop();
//        shop.setPLACE_NAME("cuidapeng");
//        dao.saveShop(shop);
//    }
//
//    @Test
//    public void testDelShop() throws Exception {
//        Shop shop = new Shop();
//        shop.setId("56e670734869d81ef2272d2f");
//        dao.delShop(shop);
//    }
//
//    @Test
//    public void testUpdateShop() throws Exception {
//        Shop shop = new Shop();
//        shop.setId("56e670734869d81ef2272d2f");
//        shop.setPLACE_NAME("cuidapeng2");
//        dao.updateShop(shop);
//
//    }
//
//    @Test
//    public void testGetShopById() throws Exception {
//        dao.getShopById("56e670734869d81ef2272d2f");
//    }
//}