package cn.itcast.mp;

import cn.itcast.mp.mapper.UserMapper;
import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.minidev.json.writer.UpdaterMapper;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.TestTimedOutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.*;

/**
 * ClassName: TestUserMapper
 * Package: cn.itcast.mp
 * Description：
 *
 * @Author :zyp
 * @Create 2023/07/31 22:38
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("muri");
        user.setPassword("123123");
        user.setAddress("haha");
        user.setMail("111");
        int num = userMapper.insert(user);//返回值为数据库受影响的行数
        System.out.println("num"+num);
        System.out.println("userID:"+user.getId());
    }

    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteByID(){
//
        int i = userMapper.deleteById(1686011052285435908L);
        System.out.println("i:"+i);

    }

    @Test
    public void test(){
       Integer i=new Integer(5);
    }

    @Test
    public void testUpdateById(){
        User user = userMapper.selectById(1L);
        user.setUserName("yp");
        userMapper.updateById(user);
    }

    @Test
    public void testUpdate1(){
        User user = new User();
        user.setPassword("fafafa");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "lisi");
        userMapper.update(user, wrapper);
    }

    @Test
    public void testUpdate2(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 100).set("user_name", "pppppp").eq("age", 24);
        userMapper.update(null, wrapper);
    }

    @Test
    public void testDeleteByMap(){
        Map<String, Object> map=new HashMap<>();
        map.put("user_name","yp");
        map.put("password", "123456");
        userMapper.deleteByMap(map);
    }

    @Test
    public void testDelete(){

//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("id", 3L);


        User user=new User();
        user.setPassword("123456");
        user.setUserName("zhaoliu");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        userMapper.delete(wrapper);
    }

    @Test
    public void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(5L,7L));
    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(10L, 12L));
        System.out.println(users);
    }


    @Test
    public void testSelectOne(){
        QueryWrapper<User> Wrapper=new QueryWrapper<>();
        Wrapper.eq("user_name", "lisi");
        User user = userMapper.selectOne(Wrapper);
        System.out.println(user);
    }
    
    @Test
    public void testSelectCount(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.gt("id",13L);
//        Integer integer = userMapper.selectCount(wrapper);
        Integer integer = userMapper.selectCount(null);
        System.out.println("num:"+integer);

    }

    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(2,2);

        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage.getRecords());

    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(10L);
        System.out.println(user);
    }

    @Test
    public void testAlleq(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> map=new HashMap<>();
        map.put("id",2L);
        map.put("user_name", "lisi");
        map.put("email","test2@itcast.cn");
        map.put("password",null);
//        wrapper.allEq(map);
//        wrapper.allEq(map,false);
        wrapper.allEq((k,v)->(k.equals("email") || k.equals("user_name")),map,false);
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);

        }
    }

    @Test
    public void testUpdateAll(){
        User user = new User();
        user.setAge(17);
        boolean b = user.update(null);
        System.out.println(b );
    }

    @Test //测试乐观锁
    public void testUpdate(){
        User user = new User();
        user.setId(2L);
        user.setAge(2022);

        User userVersion=user.selectById();
        user.setVersion(userVersion.getVersion());//当前版本信息
        boolean b = user.updateById();
        System.out.println(b);
    }


    //自定义SQL注入
    @Test
    public void testFindAll(){
//        List<User> all = userMapper.findAll();

//        userMapper.selectList(null)
//        for (User user : all) {
//            System.out.println(all);
//        }

    }


}
