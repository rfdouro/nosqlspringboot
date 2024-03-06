package br.org.testes.exnitrite.services;

import java.util.List;

import org.dizitart.no2.collection.FindOptions;
import org.dizitart.no2.common.SortOrder;
import org.dizitart.no2.filters.FluentFilter;
import org.dizitart.no2.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.org.testes.exnitrite.model.Pessoa;

@Service
public class PessoaService {

 @Autowired
 ObjectRepository<Pessoa> repositoryPessoas;

 public void add(Pessoa pessoa) {
  repositoryPessoas.insert(pessoa);
 }

 public List<Pessoa> getAll() {
  return repositoryPessoas.find(FindOptions.orderBy("nome", SortOrder.Ascending)).toList();
 }

 public List<Pessoa> getByCPF(@RequestParam String cpf) {
  return repositoryPessoas.find(FluentFilter.where("cpf").eq(cpf)).toList();
 }

}
