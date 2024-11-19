package com.Ms2d4.tp1.Service;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.Ms2d4.tp1.Model.EmploiDeTempsJour;
import com.Ms2d4.tp1.Repository.EmploiDeTempsJourRepository;


@Service
public class EmploiDeTempsJourService {
	
	final private EmploiDeTempsJourRepository emploiDeTempsJourRepository;
	
	public EmploiDeTempsJourService(EmploiDeTempsJourRepository emploiDeTempsJourRepository) {
		this.emploiDeTempsJourRepository=emploiDeTempsJourRepository;
	}
	
	 public EmploiDeTempsJour getEmploiDeTempsJourById(Long id) {
	        Optional<EmploiDeTempsJour> emploiDeTempsJour =emploiDeTempsJourRepository.findById(id);
	        emploiDeTempsJour.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	        return emploiDeTempsJour.get();
	    }
}
