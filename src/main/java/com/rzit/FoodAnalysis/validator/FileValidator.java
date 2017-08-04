package com.rzit.FoodAnalysis.validator;

import com.rzit.FoodAnalysis.command.FoodStatisticsForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

/**
 * This validator class is used to validate the  FoodStatisticsForm
 * Created by Ranjith on 8/3/2017.
 */
@Component
public class FileValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return FoodStatisticsForm.class.isAssignableFrom(clazz);
    }

    /**
     * This method validate the FoodStatisticsForm
     * @param target is the FoodStatisticsForm
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        FoodStatisticsForm form = (FoodStatisticsForm) target;
        if (form == null || form.getFoodStatisticFile() == null || form.getFoodStatisticFile().isEmpty()) {
            errors.rejectValue("foodStatisticFile", "file.empty","Food Statistic File must not be empty");
        }
    }
}