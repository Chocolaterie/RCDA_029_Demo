package fr.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.example.demo.bo.Article;

@Controller
public class ArticleController {

	
	@GetMapping("add-article")
	public String articleForm(Model model) {
		
		model.addAttribute("article", new Article());
		
		return "article-form";
	}
	
	@PostMapping("add-article")
	public String articlePostForm(@Valid @ModelAttribute("article") Article article, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Y'a des erreurs");
			
			return "article-form";
		}
		
		System.out.println("Tout est OK");
		
		return "article-form";
	}
}
