package com.diamond.dao;

import com.diamond.entity.Doc;
import com.diamond.entity.UserDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname UserDocDAO
 * @Description TODO
 * @Date 2020/8/12 11:23
 * @Created by lrf
 */
public interface UserDocDAO extends JpaRepository<UserDoc,Integer> {
    List<UserDoc> findAllByUid(int uid);
    List<UserDoc> findAllByDocid(int docid);
    UserDoc findByUidAndDocid(int uid,int docid);
    UserDoc findById(int id);
    @Transactional
    void deleteAllByDocid(int docid);
    @Transactional
    void deleteAllByUid(int id);
}
