package com.example.justeat;

import java.io.Serializable;

public class Paid implements Serializable {
    private int id;
    private int cost;
    private String time;

    public Paid() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Paid(int cost, String time) {
        super();
        this.cost = cost;
        this.time = time;

    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }




    @Override
    public String toString() {
        return "Paid [id=" + id + ", cost=" + cost + ", time="
                + time + "]";
    }

}

