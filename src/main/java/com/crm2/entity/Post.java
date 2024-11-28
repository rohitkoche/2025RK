package com.crm2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false ,length = 100)
    private String name;

    @Column(name = "description", nullable = false ,length = 5000)
    private String description;;

//to delete a parent class (post Entity class)/ reference varaible name "post" i.e present inside comment entity
    //CascadeType:explanation -> imagine  i have post and comment entity let assume that for a particular
                                //there is comment one to many mapping between them if i delete a post
    //cascade =cascadeType.all method use to delete /update from parent entity to child entity
@OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments;
}