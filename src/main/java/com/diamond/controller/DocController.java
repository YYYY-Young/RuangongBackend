package com.diamond.controller;

import com.diamond.entity.Doc;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Classname DocController
 * @Description TODO
 * @Date 2020/8/11 16:55
 * @Created by lrf
 */
@RestController
public class DocController {
    @Autowired
    DocService docService;
    @PostMapping("api/admin/content/doc/save")
    public Result saveDoc(@RequestBody @Valid Doc doc){
        if(docService.addOrUpdate(doc)==1){
          return ResultFactory.buildSuccessResult("保存成功");
        }
        if(docService.addOrUpdate(doc)!=1){
            return ResultFactory.buildFailResult("没有权限进行文章修改保存");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @GetMapping("/api/admin/content/doc/alldoc/{size}/{page}")
    public Result listdocs(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(docService.list(page - 1, size));
    }

    @GetMapping("/api/admin/content/doc/getone/{id}/{uid}")
    public Result getOneDoc(@PathVariable("id") int id,@PathVariable("uid") int uid) {
        if (docService.findById(uid,id)!=null){
            return ResultFactory.buildSuccessResult(docService.findById(uid,id));
        }else {
            return ResultFactory.buildFailResult("没有权限查看");
        }
    }

    @DeleteMapping("/api/admin/content/doc/deleteone/{id}/{uid}")
    public Result deleteDoc(@PathVariable("id") int id,@PathVariable("uid") int uid) {
        if(docService.delete(uid,id)==1){
            return ResultFactory.buildSuccessResult("删除成功");
        }
        if(docService.delete(uid,id)!=1){
            return ResultFactory.buildFailResult("没有权限删除文章");
        }
        return ResultFactory.buildFailResult("未知错误");

    }
    @GetMapping("api/admin/content/doc/share/{fromuid}/{touid}/{msg}/{docid}")
    public Result shareDoc(@PathVariable("fromuid")int fromuid,@PathVariable("touid")int touid,
                           @PathVariable("msg")String msg,@PathVariable("docid")int docid){
        if(docService.share(fromuid,touid,docid,msg)==1){
            return ResultFactory.buildSuccessResult("分享成功");
        }
        if(docService.share(fromuid,touid,docid,msg)==0){
            return ResultFactory.buildFailResult("没有分享权限，分享失败");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @PostMapping("/api/admin/trash/{uid}/{docid}")
    public Result restore(@PathVariable int uid,@PathVariable int docid){
        int b=docService.restoreDoc(uid,docid);
        if (b==0){
            return ResultFactory.buildFailResult("无法恢复文件");
        }else{
            return ResultFactory.buildSuccessResult("成功恢复文件");
        }
    }


}
