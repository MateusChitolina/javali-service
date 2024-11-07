package com.javali.service;

import org.springframework.stereotype.Service;

import com.javali.infraestructure.entity.TesteEntity;
import com.javali.infraestructure.repository.TesteRepository;

@Service
public class TesteService {
  private final TesteRepository testeRepository;

  public TesteService(TesteRepository testeRepository) {
    this.testeRepository = testeRepository;
  }
  
  public Long testeSaveEntity() {
    TesteEntity testeEntity = new TesteEntity();
    testeEntity.setTeste("TEste 1");
    testeEntity = testeRepository.save(testeEntity);

    return testeEntity.getId();
  }
}
