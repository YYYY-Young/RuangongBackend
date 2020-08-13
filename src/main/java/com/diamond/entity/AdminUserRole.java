package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminUserRole
 * @Description TODO
 * @Date 2020/8/10 20:32
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "admin_user_role")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int uid;

    private int rid;
}
