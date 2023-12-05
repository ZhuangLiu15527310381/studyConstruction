package com.example.demo.entity;

import lombok.*;

import java.util.Date;
import java.util.List;


public class PersionDTO {

    private Long pId;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private Float height;

    private Float weight;

    private Date birthDay;

    private String birthLocation;

    private Boolean married;

    private Boolean hasParents;

    private Boolean hasChildren;

    private String describe;

    private List<String> hobby;

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Boolean getHasParents() {
        return hasParents;
    }

    public void setHasParents(Boolean hasParents) {
        this.hasParents = hasParents;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "PersionDTO{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthDay=" + birthDay +
                ", birthLocation='" + birthLocation + '\'' +
                ", married=" + married +
                ", hasParents=" + hasParents +
                ", hasChildren=" + hasChildren +
                ", describe='" + describe + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
