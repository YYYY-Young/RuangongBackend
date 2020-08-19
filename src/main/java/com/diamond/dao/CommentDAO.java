package com.diamond.dao;

import com.diamond.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname CommentDao
 * @Description TODO
 * @Date 2020/8/12 1:17
 * @Created by lrf
 */
public interface CommentDAO extends JpaRepository<Comment,Integer> {
    List<Comment> findAllByDocidOrderByTimeDesc(int docid);
    List<Comment> findAllByUidOrderByTimeDesc(int uid);
    Comment findByUidAndDocid(int uid,int docid);
    void deleteByUidAndDocid(int uid,int docid);
    void deleteById(int id);
    Comment findById(int id);
    @Transactional
    @Modifying
    void deleteAllByDocid(int docid);
}
