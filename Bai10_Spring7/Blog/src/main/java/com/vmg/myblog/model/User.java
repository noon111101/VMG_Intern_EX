package com.vmg.myblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Blog> blogs;


}
