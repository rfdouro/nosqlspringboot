package br.org.rfdouro.demo01n4j.controllers;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;

import br.org.rfdouro.demo01n4j.model.Professor;
import br.org.rfdouro.demo01n4j.repos.ProfessorRepository;
import br.org.rfdouro.demo01n4j.repos.ReactiveProfessorRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/neo/professor")
@AllArgsConstructor
public class ProfessorController {

  private final ReactiveProfessorRepository profRepo;
  private final ProfessorRepository n4jprofRepo;

  @GetMapping()
  Flux<Professor> getProfessores() {
    return profRepo.findFirst1000By();
  }

  @GetMapping(value = "/react", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  Flux<String> getProfessoresReact() {
    return Flux.interval(Duration.ofSeconds(5))
        .flatMap(x -> profRepo.findFirst1000By()
            .map(d -> "professor - " + d.getNome()));
  }

  @GetMapping(value = "/react/countprofs", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  Flux<Long> getContProfessoresReact() {
    return Flux.interval(Duration.ofSeconds(5))
        .flatMap(x -> profRepo.getTotalProfs()
            .map(d -> d.longValue()));
  }

  @GetMapping("/selPorId/{neoId}")
  Mono<Professor> getProfessor(@PathVariable(name = "neoId", required = true) String neoId) {
    return profRepo.findOneById(neoId);
  }

  @GetMapping("/add")
  Flux<Professor> addProfessor(String nome) {
    Professor p = new Professor(nome);
    n4jprofRepo.save(p);
    return profRepo.findFirst1000By();
  }

}
