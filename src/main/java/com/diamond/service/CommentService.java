package com.diamond.service;

import com.diamond.dao.CommentDAO;
import com.diamond.dao.DocDAO;
import com.diamond.entity.Comment;
import com.diamond.entity.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return commentDao.findById(id);
    }
    public List<Comment> getCommentbyuid(int uid){
        return commentDao.findAllByUidOrderByTimeDesc(uid);
    }
    public List<Comment> getCommentbydocid(int docid){
        return commentDao.findAllByDocidOrderByTimeDesc(docid);
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
