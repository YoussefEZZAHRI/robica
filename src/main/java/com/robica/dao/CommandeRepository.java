package com.robica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robica.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
