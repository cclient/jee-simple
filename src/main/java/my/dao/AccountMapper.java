package my.dao;

import my.entity.Account;
import org.apache.ibatis.annotations.*;

public interface AccountMapper {
    @Select("SELECT * FROM account WHERE id = #{accountid}")
    Account getAccount(@Param("accountid") int id);
    @Insert("INSERT INTO account (username) VALUES(#{username});")
    int saveAccount(@Param("useranem") String username);
    @Delete("DELETE account WHERE id = #{accountid};")
    int delAccount(@Param("accountid") int id);
    @Update("UPDATE account SET username=#{username} WHERE id = #{accountid}")
    int updateAccount(@Param("username") String username,@Param("accountid") int id);
}
