package com.diamond.dao;

import com.diamond.entity.Doc;
import com.diamond.entity.UserDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    void deleteById(int id);
    @Transactional
    void deleteAllByDocid(int docid);
    @Transactional
    void deleteAllByUid(int uid);
    @Query(value = "select *from user_doc where uid=?1 and doc_read=true order by doc_open_time desc", nativeQuery = true)
    public List<UserDoc>findreadrecords(int uid );
    @Query(value = "select *from user_doc where uid=?1 and doc_edit=true order by doc_open_time desc", nativeQuery = true)
    public List<UserDoc>findeditrecords(int uid );
    @Query(value = "select *from user_doc where uid=?1 and doc_share=true order by doc_open_time desc", nativeQuery = true)
    public List<UserDoc>findsharerecords(int uid );
    @Query(value = "select *from user_doc where uid=?1 and doc_comment=true order by doc_open_time desc", nativeQuery = true)
    public List<UserDoc>findcommentrecords(int docid );

    @Query(value = "select count(distinct uid)  FROM user_doc where docid=?1 and doc_like=true", nativeQuery = true)
//    @Modifying
    public int findlikes(int docid);
    @Query(value = "select * FROM user_doc where uid=?1 and doc_like=true", nativeQuery = true)
//    @Modifying
    public List<UserDoc> userfindlikes(int uid);
}
