package com.Ms2d4.tp1.Model;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etablissement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Time heureDebutCoursJour;
	
	private Time heureDebutCoursSoir;
	
	
}
