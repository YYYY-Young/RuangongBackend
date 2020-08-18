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
    private int id;
    private int docid;
    @Transient
    private Doc doc;
    private int uid;
    @Transient
    User user;

    private String des;
    private Timestamp time;
}
