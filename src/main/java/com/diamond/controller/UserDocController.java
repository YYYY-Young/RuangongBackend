package com.diamond.controller;

import com.diamond.entity.UserDoc;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.UserDocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @Classname UserDocController
 * @Description TODO
 * @Date 2020/8/12 13:23
 * @Created by lrf
 */
@RestController
@Api(tags="文档记录类接口")
public class UserDocController {
    @Autowired
    UserDocService userDocService;
    @GetMapping("api/doc/list/read/{uid}")
    @ApiOperation(value = "文章最近阅读", notes = "打开编辑文章都会增加一条记录，不查重，现在前端得到的是List类型的" +
            "阅读记录，阅读记录中有文档属性，文档为userdoc.doc，也为对象，调取文档属性如id可用usedoc.doc.id调取，其他文档记录接口一样用法", httpMethod = "POST")
    public Result getDocsReadByuid(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userDocService.findByRead(uid));
    }
    @GetMapping("api/doc/list/edit/{uid}")
    public Result getDocsEditByuid(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userDocService.findByEdit(uid));
    }
    @GetMapping("api/doc/list/share/{uid}")
    public Result getDocsShareByuid(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userDocService.findByShare(uid));
    }
    @GetMapping("api/doc/likes/{docid}")
    public  Result getDocLikes(@PathVariable("docid") int docid){
        return ResultFactory.buildSuccessResult(userDocService.finddoclikes(docid));
    }
    @GetMapping("api/doc/list/likes/{uid}")
    public  Result getUserDocLikes(@PathVariable("uid") int uid){
        return ResultFactory.buildSuccessResult(userDocService.finduserlikes(uid));
    }
    @GetMapping("api/doc/islike/{uid}/{docid}")
    public Result islike(@PathVariable("uid") int uid,@PathVariable("docid") int docid){
        UserDoc userDoc=userDocService.islike(uid,docid);
        return ResultFactory.buildSuccessResult(Objects.requireNonNullElse(userDoc, "没有收藏记录"));
    }
    @PostMapping("api/doc/editrecord")
    public Result editRecord(@RequestBody @Valid UserDoc userDoc){
        userDocService.AddRecord(userDoc);
        return ResultFactory.buildSuccessResult("成功添加记录");

    }
    @DeleteMapping("api/doc/deleterecord/{id}")
    public Result deleteRecord(@PathVariable("id") int id){
        userDocService.deleteRecord(id);
        return ResultFactory.buildSuccessResult("成功删除");
    }


}
