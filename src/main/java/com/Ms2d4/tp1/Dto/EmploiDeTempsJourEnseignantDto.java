package com.Ms2d4.tp1.Dto;

import java.util.Date;

import com.Ms2d4.tp1.Model.Cours;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDeTempsJourEnseignantDto {
	
	private Date dateJour;
	

	private Cours cours1;

	private Cours cours2;

	private Cours cours3;

	private Cours cours4;
	
	
	private Cours cours5;

	private Cours cours6;

	private Cours cours7;

	private Cours cours8;

	public boolean isEmpty() {
		return (cours1==null)&&(cours2==null)&&(cours3==null)&&(cours4==null)&&(cours5==null)&&(cours6==null)&&(cours7==null)&&(cours8==null);
	}
}
