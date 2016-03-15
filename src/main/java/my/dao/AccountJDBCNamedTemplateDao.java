package my.dao;

import my.entity.Account;
import my.idao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Repository("AccountJDBCNamedTemplateDao")
public class AccountJDBCNamedTemplateDao implements IAccountDao {
    @Autowired
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    public boolean saveAccount(Account account) {
        Map hashMap = new HashMap();
        hashMap.put("username", account.getUsername());
        int res = parameterJdbcTemplate.execute("INSERT INTO account (username) VALUES (:username)", hashMap, new PreparedStatementCallback<Integer>() {
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//                return null;
                return ps.executeUpdate();
            }
        });
        return res > 0;
    }

    public boolean delAccount(Account account) {
        int id = account.getId();
        Map hashMap = new HashMap();
        hashMap.put("id", id);
        int res = parameterJdbcTemplate.execute("delete  FROM account where id=(:id)", hashMap, new PreparedStatementCallback<Integer>() {
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
//                return null;
            }
        });
        return res > 0;
    }

    public boolean updateUser(Account account) {
        Map hashMap = new HashMap();
        hashMap.put("username", account.getUsername());
        hashMap.put("id", account.getId());
        int res = parameterJdbcTemplate.execute("update account set username=(:username) where id=(:id)", hashMap, new PreparedStatementCallback<Integer>() {
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
        return res > 0;
    }

    public Account getAccountById(int id) {
        Map hashMap = new HashMap();
        hashMap.put("id", id);
        return parameterJdbcTemplate.execute("SELECT * FROM account where id=:id", hashMap, new PreparedStatementCallback<Account>() {
            public Account doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ResultSet rs = ps.executeQuery();
                Account acc = null;
                while (rs.next()) {
                    acc = new Account();
                    String name = rs.getString("username");
                    acc.setUsername(name);
                }
                return acc;
            }
        });
    }
}
