package br.org.rfdouro.demomongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comentariopost")
public class Comentario {

 @Id
 private String id;

 private String texto;

 private Post post;

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

 public Post getPost() {
  return post;
 }

 public void setPost(Post post) {
  this.post = post;
 }

}
