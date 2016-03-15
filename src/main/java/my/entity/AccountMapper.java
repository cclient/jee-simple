package my.entity;

import org.apache.ibatis.annotations.*;

public interface AccountMapper {
    //    @Select("SELECT * FROM account WHERE id = #{id}")
    Account getAccount(@Param("id") int id);

    //    @Insert("INSERT INTO account (username) VALUES(#{username});")
    int saveAccount(@Param("username") String username);

    //    @Delete("DELETE FROM account WHERE id =#{id};")
    int delAccount(@Param("id") int id);

    //    @Update("UPDATE account SET username=#{username} WHERE id = #{id}")
    int updateAccount(@Param("username") String username, @Param("id") int id);
}
