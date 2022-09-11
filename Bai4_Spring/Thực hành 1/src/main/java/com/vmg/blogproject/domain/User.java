package com.vmg.blogproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Getter
@Setter
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotBlank(message = "Name is mandatory")
        private String name;

        @NotBlank(message = "Email is mandatory")
        private String email;

    }