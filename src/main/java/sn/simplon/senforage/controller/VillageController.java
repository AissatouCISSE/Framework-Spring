package sn.simplon.senforage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.simplon.senforage.dao.IUser;
import sn.simplon.senforage.dao.IVillage;
import sn.simplon.senforage.entities.User;
import sn.simplon.senforage.entities.Village;

@Controller
public class VillageController {

	@Autowired
	private IVillage villagedao;
	@Autowired
	private IUser userdao;
	@RequestMapping(value="village/liste")
	public ModelAndView liste() {
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("village/liste");
		List<Village> villages = villagedao.findAll();
		return new ModelAndView("village/liste", "liste_villages", villages);
	}
	
	@RequestMapping(value="village/create" )
	public ModelAndView create( ModelMap model) {
	
		List<User> users = userdao.findAll();
		model.put("liste_users", users);
		return new ModelAndView("village/create");
	}
	
	@RequestMapping(value="village/add" , method = RequestMethod.POST )
	public String create(String nom_village , int idUser) {
	
		ModelAndView modelAndView = new ModelAndView();
		Village village = new Village();
		village.setNom_village(nom_village);
		User user = new User();
		user =  userdao.getOne(idUser);
		village.setUser(user);
		try {
			villagedao.save(village);
			modelAndView.addObject("result",new String("Donnees ajoutees"));
		} catch (Exception e) {
			modelAndView.addObject("result",new String("Donnees non ajoutees"));
		}
		
		modelAndView.setViewName("village/liste");
		return  "redirect:/village/liste";
	}
	
	@RequestMapping(value="/village/delete" , method = RequestMethod.GET )
	public String delete(int id) {
		try {
			villagedao.delete(villagedao.getOne(id));
			villagedao.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "redirect:/village/liste";
	}
	
	
}
