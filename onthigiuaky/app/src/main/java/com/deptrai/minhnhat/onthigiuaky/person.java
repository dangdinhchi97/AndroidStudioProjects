package com.deptrai.minhnhat.onthigiuaky;

public class person {
    private String name;
    private int age;
    private int images;
    private int ensign;

    public person(String name, int age, int images, int ensign) {
        this.name = name;
        this.age = age;
        this.images = images;
        this.ensign = ensign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getEnsign() {
        return ensign;
    }

    public void setEnsign(int ensign) {
        this.ensign = ensign;
    }
}