package cdptest;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cdptool.dao.AccountDao;
import cdptool.dao.AccountJDBCDao;
import cdptool.entity.account;
import cdptool.idao.IAccountDao;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="spring-mvc.xml")  
public class AccountJDBCDaoTest {
//	@Resource 
	@Resource
	private	AccountJDBCDao dao;
	@Test
	public void setaccount() {
			try {
				account ac=new account();
				ac.setUsername("cuidapeng");
				dao.saveAccount(ac);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}