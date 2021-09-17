package com.anabneri.origintest.mappers;

import com.anabneri.origintest.dto.UserRiskProfileDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PayloadFinalValidations {


    public List<String> validateRiskProfileToPayloadFromDTO(UserRiskProfileDTO userRiskProfileDTO) {
        List messagesList = new ArrayList<String>();

        if (userRiskProfileDTO.age < 0) {
            messagesList.add("Age must be positive");
        }

        if (userRiskProfileDTO.dependents < 0) {
            messagesList.add("Dependents must be positive");
        }

        if (userRiskProfileDTO.income < 0) {
            messagesList.add("Income must be positive");
        }

        if (userRiskProfileDTO.riskQuestions.length != 3) {
            messagesList.add("Risk_Questions  are less than 0 is not valid, is negative");

        }

        return messagesList;

    }

}
