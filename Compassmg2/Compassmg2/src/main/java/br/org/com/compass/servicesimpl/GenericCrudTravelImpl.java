package br.org.com.compass.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.com.compass.model.Travel;
import br.org.com.compass.repositories.TravelRepository;
import br.org.com.compass.services.TravelService;


@Service
public class GenericCrudTravelImpl implements TravelService {

	
	@Autowired
	private TravelRepository cr;

		@Override
		public List<Travel> ListTravelAll() {
			// TODO Auto-generated method stub
			return cr.findAll();
		}

		@Override
		public Travel findById(Long id) {
			// TODO Auto-generated method stub
			return cr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Não encontrado"));
		}

		@Override
		public Travel save(Travel travel) {
			// TODO Auto-generated method stub
			return cr.save(travel);
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			cr.deleteById(id);
			
		}

		@Override
		public Travel updateById(Long id, Travel travelupdate) {
			Travel travel=cr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Não encontrado"));
			travel.setName(travelupdate.getName());
			travel.setDestiny(travelupdate.getDestiny());
			return cr.save(travel);
		}

}
