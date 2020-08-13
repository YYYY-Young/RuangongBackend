package com.diamond.dao;

import com.diamond.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

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
    List<Doc> findAllByDoc_teamAndDoc_recycle(int tid,boolean r);
}
