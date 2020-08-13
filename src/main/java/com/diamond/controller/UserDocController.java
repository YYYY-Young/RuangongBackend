package com.diamond.controller;

import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.UserDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserDocController
 * @Description TODO
 * @Date 2020/8/12 13:23
 * @Created by lrf
 */
@RestController
public class UserDocController {
    @Autowired
    UserDocService userDocService;
    @GetMapping("api/admin/content/doc/list/{uid}")
    public Result getDocsByuid(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userDocService.userDocs(uid));
    }

}
