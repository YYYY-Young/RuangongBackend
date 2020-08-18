package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Classname Doc
 * @Description TODO
 * @Date 2020/8/11 16:05
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "doc")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "id 不能为 null")
    private int id;

    @NotEmpty(message = "文章标题不能为空")
    private String doc_title;

    private String doc_content_html;

    private String doc_content_md;

    private String doc_abstract;

    private String doc_cover;

    private Timestamp doc_found_date;

    private int doc_founder;
    private int doc_team;
    private boolean doc_only_team;
    private boolean doc_read;
    private boolean doc_edit;
    private boolean doc_isedit;
    private boolean doc_comment;
    private boolean doc_delete;
    private boolean doc_share;
    private boolean doc_recycle;
    private int doc_last_edit_uid;
    private Timestamp doc_last_edit_time;

}
