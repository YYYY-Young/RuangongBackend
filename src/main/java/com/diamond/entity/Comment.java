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
 * @Classname Comment
 * @Description TODO
 * @Date 2020/8/12 1:10
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "comment")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "id 不能为 null")
    private int id;
    @NotNull(message = "文档id不能为空")
    private int docid;
    @Transient
    private Doc doc;
    @NotNull(message = "评论者id不能为空")
    private int uid;
    @NotNull(message = "评价内容不能为空")
    private String des;
    @NotNull(message = "评价时间不能为空")
    private Timestamp time;
}
