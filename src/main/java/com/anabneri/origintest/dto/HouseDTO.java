package com.anabneri.origintest.dto;

import com.anabneri.origintest.domain.OwnershipStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class HouseDTO {

    @JsonProperty("ownership_status")
    public OwnershipStatus ownershipStatus;


}
