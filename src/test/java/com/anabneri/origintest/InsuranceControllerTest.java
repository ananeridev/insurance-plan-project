package com.anabneri.origintest;


import com.anabneri.origintest.domain.MaritalStatus;
import com.anabneri.origintest.domain.OwnershipStatus;
import com.anabneri.origintest.dto.HouseDTO;
import com.anabneri.origintest.dto.RiskScoreResponseDTO;
import com.anabneri.origintest.dto.UserRiskProfileDTO;
import com.anabneri.origintest.dto.VehicleYearDTO;
import com.anabneri.origintest.mappers.PayloadFinalMapper;
import com.anabneri.origintest.service.RiskScoreService;
import com.anabneri.origintest.web.InsurancePlanForUsersController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(InsurancePlanForUsersController.class)
public class InsuranceControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean RiskScoreService riskScoreService;

    @MockBean PayloadFinalMapper payloadFinalMapper;


    @Test
    public void shouldPostAPayloadFromUserAndReturnTheInsurancePlan() throws Exception {

        HouseDTO house = new HouseDTO();
        house.ownershipStatus = OwnershipStatus.MORTGAGED;

        int[] riskQuestions = new int[]{0,1,0};

        VehicleYearDTO vehicle = new VehicleYearDTO();
        vehicle.year = 2018;


        UserRiskProfileDTO userRiskProfileDTO = UserRiskProfileDTO.builder()
            .age(35)
            .dependents(2)
            .house(house)
            .income(0)
            .maritalStatus(MaritalStatus.MARRIED)
            .riskQuestions(riskQuestions)
            .vehicle(vehicle)
            .build();

        String inputJson =  objectMapper.writeValueAsString(userRiskProfileDTO);

        mockMvc.perform(post("/insurance-plan")
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
