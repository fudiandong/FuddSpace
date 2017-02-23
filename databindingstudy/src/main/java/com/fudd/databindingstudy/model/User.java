package com.fudd.databindingstudy.model;

/**
 * Created by fudd-office on 2017-2-23 15:22.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class User {
    private final String name;
    private final String nick;
    private int age;

    public User(String name, String nick) {
        this.name = name;
        this.nick = nick;
    }
    public User(String name,String nick,int age){
        this(name,nick);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult(){
        return age >= 18;
    }
}
