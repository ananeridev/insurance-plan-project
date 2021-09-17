package com.anabneri.origintest.model;

import com.anabneri.origintest.domain.MaritalStatus;
import com.anabneri.origintest.dto.HouseDTO;
import com.anabneri.origintest.dto.VehicleYearDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRiskProfile {

    public Integer age;

    public Integer dependents;

    // need a dto
    public HouseDTO house;

    public Integer income;

    public MaritalStatus maritalStatus;

    public Integer vehicleBin;

    // need a DTO for the year
    public VehicleYearDTO vehicle;

    public Integer houseBin;

    public Integer autoScore;

    public Integer disabilityScore;

    public Integer homeScore;

    public Integer lifeScore;


}
