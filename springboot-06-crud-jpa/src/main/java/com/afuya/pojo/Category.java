package com.afuya.pojo;

import javax.persistence.*;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/17 4:29 下午
 */

@Entity
@Table(name = "category_")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
