package com.Ms2d4.tp1.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.Ms2d4.tp1.Model.Matiere;
import com.Ms2d4.tp1.Repository.MatiereRepository;

@Service
public class MatiereService {
	  MatiereRepository matiereRepository;

	    public MatiereService(MatiereRepository matiereRepository) {
	        this.matiereRepository = matiereRepository;
	    }


	    public List<Matiere> getMatiereList() {
	        return matiereRepository.findAll();
	    }


	    public Matiere getMatiereById(Long id) {
	        Optional<Matiere> matiere =matiereRepository.findById(id);
	        matiere.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	        return matiere.get();
	    }


	    public Matiere saveMatiere(Matiere matiere) {
	        return matiereRepository.save(matiere);
	    }


	    public Matiere updateMatiere(Long id, Matiere matiere) {
	    	Optional<Matiere> optionalMatiere =matiereRepository.findById(id);
	    	optionalMatiere.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	    	Matiere m=optionalMatiere.get();
	    	m.setId(id);
	    	m.setIntitule(matiere.getIntitule());
	    	m.setNombreCredit(matiere.getNombreCredit());
	    	m.setEnseignant(matiere.getEnseignant());
	    	m.setFiliere(matiere.getFiliere());
	    	return matiereRepository.save(m);
	        
	        
	    }

	    public void deleteMatiereById(Long id) {
	    	matiereRepository.deleteById(id);;
	    }
}
