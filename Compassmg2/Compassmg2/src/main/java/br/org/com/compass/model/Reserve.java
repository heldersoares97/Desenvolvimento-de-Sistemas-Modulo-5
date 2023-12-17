package br.org.com.compass.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Reserve {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id ;
	
	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(LocalDate JoinDate) {
		this.JoinDate = JoinDate;
	}
	
	public double getTicket() {
		return ticket;
	}

	public void setTicket(double ticket) {
		this.ticket = ticket;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="travel_id")
	private Travel travel;
	
	private String name; 
	
	private LocalDate JoinDate;
	
	private Double ticket;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public void setTicket(Double ticket) {
		this.ticket = ticket;
	}

}
