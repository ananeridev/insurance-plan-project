package com.anabneri.origintest.model;

import com.anabneri.origintest.domain.MaritalStatus;
import com.anabneri.origintest.dto.HouseDTO;
import com.anabneri.origintest.dto.VehicleYearDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class UserRiskProfile {

    public Integer age;

    public Integer dependents;

    public HouseDTO house;

    public Integer income;

    public MaritalStatus maritalStatus;

    public Integer vehicleBin;

    public VehicleYearDTO vehicle;

    public Integer houseBin;

    public Integer autoScore;

    public Integer disabilityScore;

    public Integer homeScore;

    public Integer lifeScore;


}
