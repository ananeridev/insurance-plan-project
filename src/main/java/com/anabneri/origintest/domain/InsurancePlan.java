package com.anabneri.origintest.domain;

public enum InsurancePlan {

    INELIGIBLE,
    ECONOMIC,
    REGULAR,
    RESPONSIBLE;

    public static InsurancePlan fromValue(String value) {
        for (InsurancePlan insurancePlan : InsurancePlan.values()) {
            if (insurancePlan.toString().equals(value))
                return insurancePlan;
        }
        return null;
    }

}
