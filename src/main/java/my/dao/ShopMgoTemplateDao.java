package my.dao;

import com.mongodb.*;
import my.entity.Shop;
import my.idao.IShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
//import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository("ShopMgoTemplateDao")
//@EnableDynamoDBRepositories(basePackages = "com.acme.repositories")
public class ShopMgoTemplateDao implements IShopDao {
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean saveShop(Shop shop) {
        try {
            mongoTemplate.insert(shop);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean delShop(Shop shop) {
        WriteResult res = mongoTemplate.remove(shop);
        return res.wasAcknowledged();
    }

    public boolean updateShop(Shop shop) {
        Query query = Query.query(Criteria.where("_id").is(shop.getId()));
        Update update = Update.update("PLACE_NAME", shop.getPLACE_NAME());
        WriteResult res = mongoTemplate.updateFirst(query, update, Shop.class);
        return res.wasAcknowledged();
    }

    public Shop getShopById(Object id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        Shop shop = mongoTemplate.findOne(query, Shop.class);
        return shop;
    }
}
