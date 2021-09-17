package com.anabneri.origintest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum InsurancePlan {

    INELIGIBLE("ineligible"),
    ECONOMIC("economic"),
    REGULAR("regular"),
    RESPONSIBLE("responsible");


    private final String insurancePlanString;

    private InsurancePlan(String insurancePlanString) {
        this.insurancePlanString = insurancePlanString;
    }

    @Override
    public String toString() {
        return insurancePlanString;
    }
}
