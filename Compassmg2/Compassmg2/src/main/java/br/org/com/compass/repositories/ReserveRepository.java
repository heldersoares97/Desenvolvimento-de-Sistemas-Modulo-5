package br.org.com.compass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.compass.model.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

}
