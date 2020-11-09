package sn.simplon.senforage.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Village
 *
 */
@Entity

public class Village implements Serializable {

	@Override
	public String toString() {
		return "Village [id=" + id + ", nom_village=" + nom_village + ", user=" + user + ", clients=" + clients + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private static final long serialVersionUID = 1L;
	private String nom_village;

	@ManyToOne
	private User user = new User();

	@OneToMany(mappedBy = "village")
	private List<Client> clients = new ArrayList<Client>();

	public Village() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_village() {
		return nom_village;
	}

	public void setNom_village(String nom_village) {
		this.nom_village = nom_village;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}

