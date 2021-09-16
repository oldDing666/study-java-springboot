package com.afuya.pojo;

import javax.persistence.*;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/16 10:42 上午
 */

/**
 * @Entity 表示这是一个实体类
 * @Table(name = "category_") 表示这个类对应的表名是category_
 */
@Entity
@Table(name = "category_")
public class Category {

    /**
     * @Id 表示主键
     * @GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增
     * @Column(name = "id") 表示对应的字段
     */
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
