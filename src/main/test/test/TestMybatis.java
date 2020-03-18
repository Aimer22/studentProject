package test;

import com.cn.dao.StuClassDao;
import com.cn.dao.StudentDao;
import com.cn.domain.StuClass;
import com.cn.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class TestMybatis{
        private InputStream in;
        private SqlSession sqlSession;
        private StuClassDao stuClassDao;

        @Before
    public void init() throws Exception{
        //1.读取配置文件
         in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产sqlSeesion
        sqlSession=factory.openSession();
        //4.使用sqlSession创建Dao接口的代理对象
        stuClassDao =sqlSession.getMapper(StuClassDao.class);
    }
    @After
    public void destory() throws Exception{
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

}
