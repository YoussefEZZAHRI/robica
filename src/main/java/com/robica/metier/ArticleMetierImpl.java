package com.robica.metier;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robica.dao.ArticleRepository;
import com.robica.entities.Article;
import com.robica.entities.Categorie;
import com.robica.entities.LigneCommande;

@Service
@Transactional
public class ArticleMetierImpl implements ArticleMetier {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Article consulterArticle(String refArticle) {
		Article art = articleRepository.findOne(refArticle);
		if (art == null)
			throw new RuntimeException("article Introuvable");
		return art;
	}

	@Override
	public void ajouter(String reference, Double qtestock, Double seuil, String libelle, String observation,
			String rayon, Categorie categorie) {
		Article art = new Article(reference, qtestock, seuil, libelle, observation, rayon, categorie);
		articleRepository.save(art);
	}

	@Override
	public String verifier(String h) {

		Article a = articleRepository.findbylibelle(h);
		int j = 0;

		List<LigneCommande> list = articleRepository.sommequantite(a);
		for (LigneCommande item : list) {
			j = j + item.getQte();
		}
		return "Quantité en Stock " + a.getQtestock() + " Demande en attente " + j + "";

	}

	@Override
	public void supprimer(String refArticle) {
		Article art = consulterArticle(refArticle);
		articleRepository.delete(art);
		if (art == null)
			throw new RuntimeException("article Introuvable");

	}

	@Override
	public Page<Article> listArticle(Pageable pageable) {
		List<Article> l = articleRepository.findAll();

		Page<Article> p = new PageImpl<Article>(l, pageable, l.size());

		return p;
	}
}
