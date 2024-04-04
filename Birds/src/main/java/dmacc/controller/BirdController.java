package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Bird;
import dmacc.repository.BirdRepository;
import jakarta.validation.Valid;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 2, 2024
 */

@Controller
public class BirdController {
	
	@Autowired
	BirdRepository repo;
	
	@GetMapping("/")
	public String getForm(Bird bird) {
		return "index";
	}
	
	@GetMapping({"/viewAll"})
	public String viewAll(Model model) {
		
		if(repo.findAll().isEmpty()) {
			return addNewBird(model);
		}
		
		model.addAttribute("birds", repo.findAll());
		return "results";
		
	}
	
	@GetMapping("/addBird")
	public String addNewBird(Model model) {
		
		Bird b = new Bird();
		model.addAttribute("bird", b);
		
		return "index";
		
	}
	
	@GetMapping("/edit/{id}")
	
	public String editNewBird(@PathVariable("id") int id, Model model) {
		
		Bird b = repo.findById(id).orElse(null);
		model.addAttribute("bird", b);
		
		return "index";
		
	}
	
	@PostMapping("/update/{id}")
	
	public String updateBird(@Valid Bird b, Errors errors, Model model) {
		
		if(null != errors && errors.getErrorCount() > 0) {
			return "index";
		} else {
		
		repo.save(b);
		
		return viewAll(model);
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		Bird b = repo.findById(id).orElse(null);
		repo.delete(b);
		
		return viewAll(model);

}

}
