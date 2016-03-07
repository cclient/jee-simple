package my.idao;

import my.entity.Account;

import java.sql.SQLException;


public interface IAccountDao {

    boolean saveAccount(Account Account);

    boolean delAccount(Account Account);

    boolean updateUser(Account Account);

    Account getAccountById(int id);
}
