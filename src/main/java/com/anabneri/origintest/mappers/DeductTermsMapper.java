package com.anabneri.origintest.mappers;

import com.anabneri.origintest.model.UserRiskProfile;
import org.springframework.stereotype.Component;

@Component
public class DeductTermsMapper {

    public void mapUserRiskProfileDeduct(UserRiskProfile userRiskProfile) {
        // conditions should be here
        incomeMajorThanTwoHundredThousand(userRiskProfile);
        userUnderOfThirtyYearsOld(userRiskProfile);
        userWithAgeBetweenThirtyYearsOldAndFourtyYearsOld(userRiskProfile);

    }

    private void incomeMajorThanTwoHundredThousand(UserRiskProfile userRiskProfile) {
        if(userRiskProfile.income > 200000 ) {
            userRiskProfile.disabilityScore -= 1;
            userRiskProfile.homeScore -= 1;
            userRiskProfile.autoScore -= 1;
            userRiskProfile.lifeScore -= 1;
        }

    }

    private void userUnderOfThirtyYearsOld(UserRiskProfile userRiskProfile) {
        if (userRiskProfile.age < 30 ) {
            userRiskProfile.disabilityScore -= 2;
            userRiskProfile.homeScore -= 2;
            userRiskProfile.autoScore -= 2;
            userRiskProfile.lifeScore -= 2;
        }
    }

    private void userWithAgeBetweenThirtyYearsOldAndFourtyYearsOld(UserRiskProfile userRiskProfile) {
        if (userRiskProfile.age >=30 && userRiskProfile.age <= 40) {
            userRiskProfile.disabilityScore -= 1;
            userRiskProfile.homeScore -= 1;
            userRiskProfile.autoScore -= 1;
            userRiskProfile.lifeScore -= 1;
        }
    }



}
