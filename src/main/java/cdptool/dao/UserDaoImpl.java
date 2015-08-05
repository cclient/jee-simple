package cdptool.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cdptool.entity.account;
@Repository  
public class UserDaoImpl {
	 private SqlSession sqlSession;
	 @Autowired
	  public void setSqlSession(SqlSession sqlSession) {
	    this.sqlSession = sqlSession;
	  }

	  public account getUser(String userId) {
//	    return (account) sqlSession.selectOne("cdptool.AccountMapper.getUser", userId);
	    return (account) sqlSession.selectOne("cdptool.dao.AccountMapper.getUser", userId);
	  }
}
