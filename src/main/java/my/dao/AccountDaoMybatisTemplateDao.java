package my.dao;

import my.entity.Account;
import my.idao.IAccountDao;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;


@Repository
public class AccountDaoMybatisTemplateDao implements IAccountDao {
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public boolean saveAccount(Account account){
        int res = sessionTemplate.insert("my.dao.AccountMapper.saveAccount");
        return res > 0;
    }

    public boolean delAccount(Account account){
        int res = sessionTemplate.delete("my.dao.AccountMapper.delAccount", account.getId());
        return res > 0;
    }

    public boolean updateUser(Account account){
        int res = sessionTemplate.update("my.dao.AccountMapper.updateAccount");
        return res > 0;
    }

    public Account getAccountById(int id){
        return (Account) sessionTemplate.selectOne("my.dao.AccountMapper.getAccount", id);
    }
}

