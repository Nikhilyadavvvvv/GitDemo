package com.gym.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gym.model.MemberShip;
import com.gym.model.MemberShipDto;
import com.gym.repos.MemberShipRepository;

@Controller
@RequestMapping("/MemberShipPlans")
public class MemberShipContoller {
       
	   @Autowired
	   private MemberShipRepository repo;
	   
	   
	   @GetMapping({"", "/"})
	   public String showMemeberShipList(Model model)
	   {	
		   List<MemberShip> membership=repo.findAll();
		   model.addAttribute("membership", membership);
		   return "MemberShip/MemberShip";
	   }
	   @GetMapping("/create")
	   public String createMemeberShipList(ModelMap model)
	   {	
		   MemberShipDto ms=new MemberShipDto();
		  
           model.addAttribute("ms",ms);
		   return "MemberShipPlans/createmem";
	   }
	   @PostMapping("/create")
		 public String showUserPageSuccess(@ModelAttribute("ms") MemberShipDto info,ModelMap model){
			
			MemberShip mem=new MemberShip();
	          mem.setMembership_name(info.getMembership_name());
	          mem.setPrice(info.getPrice());
	          mem.setDescription(info.getDescription());
	         
	        repo.save(mem);
	     
	      return "redirect:/MemberShipPlans";
	}
	   
	   @GetMapping("/edit")
	   public String EditMemeberShipList(@RequestParam int id,ModelMap model)
	   {	
		  try {
		   MemberShip mem=repo.findById(id).get();
		   model.addAttribute("mem",mem);
		   MemberShipDto ms=new MemberShipDto();
		  ms.setMembership_name(mem.getMembership_name());
		  ms.setPrice(mem.getPrice());
		  ms.setDescription(mem.getDescription());
		  
		   model.addAttribute("ms",ms);
		  }
		  catch(Exception e) {
			  return "redirect:/MemberShipPlans";
		  }
		   return "MemberShipPlans/editmem";
	   }
	   @PostMapping("/edit")
	   public String updateMemeberShipList(@RequestParam int id,ModelMap model,@ModelAttribute MemberShipDto ms)
	   {	
		  try {
		   MemberShip mem=repo.findById(id).get();
		   model.addAttribute("mem",mem);
		 
		  mem.setMembership_name(ms.getMembership_name());
		  mem.setPrice(ms.getPrice());
		  mem.setDescription(ms.getDescription());
		  repo.save(mem);
		  
		  }
		  catch(Exception e) {
			  return "redirect:/MemberShipPlans";
		  }
		   return "redirect:/MemberShipPlans";
	   }
	   @GetMapping("/delete")
	   public String deleteMemeberShipList(@RequestParam int id)
	   {	
		   try {
			   MemberShip mem=repo.findById(id).get();
			   repo.delete(mem);
		   }
		   catch(Exception e) {
				  return "redirect:/MemberShipPlans";
			  }
		   return "redirect:/MemberShipPlans";
	   }
}
	
