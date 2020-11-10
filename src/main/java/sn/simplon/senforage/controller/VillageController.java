package sn.simplon.senforage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sn.simplon.senforage.dao.IVillage;
import sn.simplon.senforage.entities.Village;

@Controller
public class VillageController {

	@Autowired
	private IVillage villagedao;
	@RequestMapping(value="village/liste")
	public ModelAndView liste() {
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("village/liste");
		List<Village> villages = villagedao.findAll();
		return new ModelAndView("village/liste", "liste_villages", villages);
	}
	
	
}
