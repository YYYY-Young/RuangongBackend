package com.diamond.dao;

import com.diamond.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Classname DocDAO
 * @Description TODO
 * @Date 2020/8/11 16:19
 * @Created by lrf
 */
public interface DocDAO extends JpaRepository<Doc,Integer> {
    Doc findById(int id);
    @Transactional
    void deleteById(int id);
    @Query(value = "select * from doc where id=?1 and doc_recycle=0 ",nativeQuery=true )
    Doc findnotdeletedocs(int id);
    @Query(value = "select * from doc where id=?1 and doc_recycle=1 ",nativeQuery=true )
    Doc findalreadydeletedocs(int id);
    @Query(value = "select * from doc where id=?1 and doc_isedit=0",nativeQuery = true)
    Doc findifedit(int id);
    @Query(value = "select * from doc where doc_only_team=1 and doc_team=?1 and doc_recycle=0 ",nativeQuery=true )
    List<Doc> teamdocs(int tid);
    @Modifying
    @Query(value = "update doc set doc_recycle =1 where id=?1",nativeQuery = true)
    int put_in_recycle_bin(int id);
    @Modifying
    @Query(value = "update doc set doc_recycle =0 where id=?1",nativeQuery = true)
    int take_out_recycle_bin(int id);
    @Query(value = "select * from doc where doc_founder=?1",nativeQuery = true)
    List<Doc> findfounderdocs(int uid);

    @Query(value  ="select * from doc where doc_recycle=0",nativeQuery = true)
    List<Doc> findalldocs();
}
