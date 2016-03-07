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
public class AccountDaoMybatisDao implements IAccountDao {
    private SqlSession session;
    @Qualifier("sqlSessionFactory")
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public boolean saveAccount(Account account) throws SQLException {
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        int res = session.insert("my.dao.AccountMapper.saveAccount");
        session.close();
        return res > 0;
    }

    public boolean delAccount(Account account) throws SQLException {
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        int res = session.delete("my.dao.AccountMapper.delAccount", account.getId());
        session.close();
        return res > 0;
    }

    public boolean updateUser(Account account) throws SQLException {
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        int res = session.update("my.dao.AccountMapper.updateAccount");
        session.close();
        return res > 0;
    }

    public Account getAccountById(int id) throws SQLException {
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        return (Account) session.selectOne("my.dao.AccountMapper.getAccount", id);
    }
}

