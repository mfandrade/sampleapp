package mfandrade.sampleapp.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import mfandrade.sampleapp.controller.dto.ClientDTO;
import mfandrade.sampleapp.controller.dto.ClientFormDTO;
import mfandrade.sampleapp.controller.dto.ClientUpdateFormDTO;
import mfandrade.sampleapp.dao.ClientRepository;
import mfandrade.sampleapp.entity.Client;

@RestController
@RequestMapping("/v1/api/clients")
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping
  public List<ClientDTO> list() {
    List<Client> clients = clientRepository.findAll();
    return ClientDTO.convert(clients);
  }

  @Transactional
  @PostMapping
  public ClientDTO save(@RequestBody ClientFormDTO form) {
    Client client = form.convert();
    clientRepository.save(client);
    return new ClientDTO(client);
  }

  @Transactional
  @PutMapping("/{cod}")
  public ClientDTO update(@PathVariable Long cod, @RequestBody ClientUpdateFormDTO form) {
    final Optional<Client> registry = clientRepository.findById(cod);
    if (!registry.isPresent()) {
      throw new NoSuchElementException(String.format("Client #%s not found", cod));
    }
    Client client = registry.get();
    form.update(client);

    return new ClientDTO(client);
  }

  @Transactional
  @DeleteMapping("/{cod}")
  public void delete(@PathVariable Long cod) {
    final Optional<Client> registry = clientRepository.findById(cod);
    if (registry.isPresent()) {
      clientRepository.deleteById(cod);
    }
  }

}
