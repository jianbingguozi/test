package test.dao;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.User;

public class Test_01 {
	public static void main(String[] args) throws IOException {
		//连接配置文件
		String resource="conf.xml";
		InputStream stream = Test_01.class.getClassLoader().getResourceAsStream(resource);
		//构建工厂
		
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(stream);
		
		SqlSession openSession = build.openSession();
		 String statement = "com.Maven.mapping.userMap.getUser";//映射sql的标识字符串
	      //执行查询返回一个唯一user对象的sql
	      User user = openSession.selectOne(statement, 1);
	      System.out.println(user);
		
	}

}
