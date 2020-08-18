package com.diamond.controller;

import com.diamond.entity.User;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.EmailService;
import com.diamond.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/8/10 15:30
 * @Created by lrf
 */
@Api(tags = "用户管理类接口")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    @GetMapping("/api/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.userList());
    }
    @PutMapping("/api/user/status")
    public Result updateUserStatus(@RequestBody @Valid User requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }

    @PutMapping("/api/user/password")
    public Result resetPassword(@RequestBody @Valid User requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

    @PutMapping("/api/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        return ResultFactory.buildSuccessResult(userService.editUser(requestUser));
    }
    @PutMapping("api/user/emailchange")
    public Result editemail(@RequestBody @Valid User user){
        return ResultFactory.buildSuccessResult(userService.editemail(user));

    }
    @GetMapping("/api/getuser/{username}")
    public Result getuser(@PathVariable("username") String username){
       return ResultFactory.buildSuccessResult(userService.findByUsername(username));
    }
    @GetMapping("/api/sendemail/{email}")
    public Result sendemail(@PathVariable("email") String email){
        emailService.sendMsg(email);
        return ResultFactory.buildSuccessResult("发送成功");
    }

}
