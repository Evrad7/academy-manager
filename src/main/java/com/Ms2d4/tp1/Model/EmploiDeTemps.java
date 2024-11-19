package com.Ms2d4.tp1.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploiDeTemps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne()
	private Filiere filiere;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("lundi")
	private EmploiDeTempsJour lundi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("mardi")
	private EmploiDeTempsJour mardi;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("mercredi")
	private EmploiDeTempsJour mercredi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("jeudi")
	private EmploiDeTempsJour jeudi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("vendredi")
	private EmploiDeTempsJour vendredi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("samedi")
	private EmploiDeTempsJour samedi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("dimanche")
	private EmploiDeTempsJour dimanche;
	
	

	

}
