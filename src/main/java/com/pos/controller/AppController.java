package com.pos.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.pos.model.Establishment;
import com.pos.model.Floor;
import com.pos.model.L1menu;
import com.pos.model.L2menu;
import com.pos.model.L3menu;
import com.pos.model.MenuMaster;
import com.pos.model.Tables;
import com.pos.model.Taxes;
import com.pos.model.Users;
import com.pos.service.POSService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	POSService posservice;

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = { "/establishment"}, method = RequestMethod.GET)
	public String establishmentPage(ModelMap model) {
		Establishment establishment = new Establishment();
		model.addAttribute("establishment", establishment);
		System.out.println("Establishment obj - " + establishment);
		
		List<MenuMaster> menumasterList2 = posservice.findMenuMasters();		
		model.addAttribute("menumasterList", menumasterList2);
		
		List<MenuMaster> menumasterList = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList);
		System.out.println(menumasterList);
		List<Establishment> establishmentList = posservice.findEstablishments();
		model.addAttribute("establishmentList", establishmentList);
		return "establishment";
	}
	
	@RequestMapping(value = { "/establishment"}, method = RequestMethod.POST)
	public String saveestablishment(@Valid Establishment establishment1, BindingResult result, ModelMap model) {
		System.out.println();
		posservice.addEstablishment(establishment1);
		
		List<MenuMaster> menumasterList2 = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList2);
		
		Establishment establishment = new Establishment();
		model.addAttribute("establishment", establishment);
		
		List<Establishment> establishmentList = posservice.findEstablishments();
		model.addAttribute("establishmentList", establishmentList);
		return "establishment";
	}
	
	@RequestMapping(value = { "/floor"}, method = RequestMethod.GET)
	public String floorPage(ModelMap model) {
		Floor floor = new Floor();
		model.addAttribute("floor", floor);
		
		List<Establishment> establishmentList2 = posservice.findEstablishments();
		model.addAttribute("establishmentList", establishmentList2);
		
		List<Floor> floorList = posservice.findFloors();
		model.addAttribute("floorList", floorList);
		return "floor";
	}
	
	@RequestMapping(value = { "/floor"}, method = RequestMethod.POST)
	public String savefloor(@Valid Floor floor1, BindingResult result, ModelMap model) {
		System.out.println(floor1);
		posservice.addFloor(floor1);
		
		List<Establishment> establishmentList2 = posservice.findEstablishments();
		model.addAttribute("establishmentList", establishmentList2);
		
		Floor floor = new Floor();
		model.addAttribute("floor", floor);
		return "floor";
	}
	
	@RequestMapping(value = { "/users"}, method = RequestMethod.GET)
	public String usersPage(ModelMap model) {
		Users users = new Users();
		model.addAttribute("users", users);
		return "users";
	}
	
	@RequestMapping(value = { "/users"}, method = RequestMethod.POST)
	public String addusers(@Valid Users users, BindingResult result, ModelMap model) {
		posservice.addUser(users);
		
		return "users";
	}

	@RequestMapping(value = { "/menu"}, method = RequestMethod.GET)
	public String menuPage(ModelMap model) {
		return "menu";
	}
	
	@RequestMapping(value = { "/menumaster"}, method = RequestMethod.GET)
	public String menumasterPage(ModelMap model) {
		MenuMaster menumaster = new MenuMaster();
		model.addAttribute("menumaster", menumaster);
		List<MenuMaster> menumasterList = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList);
		return "menumaster";
	}
	
	@RequestMapping(value = { "/menumaster"}, method = RequestMethod.POST)
	public String saveMenumaster(@Valid MenuMaster menumaster1, BindingResult rs, ModelMap model) {
		posservice.addMenuMaster(menumaster1);
		List<MenuMaster> menumasterList = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList);
		MenuMaster menumaster = new MenuMaster();
		model.addAttribute("menumaster", menumaster);
		return "menumaster";
	}
	
	@RequestMapping(value = { "/l1menu"}, method = RequestMethod.GET)
	public String l1menuget(ModelMap model) {
		L1menu l1menu = new L1menu();
		model.addAttribute("l1menu", l1menu);
				
		List<MenuMaster> menumasterList = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList);
		
		List<Taxes> taxList = posservice.findTaxes();
		model.addAttribute("taxList", taxList);
				
		/*List<Taxes> taxList2 = posservice.findTaxes();
		Map<Integer, Float> taxList = taxList2.stream().collect(Collectors.toMap(Taxes::getId, Taxes::getTaxrate)) ;
		model.addAttribute("taxList", taxList.values());*/
		
		/*List<L1menu> l1menuList = posservice.findL1Menu();
		model.addAttribute("l1menuList", l1menuList);*/
		return "l1menu";
	}
	
	@RequestMapping(value = { "/l1menu"}, method = RequestMethod.POST)
	public String saveL1menu(@Valid L1menu l1menu1, BindingResult result, ModelMap model) {
		System.out.println(l1menu1);
		posservice.addL1menu(l1menu1);
		/*List<L1menu> l1menuList = posservice.findL1Menu();
		model.addAttribute("l1menuList", l1menuList);	*/	
		
		List<MenuMaster> menumasterList = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList);
		
		List<Taxes> taxList = posservice.findTaxes();
		//Map<Integer, Float> taxList = taxList2.stream().collect(Collectors.toMap(Taxes::getId, Taxes::getTaxrate)) ;
		model.addAttribute("taxList", taxList);
		
		L1menu l1menu = new L1menu();
		model.addAttribute("l1menu", l1menu);
		return "l1menu";
	}
	
	@RequestMapping(value = { "/l2menu"}, method = RequestMethod.GET)
	public String l2menuPage(ModelMap model) {
		L2menu l2menu = new L2menu();
		model.addAttribute("l2menu", l2menu);
		
		List<MenuMaster> menumasterList2 = posservice.findMenuMasters();		
		model.addAttribute("menumasterList", menumasterList2);
		
		List<Taxes> taxList = posservice.findTaxes();
		//Map<Integer, Float> taxList = taxList2.stream().collect(Collectors.toMap(Taxes::getId, Taxes::getTaxrate)) ;
		model.addAttribute("taxList", taxList);
		return "l2menu";
	}
	
	@RequestMapping(value = { "/l2menu"}, method = RequestMethod.POST)
	public String savel2menu(@Valid L2menu l2menu1, BindingResult result, ModelMap model) {
		posservice.addL2menu(l2menu1);
		//List<L2menu> l2menuList = posservice.findL2Menu();
		//model.addAttribute("l2menuList", l2menuList);
		
		List<MenuMaster> menumasterList2 = posservice.findMenuMasters();
		//Map<Integer,String> menumasterList = menumasterList2.stream().collect(Collectors.toMap(MenuMaster::getId, MenuMaster::getMenumaster));		
		model.addAttribute("menumasterList", menumasterList2);
		
		List<Taxes> taxList = posservice.findTaxes();
		//Map<Integer, Float> taxList = taxList2.stream().collect(Collectors.toMap(Taxes::getId, Taxes::getTaxrate)) ;
		model.addAttribute("taxList", taxList);
		
		L2menu l2menu = new L2menu();
		model.addAttribute("l2menu", l2menu);
		return "l2menu";
	}
	
	@RequestMapping(value = { "/l3menu"}, method = RequestMethod.GET)
	public String l3menuPage(ModelMap model) {
		L3menu l3menu = new L3menu();
		model.addAttribute("l3menu", l3menu);
		
		List<MenuMaster> menumasterList2 = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList2);
		return "l3menu";
	}
	
	@RequestMapping(value = { "/l3menu"}, method = RequestMethod.POST)
	public String l3menuSave(@Valid L3menu l3menu1, BindingResult result, ModelMap model) {
		posservice.addL3menu(l3menu1);
		
		L3menu l3menu = new L3menu();
		model.addAttribute("l3menu", l3menu);
		
		List<MenuMaster> menumasterList2 = posservice.findMenuMasters();
		model.addAttribute("menumasterList", menumasterList2);
		return "l3menu";
	}
	
	@RequestMapping(value = { "/tables"}, method = RequestMethod.GET)
	public String tablesPage(ModelMap model) {
		Tables tables = new Tables();
		model.addAttribute("tables", tables);

		
		List<Floor> floorList = posservice.findFloors();
		model.addAttribute("floorList", floorList);
		return "tables";
	}
	
	@RequestMapping(value = { "/tables"}, method = RequestMethod.POST)
	public String tablesSave(@Valid Tables tables1, BindingResult result, ModelMap model) {
		System.out.println(tables1);
		posservice.addTables(tables1);
		Tables tables = new Tables();
		model.addAttribute("tables", tables);
		List<Floor> floorList = posservice.findFloors();
		model.addAttribute("floorList", floorList);
		return "tables";
	}
	
	@RequestMapping(value = { "/taxes"}, method = RequestMethod.GET)
	public String taxesPage(ModelMap model) {
		List<Taxes> taxList = posservice.findTaxes();
		model.addAttribute("taxList", taxList);
		Taxes taxes =new Taxes();
		model.addAttribute("taxes", taxes);
		return "taxes";
	}
	
	@RequestMapping(value = { "/taxes"}, method = RequestMethod.POST)
	public String saveTaxes(@Valid Taxes tax, BindingResult result, ModelMap model) {
		posservice.addTaxes(tax);
		List<Taxes> taxList = posservice.findTaxes();
		model.addAttribute("taxList", taxList);
		Taxes taxes =new Taxes();
		model.addAttribute("taxes", taxes);
		return "taxes";
	}

	// ***DROPDOWN***
	@RequestMapping(value= "loadL1menu/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String loadL1menu(@PathVariable("id") int id,ModelMap modelMap){
		System.out.println("Inside loadL1menu "+id);
	
		Gson gson = new Gson();
		return gson.toJson(posservice.findByMM(id));
		
	}
	
	@RequestMapping(value= "loadL2menu/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String loadL2menu(@PathVariable("id") int id,ModelMap modelMap){
		System.out.println("Inside loadL2menu "+id);
	
		Gson gson = new Gson();
		return gson.toJson(posservice.findByL1(id));
		
	}
	
	
}