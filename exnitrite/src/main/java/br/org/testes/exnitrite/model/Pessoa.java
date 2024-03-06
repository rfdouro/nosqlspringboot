package br.org.testes.exnitrite.model;

import org.dizitart.no2.collection.NitriteId;
import org.dizitart.no2.index.IndexType;
import org.dizitart.no2.repository.annotations.Entity;
import org.dizitart.no2.repository.annotations.Id;
import org.dizitart.no2.repository.annotations.Index;
import org.dizitart.no2.repository.annotations.Indices;

@Entity
@Indices({
  @Index(fields = "cpf", type = IndexType.UNIQUE)
})
public class Pessoa {

 @Id
 public NitriteId id;
 public String nome;
 public String cpf;

}
