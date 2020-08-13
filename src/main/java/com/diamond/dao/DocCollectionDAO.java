package com.diamond.dao;

import com.diamond.entity.AdminUserRole;
import com.diamond.entity.DocCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocCollectionDAO extends JpaRepository<DocCollection, Integer> {
    void deleteAllByUid(int uid);
    void deleteAllByDocidAndUid(int docid,int uid);
    List<DocCollection> findAllByUid(int uid);
    DocCollection findByDocidAndUid(int docid,int uid);
}
