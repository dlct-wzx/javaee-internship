import com.dlct.dao.UserDao;
import com.dlct.pojo.User;
import com.dlct.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {
    @Test
    public void test() {
        UserDao userService = new UserService();
    }
}
