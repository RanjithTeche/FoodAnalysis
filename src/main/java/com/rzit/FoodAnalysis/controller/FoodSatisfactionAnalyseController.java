package com.rzit.FoodAnalysis.controller;

import com.rzit.FoodAnalysis.command.FoodStatisticsForm;
import com.rzit.FoodAnalysis.service.FoodSatisfactionAnalyseService;
import com.rzit.FoodAnalysis.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.util.stream.Collectors;

/**
 * This controller contains handler methods to upload file and find max satisfaction.
 * <p>
 * Created by Ranjith on 8/3/2017.
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class FoodSatisfactionAnalyseController {
    @Autowired
    FoodSatisfactionAnalyseService foodSatisfactionAnalyseService;
    @Autowired
    FileValidator fileValidator;

    /**
     * This method is used to bind the validator to webDataBinder
     *
     * @param webDataBinder
     */
    @InitBinder("foodStatisticsForm")
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(fileValidator);
    }

    /**
     * This method handles the requests where user uploads the food analytics data.
     * After processing the data it returns max satisfaction found.
     *
     * @param foodStatisticsForm the {@code FoodStatisticsForm} instance to hold the foodStatisticFile
     * @return a message which contains max satisfaction.
     */
    @RequestMapping(value = "/upload/foodStatistics")
    public String uploadFileHandler(@Valid FoodStatisticsForm foodStatisticsForm, Errors errors) {
        if (errors.hasErrors()) {
            // get all errors
            return errors.getAllErrors()
                    .stream()
                    .map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(","));
        }
        try {
            File file = File.createTempFile("data", ".txt");
            foodStatisticsForm.getFoodStatisticFile().transferTo(file);
            int maximumSatisfaction = foodSatisfactionAnalyseService.findMaximumSatisfaction(file);
            return "Maximum satisfaction found is : " + maximumSatisfaction;
        } catch (Exception e) {
            System.out.println("Exception occurred while calculating max satisfaction." + e.getMessage());
            e.printStackTrace();
            return "Something went wrong";
        }
    }
}
