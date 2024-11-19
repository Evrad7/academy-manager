package com.Ms2d4.tp1.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ms2d4.tp1.Model.Filiere;
import com.Ms2d4.tp1.Service.FiliereService;


@RestController
@CrossOrigin("*")
@RequestMapping("/filiere")
public class FiliereController {
	  private final FiliereService filiereService;

	    
	    public FiliereController(FiliereService filiereService) {
	        this.filiereService = filiereService;
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Filiere>> getAllFilieres () {
	        List<Filiere> filiereList = filiereService.getFiliereList();
	        return new ResponseEntity<>(filiereList, HttpStatus.OK);
	    }

	    @GetMapping("/find/{id}")
	    public ResponseEntity<Filiere> getFiliereById (@PathVariable("id") Long filiereId) {
	        Filiere filiere = filiereService.getFiliereById(filiereId);
	        return new ResponseEntity<>(filiere, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Filiere> addFiliere (@RequestBody Filiere filiere) {
	        Filiere newFiliere = filiereService.saveFiliere(filiere);
	        return new ResponseEntity<>(newFiliere, HttpStatus.OK);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Filiere> updateFiliere (@PathVariable("id") Long filiereId, @RequestBody Filiere filiere)  {
	        Filiere updateFiliere = filiereService.updateFiliere(filiereId, filiere);
	        return new ResponseEntity<>(updateFiliere, HttpStatus.OK);
	    }

	    @Transactional
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteFiliere (@PathVariable("id") Long filiereId)  {
	        filiereService.deleteFiliereById(filiereId);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
