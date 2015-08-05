package cdptool.dao;

import cdptool.entity.account;

public class FooServiceImpl {
	private AccountMapper userMapper;

	public void setUserMapper(AccountMapper userMapper) {
	  this.userMapper = userMapper;
	}

	public account doSomeBusinessStuff(String userId) {
	  return this.userMapper.getUser(userId);
	}
}
