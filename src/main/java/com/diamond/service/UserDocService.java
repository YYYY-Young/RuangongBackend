package com.diamond.service;

import com.diamond.dao.DocDAO;
import com.diamond.dao.UserDAO;
import com.diamond.dao.UserDocDAO;
import com.diamond.entity.Doc;
import com.diamond.entity.UserDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * @Classname UserDocService
 * @Description TODO
 * @Date 2020/8/12 11:27
 * @Created by lrf
 */
@Service
public class UserDocService {
    @Autowired
    UserDocDAO userDocDAO;
    @Autowired
    DocDAO docDAO;
    @Autowired
    UserDAO userDAO;
    public void AddRecord(UserDoc userDoc) {
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        userDoc.setDoc_open_time(ctime);
        userDocDAO.save(userDoc);
    }
    @Transactional
    public void deleteRecord(int id){
        userDocDAO.deleteById(id);
    }
    public List<UserDoc> findByRead(int uid){
        List<UserDoc> userDocs=userDocDAO.findreadrecords(uid);
        Iterator<UserDoc> iterator =userDocs.iterator();

        while(iterator.hasNext()){
            UserDoc userDoc=iterator.next();
            if(docDAO.findnotdeletedocs(userDoc.getDocid())==null){
                iterator.remove();
                continue;
            }
            userDoc.setDoc(docDAO.findById(userDoc.getDocid()));
        }
        return userDocs;
    }
    public List<UserDoc> findByDelete(int uid){
        List<UserDoc> userDocs=userDocDAO.finddeleterecords(uid);
        for (UserDoc userDoc : userDocs) {
            userDoc.setDoc(docDAO.findById(userDoc.getDocid()));
        }
        return userDocs;

    }
    public List<UserDoc> findByEdit(int uid){
        List<UserDoc> userDocs=userDocDAO.findeditrecords(uid);
        Iterator<UserDoc> iterator =userDocs.iterator();

        while(iterator.hasNext()){
            UserDoc userDoc=iterator.next();
            if(docDAO.findnotdeletedocs(userDoc.getDocid())==null){
                iterator.remove();
                continue;
            }
            userDoc.setDoc(docDAO.findById(userDoc.getDocid()));
        }
        return userDocs;
    }
    public List<UserDoc> findByShare(int uid){
        List<UserDoc> userDocs=userDocDAO.findsharerecords(uid);
        Iterator<UserDoc> iterator =userDocs.iterator();
        while(iterator.hasNext()){
            UserDoc userDoc=iterator.next();
            if(docDAO.findnotdeletedocs(userDoc.getDocid())==null){
                iterator.remove();
                continue;
            }
            userDoc.setDoc(docDAO.findById(userDoc.getDocid()));
        }
        return userDocs;
    }
    public int finddoclikes(int docid){
        return userDocDAO.findlikes(docid);
    }
    public List<UserDoc> finduserlikes(int uid){
        List<UserDoc> userDocs=userDocDAO.userfindlikes(uid);
        Iterator<UserDoc> iterator =userDocs.iterator();
        while(iterator.hasNext()){
            UserDoc userDoc=iterator.next();
            if(docDAO.findnotdeletedocs(userDoc.getDocid())==null){
                iterator.remove();
                continue;
            }
            userDoc.setDoc(docDAO.findById(userDoc.getDocid()));
        }
        return userDocs;
    }
    public UserDoc islike(int uid,int docid){
        return userDocDAO.islike(uid,docid);
    }
}
