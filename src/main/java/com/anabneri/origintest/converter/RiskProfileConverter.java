package com.anabneri.origintest.converter;

import com.anabneri.origintest.domain.InsurancePlan;
import com.anabneri.origintest.dto.RiskScoreDTO;
import com.anabneri.origintest.model.UserRiskProfile;
import org.springframework.stereotype.Component;

import javax.persistence.Converter;

@Component
public abstract class RiskProfileConverter  {

    public RiskScoreDTO convert (final UserRiskProfile userRiskProfile) {
        return RiskScoreDTO.builder()
            .auto(mappingScorePoints(userRiskProfile.autoScore))
            .disability(mappingScorePoints(userRiskProfile.disabilityScore))
            .home(mappingScorePoints(userRiskProfile.homeScore))
            .life(mappingScorePoints(userRiskProfile.lifeScore))
            .build();
    }

    private String mappingScorePoints(Integer score) {
        if (score == Integer.MIN_VALUE)
            return InsurancePlan.INELIGIBLE.name();
        if (score <= 0)
            return InsurancePlan.ECONOMIC.name();
        if (score == 1 || score == 2)
            return InsurancePlan.REGULAR.name();
        return InsurancePlan.RESPONSIBLE.name();
    }

}
