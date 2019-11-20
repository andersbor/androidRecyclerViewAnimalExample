package com.example.recyclerviewanimalexample;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String name;

    public Animal() {     } // required for de-serialization

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
