package cn.itcast.mp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyMetaObjectHandler
 * Package: cn.itcast.mp.handler
 * Description：
 *
 * @Author :zyp
 * @Create 2023/08/02 10:32
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //先获取password值，如果为空则填充
        Object password = getFieldValByName("password", metaObject);
        if (password == null) {
            setFieldValByName("password", "888888888", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
