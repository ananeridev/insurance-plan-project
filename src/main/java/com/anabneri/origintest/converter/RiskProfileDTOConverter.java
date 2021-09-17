package com.anabneri.origintest.converter;

import com.anabneri.origintest.dto.UserRiskProfileDTO;
import com.anabneri.origintest.model.UserRiskProfile;

import java.util.Arrays;

public class RiskProfileDTOConverter {

    public UserRiskProfile convertToRiskProfile(UserRiskProfileDTO userRiskProfileDTO) {

        boolean hasVehicleValid = userRiskProfileDTO.vehicle != null;
        boolean hasHouseWithBinary = userRiskProfileDTO.house != null;

        Integer scoreFromBase = Arrays.stream(userRiskProfileDTO.riskQuestions).sum();

        return UserRiskProfile.builder()
            .age(userRiskProfileDTO.age)
            .income(userRiskProfileDTO.income)
            .house(userRiskProfileDTO.house)
            .dependents(userRiskProfileDTO.dependents)
            .maritalStatus(userRiskProfileDTO.maritalStatus)
            .vehicle(userRiskProfileDTO.vehicle)
            .vehicleBin((hasVehicleValid) ? 1 : 0)
            .houseBin((hasHouseWithBinary) ? 1: 0)
            .autoScore(scoreFromBase)
            .disabilityScore(scoreFromBase)
            .homeScore(scoreFromBase)
            .lifeScore(scoreFromBase)
            .build();

    }

}
