package com.robica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robica.entities.LigneCommande;

public interface LigneComRepository extends JpaRepository<LigneCommande, Integer>{

}
