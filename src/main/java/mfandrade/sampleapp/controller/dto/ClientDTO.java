package mfandrade.sampleapp.controller.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import mfandrade.sampleapp.entity.Client;

@Getter
public class ClientDTO {

  private Long cod;
  private String name;
  private String cpf;
  private Integer age;

  public ClientDTO(Client client) {
    cod = client.getCod();
    name = client.getName();
    cpf = client.getCpf();
    age = client.getAge();
  }

  public static List<ClientDTO> convert(List<Client> clients) {
    List<ClientDTO> list = new ArrayList<ClientDTO>();
    for (Client client : clients) {
      list.add(new ClientDTO(client));
    }
    return list;
  }
}
