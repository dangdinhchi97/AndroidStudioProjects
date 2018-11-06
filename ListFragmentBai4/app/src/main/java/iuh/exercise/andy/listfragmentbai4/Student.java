package iuh.exercise.andy.listfragmentbai4;

import java.io.Serializable;

public class Student implements Serializable {
    private String name, address, email;
    private int year;

    public Student(String name, String address, String email, int year) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
