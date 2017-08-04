package com.rzit.FoodAnalysis.util;

import com.rzit.FoodAnalysis.model.Item;

/**
 * This utility class used to Food Satisfaction Analyser utils
 * Created by Ranjith on 8/3/2017.
 */
public class FoodSatisfactionAnalyser {
    /**
     * This method calculates the max satisfaction for given input.
     *
     * @param items
     * @param timeGiven
     * @param numberOfItems
     * @return max satisfaction
     */
    public static int maxSatisfaction(Item[] items, int timeGiven, int numberOfItems) {
        int i, j;
        int K[][] = new int[numberOfItems + 1][timeGiven + 1];
        for (i = 0; i <= numberOfItems; i++) {
            for (j = 0; j <= timeGiven; j++) {
                if (i == 0 || j == 0) {
                    K[i][j] = 0;
                } else if (items[i - 1].getTimeToEat() <= j) {
                    K[i][j] = Math.max(items[i - 1].getSatisfaction() + K[i - 1][j - items[i - 1].getTimeToEat()], K[i - 1][j]);
                } else {
                    K[i][j] = K[i - 1][j];
                }
            }
        }
        return K[numberOfItems][timeGiven];
    }
}
