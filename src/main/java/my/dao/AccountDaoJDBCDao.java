package my.dao;

import my.entity.Account;
import my.idao.IAccountDao;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AccountDaoJDBCDao implements IAccountDao {
    @Autowired
    public void setBds(BasicDataSource bds) {
        this.bds = bds;
    }
    // @Autowired标注可以放在成员变量上,也可以放在成员变量的set方法上。前者，Spring会直接将UserDao类型的唯一一个bean赋值给userDao这个成员变量；后者，Spring会调用setUserDao方法来将UserDao类型的唯一一个bean装配到userDao这个属性。
    // @Qualifier @Autowired是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Qualifier[1] 使用
    private BasicDataSource bds;
    private Connection conn;

    public boolean saveAccount(Account account) {
        try {
            conn = bds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO account (username) VALUES (?)");
            pstmt.setString(1, account.getUsername());
            int count = pstmt.executeUpdate();
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
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delAccount(Account account) {
        try {
            conn = bds.getConnection();
            int id = account.getId();
            Connection conn = bds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("delete  FROM account where id=?");
            pstmt.setInt(1, id);
            int count = pstmt.executeUpdate();
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
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(Account account) {
        try {
            conn = bds.getConnection();
            int id = account.getId();
            Connection conn = bds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update  Account SET username=?  where id=?");
            pstmt.setString(1, account.getUsername());
            pstmt.setInt(2, id);
            int count = pstmt.executeUpdate();
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
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account getAccountById(int id) {
        try {
            conn = bds.getConnection();
            Statement stmt = conn.createStatement();
            Account acc = null;
            ResultSet rs = stmt.executeQuery("SELECT * FROM account where id=" + id);
            while (rs.next()) {
                acc = new Account();
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
            return acc;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
