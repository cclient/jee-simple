package my.dao;

import my.entity.Account;
import my.entity.AccountMapper;
import my.idao.IAccountDao;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("AccountMybatisMapperDao")
public class AccountMybatisMapperDao implements IAccountDao {
    //    @Autowired
    private SqlSessionTemplate sessionTemplate;

    private AccountMapper mapper;
    @Autowired
    public AccountMybatisMapperDao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
        mapper = this.sessionTemplate.getMapper(AccountMapper.class);
    }

    public boolean saveAccount(Account account) {
        int res = mapper.saveAccount(account.getUsername());
        return res > 0;
    }

    public boolean delAccount(Account account) {
        int res = mapper.delAccount(account.getId());
        return res > 0;
    }

    public boolean updateUser(Account account) {
        int res = mapper.updateAccount(account.getUsername(), account.getId());
        return res > 0;
    }

    public Account getAccountById(int id) {
        return mapper.getAccount(id);
    }
}

