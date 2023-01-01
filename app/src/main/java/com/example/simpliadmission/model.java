package com.example.simpliadmission;

public class model{
    String name, email, address, courses, type, website, fee, phone, estd;

    public model() {
    }

    public model(String name, String email, String fee, String address, String courses, String type, String website, String phone, String estd) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.courses = courses;
        this.type = type;
        this.website = website;
        this.fee = fee;
        this.phone = phone;
        this.estd = estd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
//
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEstd() {
        return estd;
    }

    public void setEstd(String estd) {
        this.estd = estd;
    }
}
