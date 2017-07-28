package com.robica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robica.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, String>{

}
