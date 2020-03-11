package test;

import com.cn.service.StudentService;
import com.cn.service.impl.StudentServiceImpl;
import com.cn.util.Agent;

import java.lang.reflect.InvocationHandler;

public class TestAgent {
    public static void main(String[] args) {
        StudentService studentService=new StudentServiceImpl();
        InvocationHandler agentManager=new Agent(studentService);
    }
}
