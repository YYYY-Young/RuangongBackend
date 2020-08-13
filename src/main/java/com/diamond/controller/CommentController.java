package com.diamond.controller;

import com.diamond.entity.Comment;
import com.diamond.entity.Doc;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Classname CommentController
 * @Description TODO
 * @Date 2020/8/12 1:43
 * @Created by lrf
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("api/admin/content/comment/save")
    public Result saveComment(@RequestBody @Valid Comment comment){
        if(commentService.addOrUpdate(comment)==1){
            return ResultFactory.buildSuccessResult("保存成功");
        }
        if(commentService.addOrUpdate(comment)!=1){
            return ResultFactory.buildFailResult("没有权限进行文章评论");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @DeleteMapping("api/admin/content/comment/delete/{uid}/{cid}")
    public Result deleteComment(@PathVariable("uid") int uid, @PathVariable("cid") int cid){
        if(commentService.delete(uid,cid)==1){
            return ResultFactory.buildSuccessResult("删除评论成功");
        }
        if(commentService.delete(uid,cid)==0){
            return ResultFactory.buildFailResult("没有资格删除评论");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

}
