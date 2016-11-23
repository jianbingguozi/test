package test.dao;

import domain.User;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import test.dao.user.UserDao;

import java.io.InputStream;
import java.util.List;

/**
 * Created by jianb on 2016/11/23.
 */
public class AnnotionDBTest {
    private SqlSession sqlSession;

    @Before
    public void initSqlSession(){
        InputStream stream = AnnotionDBTest.class.getClassLoader().getResourceAsStream("conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        this.sqlSession = factory.openSession();
    }
    @After
    public void destroySqlSession(){
        if (null != sqlSession){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void selectTest1(){
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
