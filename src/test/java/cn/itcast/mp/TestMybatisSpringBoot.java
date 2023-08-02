package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ClassName: TestMybatisSpringBoot
 * Package: cn.itcast.mp
 * Description：
 *
 * @Author :zyp
 * @Create 2023/07/31 22:15
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMybatisSpringBoot  {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email","%itcast%");
//        List<User> users = userMapper.selectList(null);
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);

        }

    }
}
