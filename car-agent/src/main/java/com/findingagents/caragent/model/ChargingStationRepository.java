package com.findingagents.caragent.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface ChargingStationRepository extends MongoRepository<ChargingStationModel, String> {
}
