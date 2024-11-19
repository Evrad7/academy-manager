package com.Ms2d4.tp1.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.Ms2d4.tp1.Model.Salle;
import com.Ms2d4.tp1.Repository.SalleRepository;

@Service
public class SalleService {
    SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }


    public List<Salle> getSalleList() {
        return salleRepository.findAll();
    }


    public Salle getSalleById(Long id) {
        Optional<Salle> salle =salleRepository.findById(id);
        salle.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return salle.get();
    }


    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }


    public Salle updateSalle(Long id, Salle salle) {
    	Optional<Salle> optionalSalle =salleRepository.findById(id);
    	optionalSalle.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    	Salle s=optionalSalle.get();
    	s.setId(id);
    	s.setNombrePlace(salle.getNombrePlace());
    	s.setNumero(salle.getNumero());
    	return salleRepository.save(s);
        
        
    }

    public void deleteSalleById(Long id) {
    	salleRepository.deleteById(id);;
    }


    
}
