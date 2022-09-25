package com.vmg.myblog.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique=true)
    @NotNull
    @Size(min = 6, max = 20)
    private String username;
    @NotNull
    private String password;

    @NotNull
    private String fullname;

    @ManyToMany
    private Set<Role> roles;

    @OneToMany(mappedBy = "author")
    private List<Blog> blogs;


}
