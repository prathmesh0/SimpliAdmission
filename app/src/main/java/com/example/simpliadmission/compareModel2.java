package com.example.simpliadmission;

public class compareModel2 {
    String name, courses, type, fee, estd;

    public compareModel2(){

    }

    public compareModel2(String name, String courses, String type, String fee, String estd) {
        this.name = name;
        this.courses = courses;
        this.type = type;
        this.fee = fee;
        this.estd = estd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getEstd() {
        return estd;
    }

    public void setEstd(String estd) {
        this.estd = estd;
    }
}
