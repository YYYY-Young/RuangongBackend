package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminRoleMenu
 * @Description TODO
 * @Date 2020/8/10 20:30
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "admin_role_menu")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int rid;

    private int mid;
}
