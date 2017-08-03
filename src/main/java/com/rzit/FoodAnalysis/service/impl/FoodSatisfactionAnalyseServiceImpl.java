package com.rzit.FoodAnalysis.service.impl;

import com.rzit.FoodAnalysis.model.Item;
import com.rzit.FoodAnalysis.service.FoodSatisfactionAnalyseService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.rzit.FoodAnalysis.util.FoodSatisfactionAnalyser.maxSatisfaction;

/**
 * This class implements FoodSatisfactionAnalyseService API.
 * <p>
 * Created by Ranjith on 8/3/2017.
 */
@Service
public class FoodSatisfactionAnalyseServiceImpl implements FoodSatisfactionAnalyseService {
    /**
     * This method finds the maximum satisfaction for the given file(which contains the items).
     *
     * @param file
     * @return maximum satisfaction
     */
    @Override
    public int findMaximumSatisfaction(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int timeGiven = sc.nextInt();
        int numberOfItems = sc.nextInt();
        Item[] items = new Item[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = new Item(sc.nextInt(), sc.nextInt());
        }
        return maxSatisfaction(items, timeGiven, numberOfItems);
    }


}
