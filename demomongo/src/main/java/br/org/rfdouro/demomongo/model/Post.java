package br.org.rfdouro.demomongo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document("post")
public class Post {
 @Id
 private String id;

 private String texto;

 @JsonIgnore
 @DBRef
 private List<Comentario> comentarios = new ArrayList<>();

 public List<Comentario> getComentarios() {
  return comentarios;
 }

 public void setComentarios(List<Comentario> comentarios) {
  this.comentarios = comentarios;
 }

 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getTexto() {
  return texto;
 }

 public void setTexto(String texto) {
  this.texto = texto;
 }

}
