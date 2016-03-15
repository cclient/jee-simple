package my.dao;

import my.entity.Account;
import my.entity.AccountMapper;
import my.idao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("AccountMybatisMapperIocDao")
public class AccountMybatisMapperIocDao implements IAccountDao {
    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper mapper;
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

