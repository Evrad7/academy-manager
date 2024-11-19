package com.Ms2d4.tp1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enseignant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String email;

    private String role;

    private String prenom;

    private int phone;

    private String password;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    
    
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.PERSIST)  
    @JsonIgnore
    private List<Matiere> matieres;

    private int annee;
}
