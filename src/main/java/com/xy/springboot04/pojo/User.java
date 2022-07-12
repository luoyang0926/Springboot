package com.xy.springboot04.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;


    private Long id;
    private String name;
    private Integer age;
    private String email;
}
