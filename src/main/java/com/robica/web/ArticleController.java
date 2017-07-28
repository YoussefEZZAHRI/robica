package com.robica.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.robica.dao.ArticleRepository;
import com.robica.entities.Article;
import com.robica.metier.ArticleMetier;

@Controller
public class ArticleController {
	@Autowired
	private ArticleMetier artM;
	@Autowired
	private ArticleRepository artR;

	@RequestMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping("/articles")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		List<Article> l = artR.findAll();

		try {

			Page<Article> pageArticle = new PageImpl<Article>(l, new PageRequest(page, size), l.size());
			model.addAttribute("listArticle", pageArticle.getContent());
			int[] pages = new int[pageArticle.getTotalPages()];
			model.addAttribute("pages", pages);

		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "article";
	}

	@RequestMapping("/ajouterArticle")
	public String ajouter(Model model, Article article) {
		artR.save(article);

		return "article";
	}

	@RequestMapping("/supprimerArticle")
	public String supprimer(Model model, String reference) {
		model.addAttribute("reference", reference);

		try {
			artM.supprimer(reference);

		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "article";
	}

	@RequestMapping("/consulterArticle")
	public String consulter(Model model, String reference) {
		model.addAttribute("reference", reference);
		try {
			Article art = artM.consulterArticle(reference);

			model.addAttribute("article", art);

		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "article";
	}

}
