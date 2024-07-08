package mfandrade.sampleapp.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mfandrade.sampleapp.entities.Client;

@Getter
@AllArgsConstructor
public class ClientUpdateFormDTO {

  private String name;
  private Integer age;

  public void update(Client client) {
    client.setName(name);
    client.setAge(age);
  }
}
