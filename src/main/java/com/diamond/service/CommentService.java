package com.diamond.service;

import com.diamond.dao.CommentDAO;
import com.diamond.dao.DocDAO;
import com.diamond.entity.Comment;
import com.diamond.entity.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CommentService
 * @Description TODO
 * @Date 2020/8/12 1:21
 * @Created by lrf
 */
@Service
public class CommentService {
    @Autowired
    CommentDAO commentDao;
    @Autowired
    DocDAO docDAO;
    @Autowired
    UserTeamService userTeamService;

    public Comment findById(int id) {
        Comment comment= commentDao.findById(id);
        comment.setDoc(docDAO.findById(comment.getDocid()));
        return comment;
    }
    public List<Comment> getCommentbyuid(int uid){

          List<Comment> comments=commentDao.findAllByUidOrderByTimeDesc(uid);
          for(Comment comment:comments){
              comment.setDoc(docDAO.findById(comment.getDocid()));
          }
          return comments;
    }
    public List<Comment> getCommentbydocid(int docid){
        List<Comment> comments= commentDao.findAllByDocidOrderByTimeDesc(docid);
        for(Comment comment:comments){
            comment.setDoc(docDAO.findById(comment.getDocid()));
        }
        return comments;
    }
    public List<Comment> getallcommentsbyothers(int uid){
        List<Comment>comments=commentDao.findAll();
        List<Comment>re=new ArrayList<>();
        for(Comment comment:comments){
            comment.setDoc(docDAO.findById(comment.getDocid()));
            if(comment.getDoc().getDoc_founder()==uid){
                re.add(comment);
            }
        }
        return re;
    }

    public int addOrUpdate(Comment comment) {
        int uid = comment.getUid();
        Doc doc = docDAO.findById(comment.getDocid());
        int tid = doc.getDoc_team();
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        comment.setTime(ctime);
        if (doc.getDoc_founder() != uid && (!doc.isDoc_comment() || !userTeamService.isTeammember(uid, tid))) {
            return 0;
        }
        commentDao.save(comment);
        return 1;
    }
@Transactional
    public int delete(int uid, int id) {
        Comment comment = commentDao.findById(id);
        Doc doc = docDAO.findById(comment.getDocid());
        int tid = doc.getDoc_team();
        if (doc.getDoc_founder() != uid &&
                comment.getUid() != uid  ){
            return 0;
        }
        commentDao.deleteById(id);
        return 1;
    }

}
