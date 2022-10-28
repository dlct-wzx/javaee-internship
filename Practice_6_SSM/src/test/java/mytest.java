import com.dlct.Mapper.BookMapper;
import com.dlct.Mapper.UserMapper;
import com.dlct.pojo.Books;
import com.dlct.service.BookServiceImpl;
import com.dlct.service.UserServiceImpl;
import com.dlct.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class mytest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Books> books = mapper.selectAllBook();
        for (Books book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void user(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
        String s = userServiceImpl.selectUserByName("123456");
        System.out.println(s);
    }
}
