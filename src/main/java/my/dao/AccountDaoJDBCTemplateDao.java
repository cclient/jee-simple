package my.dao;

import java.sql.*;

import my.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import my.idao.IAccountDao;

@Repository
public class AccountDaoJDBCTemplateDao implements IAccountDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public boolean saveAccount(final Account account){
        int res = jdbcTemplate.execute(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = null;
                    pstmt = con.prepareStatement("INSERT INTO account (username) VALUES (?)");
                    pstmt.setString(1, account.getUsername());
                    return pstmt;
            }
        }, new PreparedStatementCallback<Integer>() {
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
        return res > 0;
    }

    public boolean delAccount(final Account account){
        int res = jdbcTemplate.execute(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                int id = account.getId();
                PreparedStatement pstmt = con.prepareStatement("delete  FROM account where id=?");
                pstmt.setInt(1, id);
                return pstmt;
            }
        }, new PreparedStatementCallback<Integer>() {
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
        return res > 0;
    }

    public boolean updateUser(final Account account){
        int res = jdbcTemplate.execute(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement("update account set username=? where id=?");
                pstmt.setInt(1, account.getId());
                pstmt.setString(2, account.getUsername());
                return pstmt;
            }
        }, new PreparedStatementCallback<Integer>() {
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
        return res > 0;
    }

    public Account getAccountById(final int id){
        return jdbcTemplate.execute(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareCall("SELECT * FROM account where id=" + id);
            }
        }, new PreparedStatementCallback<Account>() {
            public Account doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ResultSet rs = ps.executeQuery();
                Account acc = new Account();
                while (rs.next()) {
                    String name = rs.getString("username");
                    acc.setUsername(name);
                }
                return acc;
            }
        });
    }
}
