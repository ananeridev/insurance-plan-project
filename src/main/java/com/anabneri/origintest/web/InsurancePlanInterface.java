package com.anabneri.origintest.web;

import com.anabneri.origintest.dto.UserRiskProfileDTO;
import org.springframework.web.bind.annotation.RequestBody;

public class InsurancePlanInterface {

    @RequestBody(UserRiskProfileDTO userRiskProfileDTO)
    public void insurancePlan();

}
