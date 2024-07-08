package mfandrade.sampleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mfandrade.sampleapp.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
