package com.findingagents.caragent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStationModel {

    @Id private String id;
    private String plugType;
    private Double latitude;
    private Double longitude;
}
