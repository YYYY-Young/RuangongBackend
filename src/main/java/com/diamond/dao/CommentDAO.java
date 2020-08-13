package com.diamond.dao;

import com.diamond.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname CommentDao
 * @Description TODO
 * @Date 2020/8/12 1:17
 * @Created by lrf
 */
public interface CommentDAO extends JpaRepository<Comment,Integer> {
    List<Comment> findAllByDocid(int docid);
    List<Comment> findAllByUid(int uid);
    Comment findByUidAndDocid(int uid,int docid);
    void deleteByUidAndDocid(int uid,int docid);
    void deleteById(int id);
    Comment findById(int id);
}
