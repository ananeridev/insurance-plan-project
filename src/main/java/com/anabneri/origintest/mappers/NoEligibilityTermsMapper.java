package com.anabneri.origintest.mappers;

import com.anabneri.origintest.model.UserRiskProfile;
import org.springframework.stereotype.Component;

@Component
public class NoEligibilityTermsMapper {

    public void userRiskProfileNoEligibility(UserRiskProfile userRiskProfile) {
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
