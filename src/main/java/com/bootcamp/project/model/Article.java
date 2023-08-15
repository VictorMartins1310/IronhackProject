package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Article")
@Table(name = "Article") //To Define table Name in DB
@Data
public class Article {
    @Id
    private Long articleID;
    private String name;
    private String brand;
    private ArticleType type;
}
