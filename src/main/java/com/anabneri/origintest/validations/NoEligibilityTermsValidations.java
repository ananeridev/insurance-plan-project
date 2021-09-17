package com.anabneri.origintest.validations;

import com.anabneri.origintest.converter.RiskProfileConverter;
import com.anabneri.origintest.model.UserRiskProfile;
import org.springframework.stereotype.Component;

@Component
public class NoEligibilityTermsValidations {

    public void validateUserRiskProfileNoEligibility(RiskProfileConverter userRiskProfile) {
        if (userRiskProfile.income == 0) {
            userRiskProfile.disabilityScore = Integer.MIN_VALUE;

            if (userRiskProfile.houseBin == 0) {
                userRiskProfile.homeScore = Integer.MIN_VALUE;

                if (userRiskProfile.vehicleBin == 0) {
                    userRiskProfile.autoScore = Integer.MIN_VALUE;

                    if (userRiskProfile.age > 60) {
                        userRiskProfile.disabilityScore = Integer.MIN_VALUE;
                        userRiskProfile.lifeScore = Integer.MIN_VALUE;
                    }
                }
            }
        }
    }


}
