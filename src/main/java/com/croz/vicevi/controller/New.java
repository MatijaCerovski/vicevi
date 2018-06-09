package com.croz.vicevi.controller;

import com.croz.vicevi.form.JokeForm;
import com.croz.vicevi.mapper.form.JokeFormMapper;
import com.croz.vicevi.service.category.CategoryServiceImpl;
import com.croz.vicevi.service.joke.JokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
public class New {

    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    JokeServiceImpl jokeService;


    @Autowired
    JokeFormMapper jokeFormMapper;


    @GetMapping("/new")
    public String newJoke(Model model){
        JokeForm jokeForm = new JokeForm();
        model.addAttribute("jokeForm", jokeForm);
        model.addAttribute("categories", categoryService.findAll());
        return "new";
    }

    @PostMapping("/new")
    public ModelAndView saveJoke(@ModelAttribute("jokeForm") @Valid JokeForm jokeForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("new");
            modelAndView.addObject("errorMessage", "Error!");
            return modelAndView;
        } else {
            try{
                jokeService.save(jokeFormMapper.mapToEntity(jokeForm));
                return new ModelAndView("redirect:/");
            }catch (EntityNotFoundException exception){
                ModelAndView modelAndView = new ModelAndView("new");
                modelAndView.addObject("errorMessage", "Joke category not found!");
                return modelAndView;
            }
        }

    }
}
