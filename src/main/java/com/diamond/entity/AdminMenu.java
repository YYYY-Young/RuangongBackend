package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

/**
 * @Classname AdminMenu
 * @Description TODO
 * @Date 2020/8/10 20:15
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "admin_menu")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String path;

    private String name;

    private String nameZh;

    private String iconCls;

    private String component;

    private int parentId;

    @Transient
    private List<AdminMenu> children;
}
