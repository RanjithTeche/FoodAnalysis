package com.rzit.FoodAnalysis.controller;

import com.rzit.FoodAnalysis.model.Item;
import com.rzit.FoodAnalysis.service.FoodSatisfactionAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    /**
     * This method handles the requests where user uploads the file. After processing the file it returns max satisfaction found.
     *
     * @param multipartFile
     * @return a message which contains max satisfaction.
     */
    @RequestMapping(value = "/upload/foodStatistics")
    public String uploadFileHandler(@RequestParam("file") MultipartFile multipartFile) {
        try {
            File file = File.createTempFile("data", ".txt");
            multipartFile.transferTo(file);
            int maximumSatisfaction = foodSatisfactionAnalyseService.findMaximumSatisfaction(file);
            return "Maximum satisfaction found is : " + maximumSatisfaction;
        } catch (Exception e) {
            System.out.println("Exception occurred while calculating max satisfaction." + e.getMessage());
            e.printStackTrace();
            return "Something went wrong";
        }
    }
}
