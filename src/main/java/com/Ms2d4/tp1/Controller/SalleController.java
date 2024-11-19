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

import com.Ms2d4.tp1.Model.Salle;
import com.Ms2d4.tp1.Service.SalleService;



@RestController
@CrossOrigin("*")
@RequestMapping("/salle")
public class SalleController {
	
    private final SalleService salleService;

    
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Salle>> getAllSalles () {
        List<Salle> salleList = salleService.getSalleList();
        return new ResponseEntity<>(salleList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Salle> getSalleById (@PathVariable("id") Long salleId) {
        Salle salle = salleService.getSalleById(salleId);
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Salle> addSalle (@RequestBody Salle salle) {
        Salle newSalle = salleService.saveSalle(salle);
        return new ResponseEntity<>(newSalle, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Salle> updateSalle (@PathVariable("id") Long salleId, @RequestBody Salle salle)  {
        Salle updateSalle = salleService.updateSalle(salleId, salle);
        return new ResponseEntity<>(updateSalle, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSalle (@PathVariable("id") Long salleId)  {
        salleService.deleteSalleById(salleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
