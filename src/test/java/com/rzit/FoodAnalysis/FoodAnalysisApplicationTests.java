package com.rzit.FoodAnalysis;

import com.rzit.FoodAnalysis.model.Item;
import com.rzit.FoodAnalysis.service.FoodSatisfactionAnalyseService;
import com.rzit.FoodAnalysis.util.FoodSatisfactionAnalyser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This test class used to test the Food Analysis Application
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodAnalysisApplicationTests {

    @Autowired
    FoodSatisfactionAnalyseService foodSatisfactionAnalyseService;

    @Test
    public void contextLoads() {
    }

    @Test(expected = NullPointerException.class)
    public void testFindMaximumSatisfactionWithoutInput() throws FileNotFoundException {
        foodSatisfactionAnalyseService.findMaximumSatisfaction(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testFindMaximumSatisfactionInvalidInput() throws FileNotFoundException {
        foodSatisfactionAnalyseService.findMaximumSatisfaction(new File(""));
    }

    @Test
    public void testFindMaximumSatisfactionValidInput() throws IOException {
        File file = new ClassPathResource("data.txt").getFile();
        int maxSatisfaction = foodSatisfactionAnalyseService.findMaximumSatisfaction(file);
        assert maxSatisfaction == 2493893;
    }

    @Test
    public void testmaxSatisfaction() {
        int timeGiven = 1;
        int numberOfItems = 1;
        Item[] items = {new Item(5, 1)};
        int maxSatisfaction = FoodSatisfactionAnalyser.maxSatisfaction(items, timeGiven, numberOfItems);
        assert maxSatisfaction == 5;
    }


}
