package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//    private Logger logs = Logg
    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
//        List<User> u1 = userMapper.findUserByName("1");
        PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.findUserByName("1"));
        System.out.println("[lambda写法] - [分页信息] - [{}]"+pageInfo.toString());
//        for (User user : u1) {
//            System.out.println(user.getAge()+"------------------"+user.getName());
//        }

    }

}
