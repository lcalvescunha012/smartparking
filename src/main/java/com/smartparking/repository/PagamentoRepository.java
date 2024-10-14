package com.smartparking.repository;

import com.smartparking.entities.PagamentosEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MongoRepository<PagamentosEntity, ObjectId> {}
