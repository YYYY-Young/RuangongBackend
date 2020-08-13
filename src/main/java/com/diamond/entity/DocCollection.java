package com.diamond.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doc_collection")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class DocCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private int uid;

    private int docid;
}
