package cn.itcast.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * ClassName: MyBaseMapper
 * Package: cn.itcast.mp.mapper
 * Description：
 *
 * @Author :zyp
 * @Create 2023/08/02 0:06
 * @Version 1.0
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {
    List<T> findAll();
}
