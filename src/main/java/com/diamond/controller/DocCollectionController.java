package com.diamond.controller;

import com.diamond.entity.DocCollection;
import com.diamond.result.Result;
import com.diamond.result.ResultFactory;
import com.diamond.service.DocCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocCollectionController {
    @Autowired
    DocCollectionService docCollectionService;
    @PostMapping("/api/admin/content/doc/collect")
    public Result collectdoc(@RequestBody DocCollection docCollection){
        docCollectionService.collectDoc(docCollection);
        return ResultFactory.buildSuccessResult("收藏成功！");
    }
    @PostMapping("/api/admin/content/collection/alldoc/{uid}")
    public Result listDocs(@RequestBody int uid){
        return ResultFactory.buildSuccessResult(docCollectionService.findAllByUid(uid));
    }

    @PostMapping("/api/admin/content/collection/delete/{uid}/{docid}")
    public Result deleteone(@PathVariable int uid,@PathVariable int docid){
        docCollectionService.delete(uid,docid);
        return ResultFactory.buildSuccessResult("已取消收藏！");
    }

}
