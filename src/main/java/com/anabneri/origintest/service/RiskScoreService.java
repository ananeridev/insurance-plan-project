package com.anabneri.origintest.service;

import com.anabneri.origintest.converter.RiskProfileConverter;
import com.anabneri.origintest.converter.RiskProfileDTOConverter;
import com.anabneri.origintest.dto.UserRiskProfileDTO;
import com.anabneri.origintest.model.UserRiskProfile;
import com.anabneri.origintest.validations.AditionalTermsValidations;
import com.anabneri.origintest.validations.DeductTermsValidations;
import com.anabneri.origintest.validations.NoEligibilityTermsValidations;
import com.anabneri.origintest.validations.PayloadFinalValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskScoreService {

    @Autowired
    public PayloadFinalValidations payloadFinalValidations;

    @Autowired
    public NoEligibilityTermsValidations noEligibilityTermsValidations;

    @Autowired
    public DeductTermsValidations deductTermsValidations;

    @Autowired
    public AditionalTermsValidations aditionalTermsValidations;


    public UserRiskProfileDTO renderRequest(UserRiskProfileDTO userRiskPRofileDTO) {
      return payloadFinalValidations.validateRiskProfileToPayloadFromDTO(userRiskPRofileDTO);
    }

    private UserRiskProfileDTO userRiskPRofileDTO;
    UserRiskProfile hasConversionToRiskProfile = new RiskProfileDTOConverter().convertToRiskProfile(userRiskPRofileDTO);
    public RiskProfileConverter riskProfile = new RiskProfileDTOConverter().convertToRiskProfile(userRiskPRofileDTO) {
        payloadFinalValidations.validateRiskProfileToPayloadFromDTO(riskProfile);
        noEligibilityTermsValidations.validateUserRiskProfileNoEligibility(riskProfile);
        deductTermsValidations.validateUserRiskProfileDeduct(riskProfile);
        aditionalTermsValidations.validateUserRiskProfileAditional(riskProfile);
    }



}
