package com.vttp2022.MiniProject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToDoList {
    private static final Logger logger = LoggerFactory.getLogger(ToDoList.class);

    private int id; 
    private String name;
    private boolean done;


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
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }


    
    

    



    
}
