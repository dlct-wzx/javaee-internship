import com.dlct.Mapper.UserMapper;
import com.dlct.pojo.User;
import com.dlct.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
