package cdptool.dao;

import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cdptool.entity.account;
import cdptool.idao.IAccountDao;

@Repository  
public class AccountJDBCDao implements IAccountDao {
	
	// @Autowired标注可以放在成员变量上,也可以放在成员变量的set方法上。前者，Spring会直接将UserDao类型的唯一一个bean赋值给userDao这个成员变量；后者，Spring会调用setUserDao方法来将UserDao类型的唯一一个bean装配到userDao这个属性。
	// @Qualifier @Autowired是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Qualifier[1] 使用
	@Autowired
	private BasicDataSource bds;
	private Connection conn;

	public void saveAccount(account Account) throws SQLException {
		this.conn = this.bds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO account (username) VALUES (?)");
		pstmt.setString(1, Account.getUsername());
		int count =pstmt.executeUpdate();
		if (pstmt != null) { // 关闭声明
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) { // 关闭连接对象
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void delAccount(account Account) throws SQLException {
		this.conn = this.bds.getConnection();
		int id=Account.getId();
		Connection conn = bds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete  FROM account where id=?");
		pstmt.setInt(1, id);
		// 执行SQL语句
		// Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate 和execute
		int count =pstmt.executeUpdate();
		if (pstmt != null) { // 关闭声明
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) { // 关闭连接对象
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void editUsre(account Account) throws SQLException {
	}

	public account getAccountById(int id) throws SQLException {
		this.conn = this.bds.getConnection();
		Statement stmt = conn.createStatement();
		account acc = null;
		ResultSet rs = stmt.executeQuery("SELECT * FROM account where id="+id);
		while (rs.next()) {
			acc=new account();
			String name = rs.getString("username");
			acc.setUsername(name);
		}
		if (rs != null) { // 关闭记录集
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) { // 关闭声明
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) { // 关闭连接对象
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// int executeUpdate(String sqlString)
//		boolean flag = stmt.execute("");
		return acc;
	}

}
