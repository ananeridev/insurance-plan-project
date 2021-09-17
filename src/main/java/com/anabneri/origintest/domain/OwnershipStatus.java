package com.anabneri.origintest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OwnershipStatus {

    @JsonProperty("owned")
    OWNED,

    @JsonProperty("mortgaged")
    MORTGAGED

}
