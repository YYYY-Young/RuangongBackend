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
    public Result listUsers(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllByUid(uid));
    }
    @GetMapping("/api/team/findusers/{tid}")
    public Result listTeams(@PathVariable("tid")int tid){
        return ResultFactory.buildSuccessResult(userTeamService.listAllByTid(tid));
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

}
