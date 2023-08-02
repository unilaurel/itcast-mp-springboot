package cn.itcast.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: MyApplication
 * Package: cn.itcast.mp
 * Description：
 *
 * @Author :zyp
 * @Create 2023/07/31 22:08
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("cn.itcast.mp.mapper")
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
