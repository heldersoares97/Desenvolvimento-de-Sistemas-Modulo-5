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
import br.org.com.compass.model.Reserve;
import br.org.com.compass.services.ReserveService;


//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiReserve")
public class ReserveController {

		@Autowired
		private ReserveService rs;


		@GetMapping("/allreserves")
		public List<Reserve> getAllReservas() {

			return rs.ListreserveAll();
		}

		@GetMapping("/{id}")
		public ResponseEntity<Reserve> getReserveById(@PathVariable Long id) {
			Reserve reserve = rs.findById(id);
			return ResponseEntity.ok(reserve);
		}

		@PostMapping("/savereserve")
		public Reserve saveReserve(@RequestBody Reserve reserve) {
			return rs.save(reserve);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Reserve> updateReserve(@PathVariable Long id, @RequestBody Reserve reserveDetails) {
			Reserve reserve = rs.findById(id);
			if(reserve != null) {
				reserve.set_id(id);
				reserve.setJoinDate(reserveDetails.getJoinDate());
				reserve.setName(reserveDetails.getName());
				reserve.setTicket(reserveDetails.getTicket());
			
				rs.save(reserve);
				return ResponseEntity.ok(reserve);
			}else {
				throw new RuntimeException("Erro");
			}
			
			
	}

		@DeleteMapping("/{id}")
		public void deleteReserve(@PathVariable Long id) {
			rs.deleteById(id);
		}

    }

 


