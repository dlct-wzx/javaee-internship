import com.dlct.model.UserService;
import com.dlct.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class mytest {
    @Test
    public void selectALL() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.list());
    }

    @Test
    public void insertUser() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.insertUser(new User(0, "dlct", "123456")));
    }

    @Test
    public void updateUser() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.updataUser(new User(1, "wzx", "123456")));
    }

    @Test
    public void deleteUser() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.deleteUser(1));
    }
}