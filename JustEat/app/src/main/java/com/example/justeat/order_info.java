package com.example.justeat;

public class order_info {
    String id;
    String cost;
    String time;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return id + ", " + cost + ", " + time;
    }
    public order_info(String id,String cost, String time) {
        super();
        this.id = id;
        this.cost = cost;
        this.time = time;
    }
}

