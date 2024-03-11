package br.unisales.n4j.demo1.controllers;

import java.util.List;
import java.util.Optional;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ator")
@AllArgsConstructor
public class AtorController {
  private final AtorRepository atorRepository;
  private final FilmeRepository filmeRepository;

  @Operation(summary = "Lista de atores", description = "Retorna a lista de atores ordenada por nome", tags = {
      "Atores" }, responses = {
          @ApiResponse(responseCode = "200", description = "Get ok")
      }, method = "GET")
  @GetMapping
  public List<Ator> getAtores() {
    return atorRepository.findAll(Sort.by("nome"));
  }

  @Operation(summary = "Ator", description = "Retorna um ator - busca pelo seu ID", tags = { "Atores" }, responses = {
      @ApiResponse(responseCode = "200", description = "Get ok")
  }, method = "GET", parameters = {
      @Parameter(name = "id", example = "sas5a4s5-s4s54as-sa54sa", allowEmptyValue = false, in = ParameterIn.PATH)
  })
  @GetMapping("/{id}")
  public Ator getAtor(@PathVariable(name = "id", required = true) String id) {
    Optional<Ator> oAtor = atorRepository.findById(id);
    Ator ator = null;
    if (oAtor.isPresent())
      ator = oAtor.get();
    return ator;
  }

  @Operation(summary = "Lista de filmes", description = "Retorna a lista de filmes que um determinado ator atua. Recebe o id do ator", tags = {
    "Atores" }, responses = {
        @ApiResponse(responseCode = "200", description = "Get ok")
    }, method = "GET", parameters = {
      @Parameter(name = "id", example = "sas5a4s5-s4s54as-sa54sa", allowEmptyValue = false, in = ParameterIn.PATH)
  })
  @GetMapping("/atuacoes/{id}")
  public Set<Filme> getAtuacoes(@PathVariable(name = "id", required = true) String id) {
    Optional<Ator> oAtor = atorRepository.findById(id);
    if (oAtor.isPresent())
      return oAtor.get().getFilmes();
    return null;
  }

  @Operation(summary = "Insere ator", description = "Cadastra um ator e retorna seus dados", tags = {
    "Atores" }, responses = {
        @ApiResponse(responseCode = "200", description = "Inserção ok")
    }, method = "POST")
  @PostMapping
  public Ator saveAtor(@RequestBody Ator ator) {
    return atorRepository.save(ator);
  }

  @Operation(summary = "Vincula atuação", description = "Recebe um id de ator e um id de filme indicando a atuação do ator naquele determinado filme", tags = {
    "Atores" }, responses = {
        @ApiResponse(responseCode = "200", description = "Atuação ok")
    }, method = "POST")
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

  @Operation(summary = "Altera ator", description = "Altera dados de um ator e retorna seus dados", tags = {
    "Atores" }, responses = {
        @ApiResponse(responseCode = "200", description = "Alteração ok")
    }, method = "PUT")
  @PutMapping
  public Ator updAtor(@RequestBody Ator ator) {
    return atorRepository.save(ator);
  }

  @Operation(summary = "Deleta ator", description = "Exclui um ator da base. Recebe seu id para efetuar a exclusão", tags = {
    "Atores" }, responses = {
        @ApiResponse(responseCode = "200", description = "Exclusão ok")
    }, method = "DELETE")
  @DeleteMapping("/{id}")
  public Ator deleteAtor(@PathVariable(name = "id", required = true) String id) {
    Ator ator = atorRepository.findById(id).get();
    if (ator != null)
      atorRepository.delete(ator);
    return ator;
  }
}
