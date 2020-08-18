package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname UserTeam
 * @Description TODO
 * @Date 2020/8/11 13:51
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "user_team")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int uid;
    @Transient
    private User user;
    private int tid;
    @Transient
    private Team team;

    private boolean issys;
    private boolean isaccept;
}
