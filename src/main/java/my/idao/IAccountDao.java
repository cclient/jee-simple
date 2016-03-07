package my.idao;

import my.entity.Account;

import java.sql.SQLException;


public interface IAccountDao {

    boolean saveAccount(Account Account) throws SQLException;

    boolean delAccount(Account Account) throws SQLException;

    boolean updateUser(Account Account) throws SQLException;

    Account getAccountById(int id) throws SQLException;
}
