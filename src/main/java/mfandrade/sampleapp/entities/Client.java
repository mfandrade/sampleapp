package mfandrade.sampleapp.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cod;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false, unique = true)
  private String cpf;
  private Integer age;
  @Temporal(TemporalType.TIMESTAMP)
  private Instant createdAt;
  @Temporal(TemporalType.TIMESTAMP)
  private Instant updatedAt;
}
