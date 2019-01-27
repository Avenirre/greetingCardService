package com.gc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gc.model.Card;
import com.gc.model.CardDto;
import com.gc.model.Template;
import com.gc.model.TemplateDto;
import com.gc.services.CardService;
import com.gc.services.TemplateService;

@Controller
@RequestMapping("greetingcards/")
public class CardController {
	
	TemplateService templateService;
	CardService cardService;
	
    public CardController(TemplateService templateService) {
		this.templateService = templateService;
	}

	@GetMapping("card/{id}/create")
    public String getTemplate(@PathVariable String id, Model model){
		TemplateDto templateDto = templateService.findTemplateById(id);
        model.addAttribute("card", new CardDto(templateDto));
        return "cardform";
    }
	
	@PostMapping("card/save")
	public String saveCard(@ModelAttribute("card") CardDto cardDto) {
		cardService.saveCard(new Card(cardDto));
		return "redirect:/greetingcards/cards";
	}
	
	@GetMapping("cards")
	public String getCatalog(Model model) {
		model.addAttribute("cards", cardService.getCards());
		return "cards";
	}

}
