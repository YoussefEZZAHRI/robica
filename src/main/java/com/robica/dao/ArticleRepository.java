package com.robica.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.robica.entities.Article;
import com.robica.entities.LigneCommande;

public interface ArticleRepository extends JpaRepository<Article, String>{
@Query("Select a FROM Article a where a.libelle=:x")
public Article findbylibelle(@Param("x")String libelle);
@Query(	"SELECT l FROM LigneCommande l where l.article.reference=:r AND l.etat='En_attente'")
public List<LigneCommande> sommequantite(@Param("r")Article art);
	


	
		
}
