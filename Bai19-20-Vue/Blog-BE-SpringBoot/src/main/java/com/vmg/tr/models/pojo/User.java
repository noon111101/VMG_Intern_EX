package com.vmg.tr.models.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User extends BasePOJO {
    @Column(length = 20, unique = true, nullable = false)
    private String username;
    @Column(length = 130,nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String email;
    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }
}
