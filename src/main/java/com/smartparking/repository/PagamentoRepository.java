package com.smartparking.repository;

import com.smartparking.entities.PagamentosEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MongoRepository<PagamentosEntity, String> {}
