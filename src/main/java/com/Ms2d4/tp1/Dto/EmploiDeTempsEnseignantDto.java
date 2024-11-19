package com.Ms2d4.tp1.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDeTempsEnseignantDto {
	

	private EmploiDeTempsJourEnseignantDto lundi;
	

	private EmploiDeTempsJourEnseignantDto mardi;


	private EmploiDeTempsJourEnseignantDto mercredi;
	

	private EmploiDeTempsJourEnseignantDto jeudi;
	

	private EmploiDeTempsJourEnseignantDto vendredi;
	

	private EmploiDeTempsJourEnseignantDto samedi;
	

	private EmploiDeTempsJourEnseignantDto dimanche;
	
	public boolean isEmpty() {
		return lundi.isEmpty()&&mardi.isEmpty()&&mercredi.isEmpty()&&jeudi.isEmpty()&&vendredi.isEmpty()&&samedi.isEmpty()&&dimanche.isEmpty();
	}
}
