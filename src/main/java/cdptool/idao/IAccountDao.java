package cdptool.idao;

import java.sql.SQLException;

import cdptool.entity.account;



public interface IAccountDao {

	  public void saveAccount(account Account) throws SQLException;  
	  
	    public void delAccount(account Account) throws SQLException;  
	  
	    public void editUsre(account Account) throws SQLException;  
	  
	    public account getAccountById(int id) throws SQLException;  
}
