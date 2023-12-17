package br.org.com.compass.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.com.compass.model.Travel;


public interface TravelRepository extends JpaRepository<Travel, Long> {
	

}
