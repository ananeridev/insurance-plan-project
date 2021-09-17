package com.anabneri.origintest.validations;

import com.anabneri.origintest.dto.UserRiskProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class PayloadFinalValidations {

    public UserRiskProfileDTO validateRiskProfileToPayloadFromDTO(UserRiskProfileDTO userRiskProfileDTO) {
        if (userRiskProfileDTO.age < 0) {
            System.out.println("AGE is less than 0 is not valid, is negative: " + userRiskProfileDTO.age); }

        if (userRiskProfileDTO.dependents < 0) {
            System.out.println("DEPENDENTS are less than 0 is not valid, is negative:" + userRiskProfileDTO.dependents); }

        if (userRiskProfileDTO.income < 0) {
            System.out.println("INCOME are less than 0 is not valid, is negative:" + userRiskProfileDTO.income); }

        if (userRiskProfileDTO.riskQuestions.length != 3) {
            System.out.println("RISK_QUESTIONS   are less than 0 is not valid, is negative:" + userRiskProfileDTO.income); }

        return userRiskProfileDTO;
    }

}
