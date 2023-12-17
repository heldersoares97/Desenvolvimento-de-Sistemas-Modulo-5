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
import br.org.com.compass.model.Client;
import br.org.com.compass.services.CrudService;


//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClientController{

	@Autowired
	private CrudService cs;


	@GetMapping("/allclients")
	public List<Client> getAllClientes() {

		return cs.ListclientAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		Client client = cs.findById(id);
		return ResponseEntity.ok(client);
	}

	@PostMapping("/saveclient")
	public Client saveClient(@RequestBody Client client) {
		return cs.save(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
		Client client = cs.findById(id);
		if(client != null) {
			clientDetails.setName(client.getName());
			clientDetails.setCPF(client.getCPF());
			clientDetails.setJoinDate(client.getJoinDate());
			clientDetails.setNationality(client.getNationality());
			
			cs.save(clientDetails);
			return ResponseEntity.ok(client);
		}else {
			throw new RuntimeException("Erro");
		}
		
		
}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		cs.deleteById(id);
	}

}


