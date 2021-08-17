package pl.coderslab.charity.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")


public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String name;


    public CategoryEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

