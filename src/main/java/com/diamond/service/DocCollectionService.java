package com.diamond.service;

import com.diamond.dao.DocCollectionDAO;
import com.diamond.entity.DocCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocCollectionService {
    @Autowired
    DocCollectionDAO docCollectionDAO;
    public List<DocCollection> findAllByUid(int uid){
        return docCollectionDAO.findAllByUid(uid);
    }
    public void delete(int docid,int uid){
        docCollectionDAO.deleteAllByDocidAndUid(docid,uid);
    }
    public void deleteAll(int uid){
        docCollectionDAO.findAllByUid(uid);
    }
    public void collectDoc(DocCollection docCollection){
        docCollectionDAO.save(docCollection);
    }

}
