package cn.itcast.mp.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MySqlInjector
 * Package: cn.itcast.mp.injectors
 * Description：
 *
 * @Author :zyp
 * @Create 2023/08/02 0:10
 * @Version 1.0
 */
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> list = new ArrayList<>();
        //获取父类中集合
        list.addAll(super.getMethodList());
        //扩充集合
        list.add(new FindAll());
        return list;
    }
}
