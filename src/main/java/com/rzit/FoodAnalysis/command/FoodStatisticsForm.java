package com.rzit.FoodAnalysis.command;

import org.springframework.web.multipart.MultipartFile;

/**
 * This class hold the data to bind Food Statistics to analyse
 * Created by Ranjith on 8/3/2017.
 */
public class FoodStatisticsForm {
    private MultipartFile foodStatisticFile;

    /**
     * @return foodStatisticFile
     */
    public MultipartFile getFoodStatisticFile() {
        return foodStatisticFile;
    }

    /**
     * @param foodStatisticFile to set foodStatisticFile
     */
    public void setFoodStatisticFile(MultipartFile foodStatisticFile) {
        this.foodStatisticFile = foodStatisticFile;
    }
}
