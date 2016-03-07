package my.dao;

import my.entity.Account;
import my.idao.IAccountDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.SQLException;

@Repository
public class AccountDaoHibernateDao implements IAccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean saveAccount(Account account) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Serializable id = session.save(account);
        tx.commit();
        session.flush();
        session.close();
        System.out.println("id=" + id);
        return id == null;
    }

    public void presistAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(account); // 无返回值
        try {
            tx.commit();
        } catch (Exception ex) {

        } finally {
            session.close();
        }
    }

    public boolean delAccount(Account account) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(account);
        try {
            tx.commit();
        } catch (Exception ex) {

        } finally {
            session.close();
        }
        return true;
    }

    public boolean updateUser(Account account) throws SQLException {
        // TODO Auto-generated method stub
//		  hibernateTemplate.update(Account);
        String hql = "update Account set name=? where id=?";
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter(0, account.getUsername());
        query.setParameter(1, account.getId());
        int res = query.executeUpdate();
        tx.commit();
        session.close();
        return res > 0;
    }

    public Account getAccountById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Account user = (Account) session.get(Account.class, id);
        session.close();
        System.out.println(user);
        return user;
    }

}

//public class TestAssociated {
//	  
//    // 交叉连接(多表的笛卡儿积不常用)  
//    // select c.*,o.* from customers c, orders o  
//    @Test  
//    public void test_cross_join() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "from Customer c , Order o";  
//        Query query = session.createQuery(hql);  
//        List<Object[]> list = query.list();  
//        for (int i = 0; i < list.size(); i++) {  
//            Object[] obj = (Object[]) list.get(i);  
//            Customer customer = (Customer) obj[0];  
//            Order order = (Order) obj[1];  
//            System.out.println((i + 1) + "---" + customer);  
//            System.out.println((i + 1) + "---" + order);  
//        }  
//        session.close();  
//    }  
//  
//    // 内链接  
//    // select c.* from customers c inner join orders o on c.id=o.customer_id  
//    // select o.* from orders o where o.customer_id=?  
//    @Test  
//    public void test_inner_join() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "select c from Customer c inner join c.orders"; // inner 可省略  
//        Query query = session.createQuery(hql);  
//        List<Customer> list = query.list();  
//        showCustomer(list);  
//        session.close();  
//    }  
//  
//    // 左外连接  
//    // select c.* from customers c left outer join orders o on c.id=o.customer_id  
//    // select o.* from orders o where o.customer_id=?  
//    @Test  
//    public void test_left_outer_join() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "select c from Customer c left outer join c.orders"; // outer 可省略  
//        Query query = session.createQuery(hql);  
//        List<Customer> list = query.list();  
//        showCustomer(list);  
//        session.close();  
//    }  
//  
//    // 右连接  
//    // select c.*, o.* from customers c right outer join orders o on c.id=o.customer_id  
//    @Test  
//    public void test_right_outer_join() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "from Customer c right outer join c.orders"; // outer 可省略  
//        Query query = session.createQuery(hql);  
//        List<Object[]> list = query.list();  
//        for (int i = 0; list != null && i < list.size(); i++) {  
//            Object[] obj = list.get(i);  
//            Customer customer = (Customer) obj[0];  
//            Order order = (Order) obj[1];  
//            System.out.println((i + 1) + "---" + customer);  
//            System.out.println((i + 1) + "---" + order);  
//        }  
//        session.close();  
//    }  
//  
//    // 迫切内连接(推荐)  
//    // select c.*,o.* from customers c inner join orders o on c.id=o.customer_id  
//    @Test  
//    public void test_inner_join_fetch() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "select c from Customer c inner join fetch c.orders"; // inner 可省略  
//        Query query = session.createQuery(hql);  
//        query.setCacheable(true); // 设置缓存  
//        List<Customer> list = query.list();  
//        showCustomer(list);  
//        session.close();  
//    }  
//  
//    // 迫切左外连接(推荐)  
//    // select c.*,o.* from customers c left outer join orders o on c.id=o.customer_id  
//    @Test  
//    public void test_left_outer_join_fetch() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "select c from Customer c left outer join fetch c.orders"; // outer可省略  
//        Query query = session.createQuery(hql);  
//        query.setCacheable(true); // 设置缓存  
//        List<Customer> list = query.list();  
//        showCustomer(list);  
//        session.close();  
//    }  
//  
//    // 迫切左外连接(推荐)  
//    // select c.*, o.* from customers c left outer join orders o on c.id=o.customer_id  
//    @Test  
//    public void test_left_outer_join_fetch_QBC() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        Criteria criteria = session.createCriteria(Customer.class).setFetchMode("orders", FetchMode.JOIN);  
//        criteria.setCacheable(true); // 设置缓存  
//        List<Customer> list = criteria.list();  
//        showCustomer(list);  
//        session.close();  
//    }  
//  
//    // 打印Order信息  
//    private void showCustomer(List<Customer> list) {  
//        for (Customer customer : list) {  
//            System.out.println(customer);  
//            if (customer.getOrders() != null && customer.getOrders().size() > 0) {  
//                Set<Order> orders = customer.getOrders();  
//                for (Iterator<Order> it = orders.iterator(); it.hasNext();) {  
//                    Order order = it.next();  
//                    System.out.println(order);  
//                }  
//            }  
//        }  
//    }  
//}  


//
//package org.springfuncs.cache;  
//
//import org.hibernate.Query;  
//import org.hibernate.Session;  
//import org.hibernate.SessionFactory;  
//import org.junit.Test;  
//import org.springfuncs.domain.Emp;  
//import org.springfuncs.util.HibernateUtil;  
//  
//public class TestCache {  
//  
//    // 测试Session缓存  
//    @Test  
//    public void test_cache1() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        Emp emp1 = (Emp) session.get(Emp.class, 7369);  
//        Emp emp2 = (Emp) session.get(Emp.class, 7369);  
//        System.out.println(emp1 == emp2);  
//    }  
//  
//    // 测试 EHCache缓存  
//    // 配置缓存的话，会执行一条SQL，否则是2条SQL  
//    @Test  
//    public void test_cache2() {  
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
//        Session session = sessionFactory.openSession();  
//        String hql = "from Emp";  
//  
//        Query query = session.createQuery(hql);  
//        query.setCacheable(true);  
//        query.list();  
//  
//        query = session.createQuery(hql);  
//        query.setCacheable(true);  
//        query.list();  
//    }  
//}  