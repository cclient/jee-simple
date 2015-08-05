package cdptest;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import cdptool.dao.AccountDao;
import cdptool.entity.account;
import cdptool.idao.IAccountDao;

@RunWith(SpringJUnit4ClassRunner.class) 
 
@ContextConfiguration(locations="spring-mvc.xml")  

public class accountdaotest {
	@Resource
	private	AccountDao dao;
	@Test
	public void getaccountbyid() throws SQLException{
		account ac=dao.getAccountById(1);
		account b=ac;
	}
}
