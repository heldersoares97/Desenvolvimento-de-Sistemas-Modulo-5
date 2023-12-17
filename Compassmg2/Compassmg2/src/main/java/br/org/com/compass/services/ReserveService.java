package br.org.com.compass.services;

import java.util.List;
import br.org.com.compass.model.Reserve;

public interface ReserveService {
	
	List<Reserve> ListreserveAll();
	
	Reserve  findById(Long id);
	
	Reserve save(Reserve reserve);
	
	void deleteById(Long id);
	
	Reserve updateById(Long id, Reserve reserveupdate);

	
	
	
	
}
