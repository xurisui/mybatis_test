package io.cxh.mybatis.po;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/4.
 */
public class User {
    private int id;
    private String sex;
    private String username;
    private Date birthday;
    private String address;
    private int englishScore;


    public User() {

    }

    public User(int id, String sex, String username,
                Date birthday, String address, int englishScore) {
        this.id = id;
        this.sex = sex;
        this.username = username;
        this.birthday = birthday;
        this.address = address;
        this.englishScore = englishScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }
}
