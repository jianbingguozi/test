package test.dao.user;

import domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jianb on 2016/11/23.
 */
public interface UserDao {
    @Select("SELECT * FROM users")
    List<User> selectUsers();

    @Select("select * from users where id = #{id}")
    User selectById(Integer id);
}
