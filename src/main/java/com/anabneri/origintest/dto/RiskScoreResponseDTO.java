package com.anabneri.origintest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RiskScoreResponseDTO {

    private String auto;

    private String disability;

    private String home;

    private String life;

}
