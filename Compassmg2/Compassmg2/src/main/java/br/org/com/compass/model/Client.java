package br.org.com.compass.model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long _id;

	private String name;

	private String CPF;

	private LocalDate JoinDate;
	
	private String Nationality;

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = { CascadeType.ALL })
	/*@OnDelete(action = OnDeleteAction.CASCADE)*/
	private Set<Reserve> reserve = new HashSet<Reserve>();

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public LocalDate getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(LocalDate JoinDate) {
		this.JoinDate = JoinDate;
	}

	public Set<Reserve> getReserve() {
		return reserve;
	}

	public void setReserve(Set<Reserve> reserve) {
		this.reserve = reserve;
	}


}
