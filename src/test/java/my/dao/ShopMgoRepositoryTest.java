package my.dao;

import my.entity.Shop;
//import my.tt.ApplicationConfiguration;
//import my.tt.ShopRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Customer;
import sample.CustomerRepository;

import static org.junit.Assert.*;

/**
 * Created by cdpmac on 16/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mvc-mgo.xml"})
//@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class ShopMgoRepositoryTest {
//    @Autowired
//    private ShopMgoRepository shopMgoRepository;
//
//    @Test
//    public void testTest() throws Exception {
//        shopMgoRepository.Test();
//    }

//    @Autowired
////    @Qualifier("ShopRepository")
//    private ShopRepository repository;
//
//    @Test
//    public void testTest() throws Exception {
//        repository.save(new Shop("cui"));
//        System.out.println("Shops found with findAll():");
//        System.out.println("-------------------------------");
//        for (Shop customer : repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Shop found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Shops found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Shop shop : repository.findByLastName("Smith")) {
//            System.out.println(shop);
//        }
//
//    }

    @Autowired
    private CustomerRepository repository;


    @Test
    public void testTest() throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }

}