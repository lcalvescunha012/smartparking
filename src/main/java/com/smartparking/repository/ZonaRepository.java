package com.smartparking.repository;

import com.smartparking.entities.ZonaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZonaRepository extends MongoRepository<ZonaEntity, String> {
}
