package sn.simplon.senforage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sn.simplon.senforage.dao.IClient;
import sn.simplon.senforage.dao.IUser;
import sn.simplon.senforage.dao.IVillage;
import sn.simplon.senforage.entities.Client;
import sn.simplon.senforage.entities.User;
import sn.simplon.senforage.entities.Village;

@Controller
public class ClientController {

	@Autowired
	private IClient clientdao;
	@Autowired
	private IUser userdao;
	@Autowired
	private IVillage villagedao;
	
	@RequestMapping(value="client/liste")
	public ModelAndView liste() {
		List<Client> clients = clientdao.findAll();
		return new ModelAndView("client/liste", "liste_clients", clients);
	}
	
	@RequestMapping(value="client/create" )
	public ModelAndView create( ModelMap model) {
	
		List<Village> villages = villagedao.findAll();
		model.put("liste_villages", villages);
		
		List<User> users = userdao.findAll();
		model.put("liste_users", users);
		return new ModelAndView("client/create");
	}
	
	@RequestMapping(value="client/add" , method = RequestMethod.POST )
	public String create(String nom_client , String adresse_client, String telephone_client,  int idVillage, int idUser) {
	
		ModelAndView modelAndView = new ModelAndView();
		Client client = new Client();
		client.setNom_client(nom_client);
		client.setAdresse_client(adresse_client);
		client.setTelephone_client(telephone_client);
		Village village = new Village();
		village =  villagedao.getOne(idVillage);
		client.setVillage(village);
		
		User user = new User();
		user =  userdao.getOne(idUser);
		client.setUser(user);
		try {
			clientdao.save(client);
			modelAndView.addObject("result",new String("Donnees ajoutees"));
		} catch (Exception e) {
			modelAndView.addObject("result",new String("Donnees non ajoutees"));
		}
		
		modelAndView.setViewName("client/liste");
		return  "redirect:/client/liste";
	}
	
	@RequestMapping(value="/client/delete" , method = RequestMethod.GET )
	public String delete(int id) {
		try {
			clientdao.delete(clientdao.getOne(id));
			clientdao.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "redirect:/client/liste";
	}
	
	@RequestMapping(value="/client/edit" , method = RequestMethod.GET )
	public ModelAndView edit(int id) {
		Client client = clientdao.getOne(id);
		return  new ModelAndView ("client/liste" , "client", client );
	}
}
