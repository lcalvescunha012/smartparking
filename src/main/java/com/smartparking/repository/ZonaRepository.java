package com.smartparking.repository;

import com.smartparking.entities.ZonaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends MongoRepository<ZonaEntity, String> {
}
