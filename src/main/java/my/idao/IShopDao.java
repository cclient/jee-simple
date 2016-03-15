package my.idao;

import my.entity.Shop;


public interface IShopDao {
    boolean saveShop(Shop Shop);

    boolean delShop(Shop Shop);

    boolean updateShop(Shop Shop);

    Shop getShopById(Object id);
}
