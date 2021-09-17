package com.anabneri.origintest.domain;

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
