package com.diamond.controller;

import com.diamond.entity.Doc;
import com.diamond.entity.Team;
import com.diamond.entity.User;
import com.diamond.entity.UserTeam;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.DocService;
import com.diamond.service.TeamService;
import com.diamond.service.UserTeamService;
import io.swagger.annotations.Api;
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
@Api(tags = "团队类接口")
@RestController
public class UserTeamController {
    @Autowired
    UserTeamService userTeamService;
    @Autowired
    DocService docService;
    @Autowired
    TeamService teamService;
    @GetMapping("/api/team/findteams/{uid}")
    public Result listTeams(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllByUid(uid));
    }
    @GetMapping("/api/team/findusers/{tid}")
    public Result listUsers(@PathVariable("tid")int tid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllByTid(tid));
    }
    @GetMapping("/api/team/findteamsnotaccepted/{uid}")
    public Result listUsersnotaccepted(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllnotacceptedByUid(uid));
    }
    @GetMapping("/api/team/findusersnotaccepted/{tid}")
    public Result listTeamsnotaccepted(@PathVariable("tid")int tid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllnotacceptedByTid(tid));
    }
    @GetMapping("/api/team/findthrown/{uid}")
    public Result findthrown(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllthrownByUid(uid));
    }
    @GetMapping("/api/team/accept/{id}")
     public Result acceptinvatation(@PathVariable("id") int id){
        int re=userTeamService.acceptinvatation(id);
        if(re==1){
            return ResultFactory.buildSuccessResult("成功接受了邀请");
        }
        if(re==0){
            return ResultFactory.buildFailResult("找不到邀请的记录，请刷新");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @PutMapping("/api/team/edit")
    public Result addOrUpdateUserTeam(@RequestBody @Valid UserTeam userTeam) {
        userTeamService.addOrUpdate(userTeam);
        return ResultFactory.buildSuccessResult("修改成功");
    }
    @PostMapping("api/team/resetmembers")
    public Result initteammembers(@RequestBody @Valid List<UserTeam> userTeamList){
        UserTeam userTeam=userTeamList.get(0);
        userTeamService.initmembers(userTeam.getTid(),userTeamList);
        return ResultFactory.buildSuccessResult("已删除原有记录并批量添加");
    }
    @DeleteMapping("/api/team/deleteuser/{id}")
    public Result deleteUser(@PathVariable("id") int id){
        userTeamService.deleteUserTeam(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }
    @PostMapping("/api/team/initteam")
    public Result initteam(@RequestBody @Valid Team team){
        teamService.initTeam(team);
        return ResultFactory.buildSuccessResult("创建成功");
    }
    @DeleteMapping("/api/team/delete/{uid}/{tid}")
    public Result deleteteam(@PathVariable("uid") int uid,@PathVariable("tid") int tid){
        int re=teamService.deleteTeam(uid,tid);
        if(re==1){
            return ResultFactory.buildSuccessResult("成功删除");
        }else {
            return ResultFactory.buildFailResult("删除失败");
        }
    }

}
