package com.Ms2d4.tp1.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.Ms2d4.tp1.Dto.EmploiDeTempsEnseignantDto;
import com.Ms2d4.tp1.Dto.EmploiDeTempsJourEnseignantDto;
import com.Ms2d4.tp1.Model.EmploiDeTemps;
import com.Ms2d4.tp1.Repository.EmploiDeTempsRepository;

@Service
public class EmploiDeTempsService {
	EmploiDeTempsRepository emploiDeTempsRepository;

    public EmploiDeTempsService(EmploiDeTempsRepository emploiDeTempsRepository) {
        this.emploiDeTempsRepository = emploiDeTempsRepository;
    }


    public List<EmploiDeTemps> getEmploiDeTempsList() {
        return emploiDeTempsRepository.findAll();
    }


    public EmploiDeTemps getEmploiDeTempsById(Long id) {
        Optional<EmploiDeTemps> emploiDeTemps =emploiDeTempsRepository.findById(id);
        emploiDeTemps.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return emploiDeTemps.get();
    }


    public EmploiDeTemps saveEmploiDeTemps(EmploiDeTemps emploiDeTemps) {
        return emploiDeTempsRepository.save(emploiDeTemps);
    }


    public EmploiDeTemps updateEmploiDeTemps(Long id, EmploiDeTemps emploiDeTemps) {
    	Optional<EmploiDeTemps> optionalEmploiDeTemps =emploiDeTempsRepository.findById(id);
    	optionalEmploiDeTemps.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    	EmploiDeTemps e=optionalEmploiDeTemps.get();
    	e.setId(id);
//    	e.setFiliere(emploiDeTemps.getFiliere());
    	e.setLundi(emploiDeTemps.getLundi());
    	e.setMardi(emploiDeTemps.getMardi());
    	e.setMercredi(emploiDeTemps.getMercredi());
    	e.setJeudi(emploiDeTemps.getJeudi());
    	e.setVendredi(emploiDeTemps.getVendredi());
    	e.setSamedi(emploiDeTemps.getSamedi());
    	e.setDimanche(emploiDeTemps.getDimanche());
    	return emploiDeTempsRepository.save(e);
        
        
    }

    public void deleteEmploiDeTempsById(Long id) {
    	emploiDeTempsRepository.deleteById(id);;
    }
    
    
    public List<EmploiDeTempsEnseignantDto> getEmploiDeTempsEnseignant(Long idEnseignant, int numeroSemaine) {
    	EmploiDeTempsEnseignantDto emploiDeTempsEnseignantDto=new EmploiDeTempsEnseignantDto();
    	Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2024);
        cal.set(Calendar.WEEK_OF_YEAR, numeroSemaine);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	Date dateLundi=cal.getTime();
    	emploiDeTempsEnseignantDto.setLundi(
    			new EmploiDeTempsJourEnseignantDto(
    					dateLundi,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateLundi),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateLundi)
    	    			)
    			
    			);
    	
    	cal.add(Calendar.DATE, 1);
    	Date dateMardi = cal.getTime();
    	emploiDeTempsEnseignantDto.setMardi(
    			new EmploiDeTempsJourEnseignantDto(
    					dateMardi,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateMardi),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateMardi)
    	    			)
    			
    			);
    	
    	cal.add(Calendar.DATE, 1);
    	Date dateMercredi = cal.getTime();
    	emploiDeTempsEnseignantDto.setMercredi(
    			new EmploiDeTempsJourEnseignantDto(
    					dateMercredi,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateMercredi),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateMercredi)
    	    			)
    			
    			);
    	
    	cal.add(Calendar.DATE, 1);
    	Date dateJeudi = cal.getTime();
    	emploiDeTempsEnseignantDto.setJeudi(
    			new EmploiDeTempsJourEnseignantDto(
    					dateJeudi,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateJeudi),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateJeudi)
    	    			)
    			
    			);
    	cal.add(Calendar.DATE, 1);
    	Date dateVendredi = cal.getTime();
    	emploiDeTempsEnseignantDto.setVendredi(
    			new EmploiDeTempsJourEnseignantDto(
    					dateVendredi,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateVendredi),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateVendredi)
    	    			)
    			
    			);
    	cal.add(Calendar.DATE, 1);
    	Date dateSamedi = cal.getTime();
    	emploiDeTempsEnseignantDto.setSamedi(
    			new EmploiDeTempsJourEnseignantDto(
    					dateSamedi,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateSamedi),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateSamedi)
    	    			)
    			
    			);
    	
    	cal.add(Calendar.DATE, 1);
    	Date dateDimanche = cal.getTime();
    	emploiDeTempsEnseignantDto.setDimanche(
    			new EmploiDeTempsJourEnseignantDto(
    					dateDimanche,
    					emploiDeTempsRepository.findCours1Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours2Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours3Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours4Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours5Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours6Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours7Enseingant(idEnseignant, dateDimanche),
    	    			emploiDeTempsRepository.findCours8Enseingant(idEnseignant, dateDimanche)
    	    			)
    			
    			);
    	List<EmploiDeTempsEnseignantDto> emploisDetemps=new ArrayList<EmploiDeTempsEnseignantDto>();
    	emploisDetemps.add(emploiDeTempsEnseignantDto);
    	return emploisDetemps;
    }
    public List<EmploiDeTempsEnseignantDto> getEmploiDeTempsEnseignant(Long idEnseignant) {
    	Calendar cal = Calendar.getInstance();  
        int numeroSemaine = cal.get(Calendar.WEEK_OF_YEAR);  
        return getEmploiDeTempsEnseignant(idEnseignant, numeroSemaine);
    }
    
    public List<EmploiDeTempsEnseignantDto> getAllEmploiDeTempsEnseignant(Long idEnseignant){
    	Calendar cal = Calendar.getInstance();  
        int numeroSemaine = cal.get(Calendar.WEEK_OF_YEAR); 
        List<EmploiDeTempsEnseignantDto> emploisDeTemps=getEmploiDeTempsEnseignant(idEnseignant, numeroSemaine+1);
        if(!emploisDeTemps.get(0).isEmpty()) {
        	emploisDeTemps.remove(0);
        }
        int n=2;
        //On ajoute à la  liste des emplois de temps sur les n dernieres semaines;
        for (int i=0; i<n; i++) {
        	emploisDeTemps.add(getEmploiDeTempsEnseignant(idEnseignant, numeroSemaine+i).get(0));
        }
        return emploisDeTemps;
    }
}
