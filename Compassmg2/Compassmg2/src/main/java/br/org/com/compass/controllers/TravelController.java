package br.org.com.compass.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.com.compass.model.Travel;
import br.org.com.compass.services.TravelService;



//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiTravel")
public class TravelController{
	
@Autowired
private TravelService tr;


@GetMapping("/alltravel")
public List<Travel> getAllTravels() {

	return tr.ListTravelAll();
}

@GetMapping("/{id}")
public ResponseEntity<Travel> getClientById(@PathVariable Long id) {
	Travel travel = tr.findById(id);
	return ResponseEntity.ok(travel);
}

@PostMapping("/savetravel")
public Travel saveTravel(@RequestBody Travel travel) {
	return tr.save(travel);
}

@PutMapping("/travel/{id}")
public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody Travel travelDetails) {
	Travel travel = tr.findById(id);
	if(travel != null) {
		travel.set_id(travelDetails.get_id());
		travel.setName(travelDetails.getName());
		travel.setDestiny(travelDetails.getDestiny());
		
		tr.save(travel);
		return ResponseEntity.ok(travel);
	}else {
		throw new RuntimeException("Erro");
	}
}
	@DeleteMapping("/{id}")
	public void deleteTravel(@PathVariable Long id) {
		tr.deleteById(id);
	}	
	
}






