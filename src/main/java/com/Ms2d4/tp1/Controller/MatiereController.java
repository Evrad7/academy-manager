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

import com.Ms2d4.tp1.Model.Matiere;
import com.Ms2d4.tp1.Service.MatiereService;

@RestController
@CrossOrigin("*")
@RequestMapping("/matiere")
public class MatiereController {
    private final MatiereService matiereService;

    
    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMatieres () {
        List<Matiere> matiereList = matiereService.getMatiereList();;
        return new ResponseEntity<>(matiereList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Matiere> getMatiereById (@PathVariable("id") Long matiereId) {
        Matiere matiere = matiereService.getMatiereById(matiereId);
        return new ResponseEntity<>(matiere, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Matiere> addMatiere (@RequestBody Matiere matiere) {
        Matiere newMatiere = matiereService.saveMatiere(matiere);
        return new ResponseEntity<>(newMatiere, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Matiere> updateMatiere (@PathVariable("id") Long matiereId, @RequestBody Matiere matiere)  {
        Matiere updateMatiere = matiereService.updateMatiere(matiereId, matiere);
        return new ResponseEntity<>(updateMatiere, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMatiere (@PathVariable("id") Long matiereId)  {
        matiereService.deleteMatiereById(matiereId);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
