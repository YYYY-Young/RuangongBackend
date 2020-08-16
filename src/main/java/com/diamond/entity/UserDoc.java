package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Classname UserDoc
 * @Description TODO
 * @Date 2020/8/12 11:19
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "user_doc")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int uid;

    private int docid;
    @Transient
    private Doc doc;

    private boolean doc_read;

    private boolean doc_edit;

    private boolean doc_delete;

    private boolean doc_comment;

    private int commentid;
    @Transient
    Comment comment;

    private boolean doc_share;

    private int doc_share_uid;
    @Transient
    private User doc_share_user;

    private boolean doc_like;

    private String doc_open_des;

    private Timestamp doc_open_time;
}
