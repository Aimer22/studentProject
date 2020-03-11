package test;

import com.cn.dao.StudentDao;
import com.cn.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in= Resources.getResourceAsStream("Mybatis.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //3.使用工厂生产sqlSeesion
        SqlSession session=factory.openSession();
        //4.使用sqlSession创建Dao接口的代理对象
        StudentDao studentDao=session.getMapper(StudentDao.class);
        //5。使用代理对象执行方法
        List<Student> students=studentDao.getAll();
        for (Student student:students){
            System.out.println(student);
        }
        //6.释放资源
        session.close();
        in.close();

    }
}
