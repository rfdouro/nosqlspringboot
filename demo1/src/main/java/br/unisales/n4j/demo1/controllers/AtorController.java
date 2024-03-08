package br.unisales.n4j.demo1.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisales.n4j.demo1.model.Ator;
import br.unisales.n4j.demo1.model.Filme;
import br.unisales.n4j.demo1.persistence.AtorRepository;
import br.unisales.n4j.demo1.persistence.FilmeRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ator")
@AllArgsConstructor
public class AtorController {
 private final AtorRepository atorRepository;
 private final FilmeRepository filmeRepository;

 @GetMapping
 public List<Ator> getAtores() {
  return atorRepository.findAll(Sort.by("nome"));
 }

 @GetMapping("/{id}")
 public Ator getAtor(@PathVariable(name = "id", required = true) String id) {
  Ator ator = atorRepository.findById(id).get();
  return ator;
 }

 @GetMapping("/atuacoes/{id}")
 public Set<Filme> getAtuacoes(@PathVariable(name = "id", required = true) String id) {
  Ator ator = atorRepository.findById(id).get();
  if (ator != null)
   return ator.getFilmes();
  return null;
 }

 @PostMapping
 public Ator saveAtor(@RequestBody Ator ator) {
  return atorRepository.save(ator);
 }

 @PostMapping("/{id}/atuaem/{idFilme}")
 public Ator atuaem(@PathVariable(name = "id", required = true) String id,
   @PathVariable(name = "idFilme", required = true) String idFilme) {
  Ator ator = atorRepository.findById(id).get();
  Filme filme = filmeRepository.findById(idFilme).get();
  if (ator != null && filme != null) {
   ator.getFilmes().add(filme);
  }
  return atorRepository.save(ator);
 }

 @PutMapping
 public Ator updAtor(@RequestBody Ator ator) {
  return atorRepository.save(ator);
 }

 @DeleteMapping("/{id}")
 public Ator deleteAtor(@PathVariable(name = "id", required = true) String id) {
  Ator ator = atorRepository.findById(id).get();
  if (ator != null)
   atorRepository.delete(ator);
  return ator;
 }
}
