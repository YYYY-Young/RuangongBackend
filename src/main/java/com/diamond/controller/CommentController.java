package com.diamond.controller;

import com.diamond.entity.Comment;
import com.diamond.entity.Doc;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags="评价类接口")
public class CommentController {
    @Autowired
    CommentService commentService;
    @ApiOperation(value = "新建评论", notes = "传入一个评论的json数据格式，时间不用传", httpMethod = "POST")
    @PostMapping("/api/comment/save")
    public Result saveComment(@RequestBody @Valid Comment comment){
        if(commentService.addOrUpdate(comment)==1){
            return ResultFactory.buildSuccessResult("保存成功");
        }
        if(commentService.addOrUpdate(comment)!=1){
            return ResultFactory.buildFailResult("没有权限进行文章评论");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @ApiOperation("删除评论")
    @DeleteMapping("/api/comment/delete/{uid}/{cid}")
    public Result deleteComment(@PathVariable("uid") int uid, @PathVariable("cid") int cid){
        if(commentService.delete(uid,cid)==1){
            return ResultFactory.buildSuccessResult("删除评论成功");
        }
        if(commentService.delete(uid,cid)==0){
            return ResultFactory.buildFailResult("没有资格删除评论");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    @GetMapping("/api/comment/getcommentbyuser/{uid}")
    public Result getCommentbyuser(@PathVariable("uid")int uid){
        return ResultFactory.buildSuccessResult(commentService.getCommentbyuid(uid));
    }

    @GetMapping("/api/comment/getcommentbydoc/{docid}")
    public Result getCommentbydoc(@PathVariable("docid")int docid){
        return ResultFactory.buildSuccessResult(commentService.getCommentbydocid(docid));
    }


}
