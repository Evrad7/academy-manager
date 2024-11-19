package com.Ms2d4.tp1.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDeTempsLightListDto {

	private Long id;
	
	private FiliereLightDto filiere;
	

	private Long idemploiDeTempsLundi;
	
	private Long idemploiDeTempsMardi;

	private Long idemploiDeTempsMercredi;
	
	private Long idemploiDeTempsJeudi;

	private Long idemploiDeTempsVendredi;
	
	private Long idemploiDeTempsSamedi;

	private Long idemploiDeTempsDimanche;


}
