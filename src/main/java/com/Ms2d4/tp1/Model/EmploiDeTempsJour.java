package com.Ms2d4.tp1.Model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class EmploiDeTempsJour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dateJour;
	
	@Column(columnDefinition = "boolean default true")
	private boolean enJournee;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("cours1")
	private Cours cours1;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("cours2")
	private Cours cours2;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("cours3")
	private Cours cours3;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("cours4")
	private Cours cours4;
	
	@OneToOne(mappedBy = "lundi")
	@JsonBackReference("lundi")
	private EmploiDeTemps emploiDeTempsLundi;
	
	@OneToOne(mappedBy = "mardi")
	@JsonBackReference("mardi")
	private EmploiDeTemps emploiDeTempsMardi;
	
	@OneToOne(mappedBy = "mercredi")
	@JsonBackReference("mercredi")
	private EmploiDeTemps emploiDeTempsMercredi;
	
	@OneToOne(mappedBy = "jeudi")
	@JsonBackReference("jeudi")
	private EmploiDeTemps emploiDeTempsJeudi;
	
	@OneToOne(mappedBy = "vendredi")
	@JsonBackReference("vendredi")
	private EmploiDeTemps emploiDeTempsVendredi;
	
	@OneToOne(mappedBy = "samedi")
	@JsonBackReference("samedi")
	private EmploiDeTemps emploiDeTempsSamedi;
	
	@OneToOne(mappedBy = "dimanche")
	@JsonBackReference("dimanche")
	private EmploiDeTemps emploiDeTempsDimanche;

}
