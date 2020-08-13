package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

/**
 * @Classname AdminPermission
 * @Description TODO
 * @Date 2020/8/10 20:24
 * @Created by lrf
 */
@Data
@Entity
@Table(name = "admin_permission")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;

    private String desc_;

    private String url;
}
