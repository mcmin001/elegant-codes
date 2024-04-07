package com.elegant.codes.model.user;


import com.elegant.codes.common.annotation.DDLColumn;
import com.elegant.codes.common.annotation.DDLTableName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
@DDLTableName(tableName = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 153978162555185435L;

    @Id
    @Column(name = "USER_ID", length = 32)
    @DDLColumn
    private String userId;

    @Column(name = "USER_NAME")
    @DDLColumn
    private String userName;
    @Column(name = "GENDER")
    @DDLColumn
    private String gender;
    @Column(name = "AGE")
    @DDLColumn
    private int age;

    @Column(name = "NATION")
    @DDLColumn
    private String nation;
    @Column(name = "BIRTHDAY")
    @DDLColumn
    private String birthday;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
