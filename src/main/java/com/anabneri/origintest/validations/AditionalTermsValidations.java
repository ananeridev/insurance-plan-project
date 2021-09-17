package com.anabneri.origintest.validations;

import com.anabneri.origintest.converter.RiskProfileConverter;
import com.anabneri.origintest.domain.MaritalStatus;
import com.anabneri.origintest.domain.OwnershipStatus;
import com.anabneri.origintest.model.UserRiskProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AditionalTermsValidations {

    @Autowired
    private UserRiskProfile userRiskProfile;

    public void validateUserRiskProfileAditional(RiskProfileConverter userRiskProfile) {
        // conditions should be here
        validateVehicleConditions(userRiskProfile);
        validateMaritalConditions(userRiskProfile);
        validateDependentsOfUSerConditions(userRiskProfile);
        validateHouseConditions(userRiskProfile);

    }

    private void validateVehicleConditions(UserRiskProfile userRiskProfile) {
        if(this.userRiskProfile.vehicle != null) {
            if(this.userRiskProfile.vehicle.year > LocalDate.now().getYear() - 5) {
                this.userRiskProfile.autoScore +=1;
            }
        }
    }

    private void validateMaritalConditions(UserRiskProfile userRiskProfile) {
        if(userRiskProfile.maritalStatus == MaritalStatus.MARRIED) {
            userRiskProfile.disabilityScore -= 1;
            userRiskProfile.lifeScore += 1;
        }
    }

    private void validateDependentsOfUSerConditions(UserRiskProfile userRiskProfile) {
        if(userRiskProfile.dependents > 0) {
            userRiskProfile.disabilityScore +=1;
            userRiskProfile.lifeScore += 1;
        }
    }

    private void validateHouseConditions(UserRiskProfile userRiskProfile) {
        if(userRiskProfile.house.ownershipStatus == OwnershipStatus.MORTGAGED) {
            userRiskProfile.disabilityScore += 1;
            userRiskProfile.homeScore +=1 ;
        }
    }
}
