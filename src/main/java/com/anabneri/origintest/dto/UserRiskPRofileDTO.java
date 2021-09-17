package com.anabneri.origintest.dto;

import com.anabneri.origintest.domain.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

public class UserRiskPRofileDTO {

    private Integer age;

    private Integer dependents;

    private HouseDTO house;

    private Integer income;

    @JsonProperty("marital_status")
    private MaritalStatus maritalStatus;

    @JsonProperty("risk_questions")
    private int[] riskQuestions;

    private VehicleYearDTO vehicle;

}
