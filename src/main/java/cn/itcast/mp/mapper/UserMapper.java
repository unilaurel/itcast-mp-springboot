package cn.itcast.mp.mapper;

import cn.itcast.mp.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserMapper
 * Package: cn.itcast.mp.mapper
 * Description：
 *
 * @Author :zyp
 * @Create 2023/07/31 22:06
 * @Version 1.0
 */

public interface UserMapper extends MyBaseMapper<User> {

    User findById(Long id);
}
