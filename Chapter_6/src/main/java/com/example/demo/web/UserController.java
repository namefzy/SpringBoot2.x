package com.example.demo.web;

import com.example.demo.domain.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Api： 描述Controller
 * @ApiIgnore： 忽略该Controller，指不对当前类做扫描
 * @ApiOperation： 描述Controller类中的method接口
 * @ApiParam： 单个参数描述，与@ApiImplicitParam不同的是，他是写在参数左侧的。如（@ApiParam(name = "username",value = "用户名") String username）
 * @ApiModel： 描述POJO对象
 * @ApiProperty： 描述POJO对象中的属性值
 * @ApiImplicitParam： 描述单个入参信息
 * @ApiImplicitParams： 描述多个入参信息
 * @ApiResponse： 描述单个出参信息
 * @ApiResponses： 描述多个出参信息
 * @ApiError： 接口错误所返回的信息
 *
 * todo
 */
@RestController
@Api(tags = "1.1",value = "用户管理")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping("user")
    @ApiOperation(value = "条件查询")
    public User qurey(String username,int age){
        return new User(username,age);
    }

//    @GetMapping("/{id}")
//    @ApiOperation(value = "主键查询（DONE）")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.QUERY)
//    })
//    public User get(@PathVariable String id) {
//        log.info("--------------@ApiImplicitParam");
//        return new User("1",1);
//    }
//
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "删除用户（DONE）")
//    @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
//    public void delete(@PathVariable Long id) {
//        log.info("单个参数用 ApiImplicitParam");
//    }
//
//    @PostMapping
//    @ApiOperation(value = "添加用户（DONE）")
//    public User post(@RequestBody User user) {
//        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
//        return user;
//    }
//
//    @GetMapping("/{id}")
//    @ApiOperation(value = "修改用户（DONE）")
//    public void put(@PathVariable Long id, @RequestBody User user) {
//        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
//    }
}
