package com.cmu.firstclass.firstclass.entities;

/**
 * Created by jialiangtan on 4/11/15.
 */
public class IDNameDuple {
    String id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IDNameDuple(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
