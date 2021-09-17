package com.anabneri.origintest.service;

import com.anabneri.origintest.converter.RiskProfileConverter;
import com.anabneri.origintest.converter.RiskProfileDTOConverter;
import com.anabneri.origintest.dto.RiskScoreResponseDTO;
import com.anabneri.origintest.dto.UserRiskProfileDTO;
import com.anabneri.origintest.model.UserRiskProfile;
import com.anabneri.origintest.mappers.AditionalTermsMapper;
import com.anabneri.origintest.mappers.DeductTermsMapper;
import com.anabneri.origintest.mappers.NoEligibilityTermsMapper;
import com.anabneri.origintest.mappers.PayloadFinalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskScoreService {

    @Autowired
    public PayloadFinalMapper payloadFinalMapper;

    @Autowired
    public NoEligibilityTermsMapper noEligibilityTermsValidations;

    @Autowired
    public DeductTermsMapper deductTermsMapper;

    @Autowired
    public AditionalTermsMapper aditionalTermsMapper;

    @Autowired
    private RiskProfileDTOConverter riskProfileDTOConverter;

    @Autowired
    private RiskProfileConverter riskProfileConverter;


    public RiskScoreResponseDTO renderRequest(UserRiskProfileDTO userRiskPRofileDTO) {

       UserRiskProfile riskProfile = riskProfileDTOConverter.convertToRiskProfile(userRiskPRofileDTO);

        noEligibilityTermsValidations.userRiskProfileNoEligibility(riskProfile);
        deductTermsMapper.mapUserRiskProfileDeduct(riskProfile);
        aditionalTermsMapper.mapUserRiskProfileAditional(riskProfile);

       return riskProfileConverter.convert(riskProfile);

    }


}
