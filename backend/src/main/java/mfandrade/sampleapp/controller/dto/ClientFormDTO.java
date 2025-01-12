package mfandrade.sampleapp.controller.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mfandrade.sampleapp.entity.Client;

@Getter
@AllArgsConstructor
public class ClientFormDTO {

  private Long cod;
  private String name;
  private String cpf;
  private Integer age;
  private Instant createdAt;
  private Instant updatedAt;

  public Client toEntity() {
    Client client = new Client();
    client.setCod(cod);
    client.setName(name);
    client.setCpf(cpf);
    client.setAge(age);
    client.setCreatedAt(createdAt);
    client.setUpdatedAt(updatedAt);

    return client;
  }
}
