package com.peace.entity;

import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String value;

    public Member(String id, String value){
        this.setId(id);
        this.setValue(value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
