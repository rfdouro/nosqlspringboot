package br.org.rfdouro.demomongo.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.org.rfdouro.demomongo.model.ItemTarefa;
import br.org.rfdouro.demomongo.repository.ItemTarefaRepositorio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/itemtarefa")
public class ItemTarefaControl {
 @Autowired
 ItemTarefaRepositorio repositorio;

 @GetMapping()
 public List<ItemTarefa> getTodas() {
  return repositorio.findAll();
 }

 @GetMapping("/add")
 public List<ItemTarefa> adiciona(@RequestParam(name = "nome") String nome) {
  ItemTarefa itemTarefa = new ItemTarefa(nome, 1, "GERAL");
  repositorio.save(itemTarefa);
  return repositorio.findAll();
 }

}
