package com.classroommission.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroommission.service.TesteService;

@RestController
@RequestMapping("/test")
public class TesteRest {
  private final TesteService testeService;

  public TesteRest(TesteService testeService) {
    this.testeService = testeService;
  }

  @PostMapping
  public ResponseEntity<Void> saveBook() {
    testeService.testeSaveEntity();
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}
