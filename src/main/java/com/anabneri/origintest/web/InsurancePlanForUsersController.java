package com.anabneri.origintest.web;

import com.anabneri.origintest.converter.RiskProfileDTOConverter;
import com.anabneri.origintest.dto.RiskScoreResponseDTO;
import com.anabneri.origintest.dto.UserRiskProfileDTO;
import com.anabneri.origintest.mappers.PayloadFinalValidations;
import com.anabneri.origintest.service.RiskScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsurancePlanForUsersController {

    @Autowired
    private RiskScoreService riskScoreService;

    @Autowired
    private PayloadFinalValidations payloadFinalValidations;


    @PostMapping("/insurance-plan")
    public Object postPayload(@RequestBody UserRiskProfileDTO userRiskProfileDTO) {
        List<String> erros = payloadFinalValidations.validateRiskProfileToPayloadFromDTO(userRiskProfileDTO);
        if (erros.size() > 0) {
            return erros;
        }

        RiskScoreResponseDTO renderRequest =  riskScoreService.renderRequest(userRiskProfileDTO);
        return renderRequest;

    }

}
