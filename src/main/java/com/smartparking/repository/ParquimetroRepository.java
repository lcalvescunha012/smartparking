package com.smartparking.repository;

import com.smartparking.entities.ParquimetroEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquimetroRepository extends MongoRepository<ParquimetroEntity, String> {}
