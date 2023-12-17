package br.org.com.compass.servicesimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.com.compass.model.Reserve;
import br.org.com.compass.repositories.ReserveRepository;
import br.org.com.compass.services.ReserveService;


@Service
public class GenericCrudReserveImpl implements ReserveService {
	
		
	@Autowired
	private ReserveRepository rr;

		@Override
		public List<Reserve> ListreserveAll() {
			// TODO Auto-generated method stub
			return rr.findAll();
		}

		@Override
		public Reserve findById(Long id) {
			// TODO Auto-generated method stub
			return rr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Não encontrado"));
		}

		@Override
		public Reserve save(Reserve reserve) {
			// TODO Auto-generated method stub
			return rr.save(reserve);
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			rr.deleteById(id);
			
		}

		@Override
		public Reserve updateById(Long id, Reserve reserveupdate) {
			Reserve reserve=rr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Não encontrado"));
			reserve.setJoinDate(reserveupdate.getJoinDate());
			reserve.setName(reserveupdate.getName());
			reserve.setTicket(reserveupdate.getTicket());
			return rr.save(reserve);
		}

}
