package my.dao;

import my.entity.Account;
import org.apache.ibatis.annotations.*;

public interface AccountMapper {
    @Select("SELECT * FROM account WHERE id = #{accountid}")
    Account getAccount(@Param("accountid") int id);
    @Insert("INSERT INTO account (username) VALUES(#{username});")
    int saveAccount(@Param("username") String username);
    @Delete("DELETE FROM account WHERE id =#{id};")
    int delAccount(@Param("id") int id);
    @Update("UPDATE account SET username=#{username} WHERE id = #{id}")
    int updateAccount(@Param("username") String username,@Param("id") int id);
}
