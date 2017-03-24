package com.lfq.zzuli.getphonenumber.entity;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

//此类就是一个JavaBean，用于保存（封装）用户数据，这里指的是联系人的姓名和手机号码

public class PhoneInfo {
    private String name;  //联系人姓名
    private String number;  //联系人手机号码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public PhoneInfo(){

    }
}
