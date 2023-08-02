package cn.itcast.mp;

import cn.itcast.mp.injectors.MySqlInjector;
import cn.itcast.mp.plugins.MyInterceptor;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MybatisPlusConfig
 * Package: cn.itcast.mp
 * Description：
 *
 * @Author :zyp
 * @Create 2023/08/01 1:53
 * @Version 1.0
 */
@Configuration
public class MybatisPlusConfig {
//    @Bean  //配置分页插件
//    public PaginationInterceptor paginationInterceptor(){
//        return new PaginationInterceptor();
//    }

    @Bean //注入自定义拦截器
    public MyInterceptor myInterceptor(){
     return new MyInterceptor();
    }

    @Bean //sql分析插件
    public SqlExplainInterceptor sqlExplainInterceptor(){
        SqlExplainInterceptor sqlExplainInterceptor=new SqlExplainInterceptor();
        List<ISqlParser> list=new ArrayList<>();
        ISqlParser iSqlParser=new BlockAttackSqlParser();//全表更新，删除的阻断器
        list.add(iSqlParser);
        sqlExplainInterceptor.setSqlParserList(list);
        return sqlExplainInterceptor;
    }

    @Bean //注入自定义的SQL注入器
    public MySqlInjector   mySqlInjector(){
        return new MySqlInjector();
    }
}
