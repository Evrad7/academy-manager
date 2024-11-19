package com.Ms2d4.tp1.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.Ms2d4.tp1.Model.Filiere;
import com.Ms2d4.tp1.Repository.FiliereRepository;

@Service
public class FiliereService {
	
	FiliereRepository filiereRepository;

    public FiliereService(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }


    public List<Filiere> getFiliereList() {
        return filiereRepository.findAll();
    }


    public Filiere getFiliereById(Long id) {
        Optional<Filiere> filiere =filiereRepository.findById(id);
        filiere.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return filiere.get();
    }


    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }


    public Filiere updateFiliere(Long id, Filiere filiere) {
    	Optional<Filiere> optionalFiliere =filiereRepository.findById(id);
    	optionalFiliere.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    	Filiere f=optionalFiliere.get();
    	f.setId(id);
    	f.setNom(filiere.getNom());;
    	return filiereRepository.save(f);
        
        
    }

    public void deleteFiliereById(Long id) {
    	filiereRepository.deleteById(id);;
    }


}
