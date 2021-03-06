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


@Repository("AccountMybatisDao")
public class AccountMybatisDao implements IAccountDao {
    private SqlSession session;
    @Qualifier("sqlSessionFactory")
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    //        XML 定义

    public boolean saveAccount(Account account){
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        int res = session.insert("my.entity.AccountMapper.saveAccount",account.getUsername());
        session.close();
        return res > 0;
    }

    public boolean delAccount(Account account){
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        int res = session.delete("my.entity.AccountMapper.delAccount", account.getId());
        session.close();
        return res > 0;
    }

    public boolean updateUser(Account account){
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        int res = session.update("my.entity.AccountMapper.updateAccount",account);
        session.close();
        return res > 0;
    }

    public Account getAccountById(int id){
        session = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        return (Account) session.selectOne("my.entity.AccountMapper.getAccount", id);
    }
}

