package com.rzit.FoodAnalysis.service;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This service provides the API to find maximum satisfaction for given file(which contains items).
 * Created by Ranjith on 8/3/2017.
 */
public interface FoodSatisfactionAnalyseService {
    /**
     * This method finds the maximum satisfaction for the given file(which contains the items).
     *
     * @param file
     * @return maximum satisfaction
     */
    int findMaximumSatisfaction(File file ) throws FileNotFoundException;
}
