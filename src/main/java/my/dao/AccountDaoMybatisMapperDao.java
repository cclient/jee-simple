package my.dao;

import my.entity.Account;
import my.idao.IAccountDao;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AccountDaoMybatisMapperDao implements IAccountDao {
    @Qualifier("sqlSessionFactory")
    @Autowired
    private AccountMapper userMapper;

    public boolean saveAccount(Account account) throws SQLException {
        int res = userMapper.saveAccount(account.getUsername());
        return res > 0;
    }

    public boolean delAccount(Account account) throws SQLException {
        int res = userMapper.delAccount(account.getId());
        return res > 0;
    }

    public boolean updateUser(Account account) throws SQLException {
        int res = userMapper.updateAccount(account.getUsername(), account.getId());
        return res > 0;
    }

    public Account getAccountById(int id) throws SQLException {
        return userMapper.getAccount(id);
    }
}

