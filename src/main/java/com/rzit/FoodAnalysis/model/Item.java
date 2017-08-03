package com.rzit.FoodAnalysis.model;

/**
 * This class represents an item of the food in restaurant
 * <p>
 * Created by Ranjith on 8/3/2017.
 */
public class Item {
    private int satisfaction;
    private int timeToEat;

    /**
     * This constructor is used to initialize the Item properties
     *
     * @param satisfaction
     * @param timeToEat
     */
    public Item(int satisfaction, int timeToEat) {
        this.satisfaction = satisfaction;
        this.timeToEat = timeToEat;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getTimeToEat() {
        return timeToEat;
    }

    public void setTimeToEat(int timeToEat) {
        this.timeToEat = timeToEat;
    }
}
