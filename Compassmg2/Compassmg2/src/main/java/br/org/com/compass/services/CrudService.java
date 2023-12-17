package br.org.com.compass.services;
import java.util.List;
import br.org.com.compass.model.Client;


public interface CrudService {
	
		List<Client> ListclientAll();
		
		Client  findById(Long id);
		
		Client save(Client client);
		
		void deleteById(Long id);
		
		Client updateById(Long id, Client clientupdate);

	
		
		
}
