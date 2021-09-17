package com.anabneri.origintest.dto;

import com.anabneri.origintest.domain.OwnershipStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseDTO {

    @JsonProperty("ownership_status")
    private OwnershipStatus ownershipStatus;

}
