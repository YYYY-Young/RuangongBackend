package com.diamond.controller;

import com.diamond.entity.Doc;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.DocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Classname DocController
 * @Description TODO
 * @Date 2020/8/11 16:55
 * @Created by lrf
 */
@RestController
@Api(tags="文档操作类接口，垃圾文章接口")
public class DocController {
    @Autowired
    DocService docService;

    @PostMapping("/api/doc/save")
    public Result saveDoc(@RequestBody @Valid Doc doc) {
        int re=docService.addOrUpdate(doc);
        if (re == 1) {
            return ResultFactory.buildSuccessResult("保存成功");
        }
        if (re == 0) {
            return ResultFactory.buildFailResult("没有权限进行文章修改保存");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    @GetMapping("/api/doc/getone/{id}/{uid}")
    public Result getOneDoc(@PathVariable("id") int id, @PathVariable("uid") int uid) {
        Doc doc=docService.findById(uid,id);
        if (doc != null) {
            return ResultFactory.buildSuccessResult(doc);
        } else {
            return ResultFactory.buildFailResult("没有权限查看");
        }
    }

    //    @ApiOperation(value = "获取最近阅读的文件", notes = "传入获取人的id", httpMethod = "GET")
//    @GetMapping("/api/doc/docread/{uid}")
//    public Result getdocread(@PathVariable("uid") int uid){
//        return ResultFactory.buildSuccessResult(docService.findbyuidread(uid));
//    }
//    @ApiOperation(value = "获取收藏的文件", notes = "传入收藏人的id", httpMethod = "GET")
//    @GetMapping("/api/doc/doclike/{uid}")
//    public Result likeDoc(@PathVariable("uid") int uid){
//        return ResultFactory.buildSuccessResult(docService.findbyuidlike(uid));
//    }
//    @ApiOperation(value = "获取被别人分享的文件", notes = "传入收藏人的id", httpMethod = "GET")
//    @GetMapping("/api/doc/docshare/{uid}")
//    public Result shareDoc(@PathVariable("uid") int uid){
//        return ResultFactory.buildSuccessResult(docService.findbyuidlike(uid));
//    }
    @DeleteMapping("/api/doc/deleteone/{id}/{uid}")
    public Result deleteDoc(@PathVariable("id") int id, @PathVariable("uid") int uid) {
        int re=docService.delete(uid, id);
        if (re == 1) {
            return ResultFactory.buildSuccessResult("成功将文件放入回收站");
        }
        if (re == 2) {
            return ResultFactory.buildSuccessResult("成功永久删除文件");
        }
        if (re == 0) {
            return ResultFactory.buildFailResult("没有权限删除文件");
        }
        return ResultFactory.buildFailResult("未知错误");

    }

    @GetMapping("/api/doc/share/{fromuid}/{touid}/{msg}/{docid}")
    public Result shareDoc(@PathVariable("fromuid") int fromuid, @PathVariable("touid") int touid,
                           @PathVariable("msg") String msg, @PathVariable("docid") int docid) {
        int re=docService.share(fromuid, touid, docid, msg);
        if (re == 1) {
            return ResultFactory.buildSuccessResult("分享成功");
        }
        if (re== 0) {
            return ResultFactory.buildFailResult("没有分享权限，分享失败");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    @ApiOperation(value = "恢复文件", notes = "传入需要恢复文件的文件id", httpMethod = "GET")
    @DeleteMapping("/api/notrash/{uid}/{docid}")
    public Result restore(@PathVariable ("uid")int uid, @PathVariable ("docid")int docid) {
        docService.resume(uid, docid);
        return ResultFactory.buildSuccessResult("成功恢复文件");
    }

    @GetMapping("/api/doc/trashdocs/{uid}")
    public Result trashdocs(@PathVariable int uid) {
        return ResultFactory.buildSuccessResult(docService.findtrash(uid));
    }
    @GetMapping("api/doc/teamdocs/{uid}/{tid}")
    public Result teamdocs(@PathVariable ("uid")int uid,@PathVariable ("tid") int tid){
        return ResultFactory.buildSuccessResult(docService.findteamdocs(uid,tid));
    }
    @GetMapping("/api/doc/founder/{uid}")
    public Result founderdocs(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(docService.findfoundeddocs(uid));
    }
    @GetMapping("/api/doc/search/title/{uid}/{keyword}")
    public Result finddocsbytitle(@PathVariable("uid") int uid,@PathVariable("keyword") String keyword){
        return ResultFactory.buildSuccessResult(docService.finddocsbytitle(uid,keyword));
    }
    @GetMapping("/api/doc/search/author/{uid}/{keyword}")
    public Result finddocsbyauthor(@PathVariable("uid") int uid,@PathVariable("keyword") String keyword){
        return ResultFactory.buildSuccessResult(docService.finddocsbyauthor(uid,keyword));
    }
    @GetMapping("/api/doc/search/content/{uid}/{keyword}")
    public Result finddocsbycontent(@PathVariable("uid") int uid,@PathVariable("keyword") String keyword){
        return ResultFactory.buildSuccessResult(docService.finddocsbycontent(uid,keyword));
    }
    @GetMapping("/api/doc/ifedit/{docid}")
    public Result ifedit(@PathVariable("docid")int docid){
        int re=docService.ifisbeeneditting(docid);
        if(re==1){
            return ResultFactory.buildSuccessResult("能进行修改");
        }else {
            return ResultFactory.buildFailResult("该文档正在被修改");
        }
    }

}


