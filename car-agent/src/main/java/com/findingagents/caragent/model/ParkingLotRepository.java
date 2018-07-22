package com.findingagents.caragent.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface ParkingLotRepository extends MongoRepository<ParkingLotModel, String> {
}
