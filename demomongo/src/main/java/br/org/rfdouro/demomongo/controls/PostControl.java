package br.org.rfdouro.demomongo.controls;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.rfdouro.demomongo.model.Comentario;
import br.org.rfdouro.demomongo.model.Post;
import br.org.rfdouro.demomongo.repository.ComentarioRepository;
import br.org.rfdouro.demomongo.repository.PostRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/post")
public class PostControl {

 private PostRepository postRepository;
 private ComentarioRepository comentarioRepository;

 public PostControl(PostRepository postRepository, ComentarioRepository comentarioRepository) {
  this.postRepository = postRepository;
  this.comentarioRepository = comentarioRepository;
 }

 @GetMapping("")
 public List<Post> getAll() {
  return postRepository.findAll();
 }

 @GetMapping("/add")
 public List<Post> addPost(@RequestParam String texto) {
  Post post = new Post();
  post.setTexto(texto);
  postRepository.save(post);
  return postRepository.findAll();
 }

 @GetMapping("/comentarios/{idpost}")
 public List<Comentario> getComentarios(@PathVariable(name = "idpost", required = true) String idpost) {
  Post post = postRepository.findById(idpost).get();
  if (post != null) {
   return post.getComentarios();
  }
  return null;
 }

 @GetMapping("/comentarios")
 public List<Comentario> getAllComentarios() {
  return comentarioRepository.findAll();
 }

 // 65b56ef7ada8e435044114c1

 @GetMapping("/comentarios/{idpost}/add")
 public List<Comentario> addcomentario(@PathVariable(name = "idpost", required = true) String idpost,
   @RequestParam String texto) {
  Post post = postRepository.findById(idpost).get();
  if (post != null) {
   Comentario comentario = new Comentario();
   comentario.setPost(post);
   comentario.setTexto(texto);
   comentarioRepository.save(comentario);

   post.getComentarios().add(comentario);
   postRepository.save(post);

   return post.getComentarios();
  }
  return null;
 }

}
