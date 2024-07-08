package mfandrade.sampleapp.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.transaction.Transactional;
import mfandrade.sampleapp.entities.Client;
import mfandrade.sampleapp.repositories.ClientRepository;

@Controller
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  @ResponseBody
  @RequestMapping("/clients")
  public List<Client> list() {
    List<Client> clients = clientRepository.findAll();
    return clients;
  }

  @ResponseBody
  @Transactional
  @RequestMapping(path = "/clients", method = RequestMethod.POST)
  public void save(@RequestBody Client data) {
    data.setCreatedAt(Instant.now());
    data.setUpdatedAt(Instant.now());
    clientRepository.save(data);
  }

  @ResponseBody
  @Transactional
  @RequestMapping(path = "/clients", method = RequestMethod.PUT)
  public void update(@RequestBody Client data) {
    data.setUpdatedAt(Instant.now());
    clientRepository.save(data);
  }

  @ResponseBody
  @Transactional
  @RequestMapping(path = "/clients/{cod}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long cod) {
    clientRepository.deleteById(cod);
  }

}
