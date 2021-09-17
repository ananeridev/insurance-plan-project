package com.anabneri.origintest.dto;

import com.anabneri.origintest.domain.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

public class UserRiskProfileDTO {

    public Integer age;

    public Integer dependents;

    public HouseDTO house;

    public Integer income;

    @JsonProperty("marital_status")
    public MaritalStatus maritalStatus;

    @JsonProperty("risk_questions")
    public int[] riskQuestions;

    public VehicleYearDTO vehicle;

}
