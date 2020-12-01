package com.rarestzhou.leetcode_solutions.java;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2020/10/19 13:38
 * @description:
 */
public class User {

    private String name;

    private Integer age;

    private String addr;

    private String sex_gender;

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getsex_gender() {
        return sex_gender;
    }

    public void setsex_gender(String sex_gender) {
        this.sex_gender = sex_gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", sex_gender=" + sex_gender +
                '}';
    }
}
