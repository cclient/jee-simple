package my.first;

import org.springframework.stereotype.Repository;

/**
 * Created by cdpmac on 16/3/4.
 */
@Repository
public class DemoDao {
    public  void sayHello(){
        System.out.println("hello");
    }
}
