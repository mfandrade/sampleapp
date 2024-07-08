package mfandrade.sampleapp.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import mfandrade.sampleapp.entities.Client;
import mfandrade.sampleapp.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  public List<Client> list() {
    List<Client> clients = clientRepository.findAll();
    return clients;
  }

  @Transactional
  @PostMapping
  public void save(@RequestBody Client data) {
    Instant now = Instant.now();
    data.setCreatedAt(now);
    data.setUpdatedAt(now);
    clientRepository.save(data);
  }

  @Transactional
  @PutMapping
  public void update(@RequestBody Client data) {
    data.setUpdatedAt(Instant.now());
    clientRepository.save(data);
  }

  @Transactional
  @DeleteMapping("/{cod}")
  public void delete(@PathVariable Long cod) {
    clientRepository.deleteById(cod);
  }

}
