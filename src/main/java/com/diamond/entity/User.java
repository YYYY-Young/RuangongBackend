package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/8/10 14:48
 * @Created by lrf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private boolean enabled;
    private String code;
    @Transient
    private List<AdminRole> roles;

}
