package com.smartparking.repository;

import com.smartparking.entities.VeiculoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {
}