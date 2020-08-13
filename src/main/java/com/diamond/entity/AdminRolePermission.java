package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminRolePermission
 * @Description TODO
 * @Date 2020/8/10 20:31
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "admin_role_permission")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int rid;

    private int pid;
}
