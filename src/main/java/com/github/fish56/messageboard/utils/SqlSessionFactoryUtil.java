package com.github.fish56.messageboard.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static String RESOURCE = "mybatis.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            InputStream is = Resources.getResourceAsStream(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    public  static void closeSqlSession(SqlSession session){
        if(session != null) {
            try {
                session.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
