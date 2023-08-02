package cn.itcast.mp.injectors;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;

/**
 * ClassName: FindAll
 * Package: cn.itcast.mp.injectors
 * Description：
 *
 * @Author :zyp
 * @Create 2023/08/02 0:12
 * @Version 1.0
 */
public class FindAll extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql="select * from "+tableInfo.getTableName() ;
        SqlSource sqlSource= languageDriver.createSqlSource(configuration,sql,modelClass );
        return this.addSelectMappedStatement(mapperClass, "findAll", sqlSource, modelClass, tableInfo);

    }
}
