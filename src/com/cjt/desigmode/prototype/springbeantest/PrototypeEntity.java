package com.cjt.desigmode.prototype.springbeantest;

/**
 * 原型模式中的
 */
public class PrototypeEntity {

    private String id;
    private int seconds;
    private PrototypeEntity friend;

    @Override
    public String toString() {
        return "PrototypeEntity{" +
                "id='" + id + '\'' +
                ", seconds=" + seconds +
                ", friend=" + friend +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public PrototypeEntity getFriend() {
        return friend;
    }

    public void setFriend(PrototypeEntity friend) {
        this.friend = friend;
    }
}
