package sn.simplon.senforage.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<User>();
	
	public int getId() {
		return id;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Roles(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
