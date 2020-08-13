package com.diamond.controller;

import com.diamond.entity.Doc;
import com.diamond.entity.User;
import com.diamond.entity.UserTeam;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.DocService;
import com.diamond.service.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Classname UserTeamController
 * @Description TODO
 * @Date 2020/8/11 15:19
 * @Created by lrf
 */
@RestController
public class UserTeamController {
    @Autowired
    UserTeamService userTeamService;
    @Autowired
    DocService docService;
    @GetMapping("/api/admin/team/findteams/{uid}")
    public Result listUsers(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllByUid(uid));
    }
    @GetMapping("/api/admin/team/findusers/{tid}")
    public Result listTeams(@PathVariable("tid")int tid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllByTid(tid));
    }
    @PutMapping("/api/admin/team/edit")
    public Result addOrUpdateUserTeam(@RequestBody @Valid UserTeam userTeam) {
        userTeamService.addOrUpdate(userTeam);
        return ResultFactory.buildSuccessResult("修改成功");
    }
    @PostMapping("/api/admin/team/deleteuser")
    public Result deleteUser(@RequestBody @Valid UserTeam userteam){
        userTeamService.deleteUserTeam(userteam);
        return ResultFactory.buildSuccessResult("删除成功");
    }
}
