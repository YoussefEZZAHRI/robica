package com.robica.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.robica.entities.Article;
import com.robica.entities.Categorie;



public interface ArticleMetier {

	public Article consulterArticle(String refArticle);
    public void ajouter(String reference,Double qtestock,Double seuil,String libelle,String observation, String rayon,Categorie categorie);
	public void supprimer(String refArticle);
	 public String verifier(String h);
	 public Page<Article> listArticle(Pageable pageable);

}
