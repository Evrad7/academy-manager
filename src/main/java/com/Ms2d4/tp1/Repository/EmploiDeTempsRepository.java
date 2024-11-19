package com.Ms2d4.tp1.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Ms2d4.tp1.Dto.EmploiDeTempsLightListDto;
import com.Ms2d4.tp1.Model.Cours;
import com.Ms2d4.tp1.Model.EmploiDeTemps;

public interface EmploiDeTempsRepository extends JpaRepository<EmploiDeTemps, Long> {
	
	@Query("SELECT NEW com.Ms2d4.tp1.Dto.EmploiDeTempsLightListDto(edt.id, NEW com.Ms2d4.tp1.Dto.FiliereLightDto(edt.filiere.id, edt.filiere.nom), edt.lundi.id, edt.mardi.id, edt.mercredi.id, edt.jeudi.id, edt.vendredi.id, edt.samedi.id, edt.dimanche.id) from EmploiDeTemps edt LEFT JOIN edt.filiere")
	List<EmploiDeTempsLightListDto> findLightAll();
	

	
	@Query("SELECT edt.cours1 From EmploiDeTempsJour edt WHERE edt.cours1.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=true")
	Cours findCours1Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours2 From EmploiDeTempsJour edt WHERE edt.cours2.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=true")
	Cours findCours2Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours3 From EmploiDeTempsJour edt WHERE edt.cours3.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=true")
	Cours findCours3Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours4 From EmploiDeTempsJour edt WHERE edt.cours4.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=true")
	Cours findCours4Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours1 From EmploiDeTempsJour edt WHERE edt.cours1.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=false")
	Cours findCours5Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours2 From EmploiDeTempsJour edt WHERE edt.cours2.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=false")
	Cours findCours6Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours3 From EmploiDeTempsJour edt WHERE edt.cours3.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=false")
	Cours findCours7Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);
	
	@Query("SELECT edt.cours4 From EmploiDeTempsJour edt WHERE edt.cours4.matiere.enseignant.id=:idEnseignant AND edt.dateJour=:dateJour AND edt.enJournee=false")
	Cours findCours8Enseingant(@Param("idEnseignant") Long idEnseignant, @Param("dateJour") Date datejour);

	
	
}
