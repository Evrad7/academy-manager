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
import com.Ms2d4.tp1.Dto.EmploiDeTempsEnseignantDto;
import com.Ms2d4.tp1.Model.EmploiDeTemps;
import com.Ms2d4.tp1.Service.EmploiDeTempsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/emploi-de-temps")
public class EmploiDeTempsController {
	
    private final EmploiDeTempsService emploiDeTempsService;

    
    public EmploiDeTempsController(EmploiDeTempsService emploiDeTempsService) {
        this.emploiDeTempsService = emploiDeTempsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmploiDeTemps>> getAllEmploiDeTempss () {
        List<EmploiDeTemps> emploiDeTempsLightList = emploiDeTempsService.getEmploiDeTempsList();
        return new ResponseEntity<>(emploiDeTempsLightList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmploiDeTemps> getEmploiDeTempsById (@PathVariable("id") Long emploiDeTempsId) {
        EmploiDeTemps emploiDeTemps = emploiDeTempsService.getEmploiDeTempsById(emploiDeTempsId);
        return new ResponseEntity<>(emploiDeTemps, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmploiDeTemps> addEmploiDeTemps (@RequestBody EmploiDeTemps emploiDeTemps) {
        EmploiDeTemps newEmploiDeTemps = emploiDeTempsService.saveEmploiDeTemps(emploiDeTemps);
        return new ResponseEntity<>(newEmploiDeTemps, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmploiDeTemps> updateEmploiDeTemps (@PathVariable("id") Long emploiDeTempsId, @RequestBody EmploiDeTemps emploiDeTemps)  {
        EmploiDeTemps updateEmploiDeTemps = emploiDeTempsService.updateEmploiDeTemps(emploiDeTempsId, emploiDeTemps);
        return new ResponseEntity<>(updateEmploiDeTemps, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmploiDeTemps (@PathVariable("id") Long emploiDeTempsId)  {
        emploiDeTempsService.deleteEmploiDeTempsById(emploiDeTempsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("enseignant/{enseignantId}")
    public ResponseEntity<List<EmploiDeTempsEnseignantDto>> getEmploiDeTempsEngengnant (@PathVariable("enseignantId") Long enseignantId) {
    	List<EmploiDeTempsEnseignantDto> emploiDeTempsEnseignantDto = emploiDeTempsService.getEmploiDeTempsEnseignant(enseignantId);
        return new ResponseEntity<>(emploiDeTempsEnseignantDto, HttpStatus.OK);
    }
    
    @GetMapping("enseignant/{enseignantId}/{numeroSemaine}")
    public ResponseEntity<List<EmploiDeTempsEnseignantDto>> getEmploiDeTempsEngengnant (@PathVariable("enseignantId") Long enseignantId, @PathVariable("numeroSemaine") int numeroSemaine) {
    	List<EmploiDeTempsEnseignantDto> emploiDeTempsEnseignantDto = emploiDeTempsService.getEmploiDeTempsEnseignant(enseignantId, numeroSemaine);
        return new ResponseEntity<>(emploiDeTempsEnseignantDto, HttpStatus.OK);
    }
    
    @GetMapping("enseignant/{enseignantId}/all")
    public ResponseEntity<List<EmploiDeTempsEnseignantDto>> getAllEmploiDeTempsEngengnant (@PathVariable("enseignantId") Long enseignantId) {
        return new ResponseEntity<>(emploiDeTempsService.getAllEmploiDeTempsEnseignant(enseignantId), HttpStatus.OK);
    }

}
