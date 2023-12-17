package br.org.com.compass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.com.compass.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {


}
