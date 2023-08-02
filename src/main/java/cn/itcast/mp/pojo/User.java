package cn.itcast.mp.pojo;

import cn.itcast.mp.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

/**
 * ClassName: User
 * Package: cn.itcast.mp.pojo
 * Description：
 *
 * @Author :zyp
 * @Create 2023/07/31 22:05
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tb_user")
public class User extends Model<User> {
//    @TableId(type=IdType.AUTO)
    private Long id;
    private String userName;
    @TableField(select = false)
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email",fill = FieldFill.INSERT)
    private String mail;
    @TableField(exist = false)
    private String address;

    @Version //乐观锁的版本字段
    private Integer version;

    @TableLogic //逻辑删除字段，1删除，0未删除
    private Integer deleted;

    private SexEnum sex;//性别，枚举
}
