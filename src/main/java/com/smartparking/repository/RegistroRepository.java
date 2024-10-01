package com.smartparking.repository;

import com.smartparking.entities.RegistroEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends MongoRepository<RegistroEntity, String> {
}
