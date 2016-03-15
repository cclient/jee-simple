//package my.dao;
//
//import com.mongodb.*;
//import my.entity.Shop;
//import my.tt.ShopRepository;
//import my.idao.IShopDao;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.stereotype.Repository;
//
//@Repository("ShopMgoRepository")
//public class ShopMgoRepository {
//    @Autowired
////    @Qualifier("ShopRepository")
//    private ShopRepository repository;
//    public void Test() {
////        save a couple of customers
//        repository.save(new Shop("cui"));
//
//        // fetch all customers
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
//
//
//}
