package cdptool.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cdptool.entity.account;

public interface AccountMapper {
	@Select("SELECT * FROM account WHERE id = #{userId}")
	  account getUser(@Param("userId") String userId);
}
