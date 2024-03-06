package br.org.rfdouro.demomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tarefasitem")
public class ItemTarefa {

 @Id
 private String id;

 private String nome;
 private int repeticoes;
 private String categoria;

 public ItemTarefa(String nome, int repeticoes, String categoria) {
  super();
  this.nome = nome;
  this.repeticoes = repeticoes;
  this.categoria = categoria;
 }

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public int getRepeticoes() {
  return repeticoes;
 }

 public void setRepeticoes(int repeticoes) {
  this.repeticoes = repeticoes;
 }

 public String getCategoria() {
  return categoria;
 }

 public void setCategoria(String categoria) {
  this.categoria = categoria;
 }
}
