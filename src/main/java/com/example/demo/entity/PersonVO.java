package com.example.demo.entity;


import lombok.Data;
import lombok.ToString;

import java.util.List;


public class PersonVO {

    private Long pId;

    private String name;

    private Integer age;

    private String sex;

    private String des;

    private String birth;

    private String choice;

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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", des='" + des + '\'' +
                ", birth='" + birth + '\'' +
                ", choice='" + choice + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
