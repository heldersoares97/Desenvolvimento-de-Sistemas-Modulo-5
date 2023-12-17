package br.org.com.compass.servicesimpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.org.com.compass.model.Client;
import br.org.com.compass.repositories.ClientRepository;
import br.org.com.compass.services.CrudService;


@Service
public class GenericCrudImpl implements CrudService {
	
	@Autowired
	private ClientRepository cr;

		@Override
		public List<Client> ListclientAll() {
			// TODO Auto-generated method stub
			return cr.findAll();
		}

		@Override
		public Client findById(Long id) {
			// TODO Auto-generated method stub
			return cr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Não encontrado"));
		}

		@Override
		public Client save(Client client) {
			// TODO Auto-generated method stub
			return cr.save(client);
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			cr.deleteById(id);
			
		}

		@Override
		public Client updateById(Long id, Client clientupdate) {
			Client client=cr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Não encontrado"));
			client.setName(clientupdate.getName());
			client.setCPF(clientupdate.getCPF());
			client.setJoinDate(clientupdate.getJoinDate());
			client.setNationality(clientupdate.getNationality());
			return cr.save(client);
		}

}
