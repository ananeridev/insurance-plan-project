package com.anabneri.origintest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MaritalStatus {

    @JsonProperty("single")
    SINGLE,

    @JsonProperty("married")
    MARRIED

}
