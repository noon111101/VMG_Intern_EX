package com.vmg.tr.models.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category extends BasePOJO {
    @Column(length = 100)
    private String name;
    @Column(unique = true, length = 50)
    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;
}
