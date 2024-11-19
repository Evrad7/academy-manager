package com.Ms2d4.tp1.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne()
	private Matiere matiere;
	
	@ManyToOne
	private Salle salle;
	
	@OneToOne(mappedBy = "cours1")
	@JsonBackReference("cours1")
	private EmploiDeTempsJour emploisDeTempsCours1;
	
	
	@OneToOne(mappedBy = "cours2")
	@JsonBackReference("cours2")
	private EmploiDeTempsJour emploisDeTempsCours2;
	
	
	@OneToOne(mappedBy = "cours3")
	@JsonBackReference("cours3")
	private EmploiDeTempsJour emploisDeTempsCours3;
	
	
	@OneToOne(mappedBy = "cours4")
	@JsonBackReference("cours4")
	private EmploiDeTempsJour emploisDeTempsCours4;
	
}
