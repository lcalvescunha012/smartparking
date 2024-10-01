package com.smartparking.repository;

import com.smartparking.entities.LocalizacaoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends MongoRepository<LocalizacaoEntity, String> {
}
