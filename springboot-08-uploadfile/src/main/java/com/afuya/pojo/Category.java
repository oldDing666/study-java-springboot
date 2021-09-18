package com.afuya.pojo;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/18 4:22 下午
 */
public class Category {
    private int id;
    private String name;
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

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
