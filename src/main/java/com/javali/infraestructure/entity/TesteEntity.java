package com.javali.infraestructure.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "teste")
@SequenceGenerator(name = "teste_seq", sequenceName = "teste_seq", allocationSize = 1)
public class TesteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "teste_seq")
  private Long id;

  @Column(name = "teste")
  private String teste;

  @CreationTimestamp
  @Column(name = "criado_em")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "atualizado_em")
  private LocalDateTime updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTeste() {
    return teste;
  }

  public void setTeste(String teste) {
    this.teste = teste;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
  
}
