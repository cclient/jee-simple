package my.dao;

import com.mongodb.*;
import my.entity.Shop;
import my.idao.IShopDao;
import org.bson.types.ObjectId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("ShopMgoDao")
public class ShopMgoDao implements IShopDao {
    private SimpleMongoDbFactory simpleMongoDbFactory;
    private DB db;
    private DBCollection col;

    @Autowired
    public ShopMgoDao(SimpleMongoDbFactory simpleMongoDbFactory, String DBName, String ColName) {
        this.simpleMongoDbFactory = simpleMongoDbFactory;
        this.db = simpleMongoDbFactory.getDb(DBName);
        this.col = db.getCollection(ColName);
    }


    public boolean saveShop(Shop shop) {
        DBObject shopjson = new BasicDBObject("PLACE_NAME", shop.getPLACE_NAME());
        WriteResult res = col.insert(shopjson);
        return res.getUpsertedId() != null;
    }

    public boolean delShop(Shop shop) {
        DBObject queryjson = new BasicDBObject("_id", new ObjectId(shop.getId()));
        WriteResult res = col.remove(queryjson);
        return res.wasAcknowledged();
    }

    public boolean updateShop(Shop shop) {
//        new BasicDBObject("_id",new ObjectId("50a1ed9965f413fa025166db"))
        DBObject queryjson = new BasicDBObject("_id", new ObjectId(shop.getId()));
        DBObject shopjson = new BasicDBObject("PLACE_NAME", shop.getPLACE_NAME());
        WriteResult res = col.update(queryjson, shopjson);
        return res.wasAcknowledged();
    }

    public Shop getShopById(Object id) {
        DBObject res = col.findOne(new ObjectId((String) id));
        System.out.print(res.toString());
        return null;
    }
}
