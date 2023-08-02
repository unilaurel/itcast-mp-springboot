package cn.itcast.mp;

import cn.itcast.mp.enums.SexEnum;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ClassName: TestUserMapper2
 * Package: cn.itcast.mp
 * Description：
 *
 * @Author :zyp
 * @Create 2023/08/01 21:36
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper2 {
    @Test
    public void testSelectById(){
        User user = new User();
        user.setId(17L);
        User user1 = user.selectById();
        System.out.println(user1);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("2gou");
        user.setPassword("1111111");
        user.setSex(SexEnum.WOMAN);
        boolean insert = user.insert();
        System.out.println(insert);
    }
    
    @Test
    public void testUpadateById(){
        User user = new User();
        user.setId(17L);
        user.setUserName("baosangsang");
        user.setPassword("22222");
        boolean b = user.updateById();
        System.out.println(b);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserName("baosangsang");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>(user);
        wrapper.set("password","0000");
        wrapper.set("user_name","fafafafafaf");
        boolean  b = user.update(wrapper);
        System.out.println(b);
    }
    
    @Test
    public void testDelete(){
        User user = new User();
        user.setId(17L);
        boolean b = user.deleteById();
        System.out.println(b);
    }
    
    @Test
    public void testSelect(){
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",20L);
        List<User> users = user.selectList(wrapper);
        for (User user1 : users) {
            System.out.println(user1);
            
        }
    }

    @Test
    public void testSelect2(){
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("sex",SexEnum.WOMAN);
        List<User> users = user.selectList(wrapper);
        for (User user1 : users) {
            System.out.println(user1);

        }
    }
}
