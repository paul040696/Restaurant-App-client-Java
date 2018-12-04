package com.example.paul_.foodappv2.Model;

public class User {

    private String name;
    private String password;
    private String Phone;
    private String isstaff;

    public User(String name, String password ) {
        this.name = name;
        this.password = password;
        this.isstaff = "false";
    }

    public User()
  {

  }

    public String getIsstaff() {
        return isstaff;
    }

    public void setIsstaff(String isstaff) {
        this.isstaff = isstaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
