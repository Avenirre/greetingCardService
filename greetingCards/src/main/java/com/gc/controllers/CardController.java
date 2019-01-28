package com.gc.controllers;

import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.gc.exceptions.NotFoundException;
import com.gc.model.CardDto;
import com.gc.model.TemplateDto;
import com.gc.services.CardService;
import com.gc.services.TemplateService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("greetingcards/")
public class CardController {
	
	TemplateService templateService;
	CardService cardService;
	
    public CardController(TemplateService templateService, CardService cardService) {
		this.templateService = templateService;
		this.cardService = cardService;
	}

	@GetMapping("card/{id}/create")
    public String getTemplate(@PathVariable String id, Model model){
		TemplateDto templateDto = templateService.findTemplateById(id);
		CardDto cardDto = new CardDto(templateDto);
		model.addAttribute("templatetext", templateDto.getText());
        model.addAttribute("card", cardDto);
        return "cardform";
    }
	
	@Transactional
	@PostMapping("card/save")
	public String saveCard(@ModelAttribute("card") CardDto cardDto) {
		cardService.saveCard(cardDto);
		return "redirect:/greetingcards/cards";
	}
	
	@GetMapping("cards")
	public String getCatalog(Model model) {
		model.addAttribute("cards", cardService.getCards());
		return "cards";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
