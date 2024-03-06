package br.org.testes.exnitrite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.testes.exnitrite.model.Pessoa;
import br.org.testes.exnitrite.services.PessoaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

 @Autowired
 PessoaService pessoaService;

 @GetMapping({ "", "/" })
 public List<Pessoa> get(@RequestParam(required = false) String cpf) {
  if (cpf == null)
   return pessoaService.getAll();
  else
   return pessoaService.getByCPF(cpf);
 }

 @PostMapping
 public List<Pessoa> add(@RequestBody Pessoa pessoa) {
  pessoaService.add(pessoa);
  return get(null);
 }

}
