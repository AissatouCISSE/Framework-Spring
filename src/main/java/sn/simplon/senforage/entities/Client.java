package sn.simplon.senforage.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private static final long serialVersionUID = 1L;
	private String nom_client;
	private String adresse_client;
	private String telephone_client;
	@ManyToOne
	private User user = new User();
	@ManyToOne
	private Village village = new Village();
	
	
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	public String getAdresse_client() {
		return adresse_client;
	}
	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}
	public String getTelephone_client() {
		return telephone_client;
	}
	public void setTelephone_client(String telephone_client) {
		this.telephone_client = telephone_client;
	}
	public Client() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
   
}
