package mfandrade.sampleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mfandrade.sampleapp.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
