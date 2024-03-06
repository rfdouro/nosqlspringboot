package br.unisales.n4j.demo1.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisales.n4j.demo1.model.Filme;
import br.unisales.n4j.demo1.persistence.FilmeRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/filme")
@AllArgsConstructor
public class FilmeController {

 private final FilmeRepository filmeRepository;

 @GetMapping
 public List<Filme> getFilmes() {
  return filmeRepository.findFilmes();
 }

 @PostMapping
 public Filme saveFilme(@RequestBody Filme filme) {
  return filmeRepository.save(filme);
 }
}
