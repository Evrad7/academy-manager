package com.Ms2d4.tp1.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Ms2d4.tp1.Model.EmploiDeTempsJour;
import com.Ms2d4.tp1.Service.EmploiDeTempsJourService;

@RestController
@CrossOrigin("*")
@RequestMapping("/emploi-de-temps-jour")
public class EmploiDeTempsJourController {
		
	final private EmploiDeTempsJourService emploiDeTempsJourService;
	
	public EmploiDeTempsJourController(EmploiDeTempsJourService emploiDeTempsJourService) {
		this.emploiDeTempsJourService=emploiDeTempsJourService;
	}
	
	 @GetMapping("/find/{id}")
	    public ResponseEntity<EmploiDeTempsJour> getEmploiDeTempsById (@PathVariable("id") Long id) {
	        EmploiDeTempsJour emploiDeTempsJour = emploiDeTempsJourService.getEmploiDeTempsJourById(id);
	        return new ResponseEntity<>(emploiDeTempsJour, HttpStatus.OK);
	    }
}
