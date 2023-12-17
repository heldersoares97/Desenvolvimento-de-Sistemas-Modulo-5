package br.org.com.compass.services;
import java.util.List;
import br.org.com.compass.model.Travel;
import br.org.com.compass.services.TravelService;

public interface TravelService {

	
	List<Travel> ListTravelAll();
	
	Travel  findById(Long id);
	
	Travel save(Travel travel);
	
	void deleteById(Long id);
	
	Travel updateById(Long id, Travel travelupdate);

	
	
	
}
