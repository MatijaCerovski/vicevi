package com.croz.vicevi.controller;

import com.croz.vicevi.service.joke.JokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class Home {

    @Autowired
    JokeServiceImpl jokeService;

    @GetMapping("/")
    public String getHome(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("jokes", jokeService.findAll(PageRequest.of(page, 10, Sort.Direction.DESC, "difference")));
        model.addAttribute("currentPage", page);
        return "home";
    }

    @PostMapping("/like")
    public String likeJoke(@ModelAttribute("jokeId") Integer jokeId, RedirectAttributes redirectAttributes){

        jokeService.like(jokeId);

        return "redirect:/";
    }

    @PostMapping("/dislike")
    public String dislikeJoke(@ModelAttribute("jokeId") Integer jokeId, RedirectAttributes redirectAttributes){

        jokeService.dislike(jokeId);

        return "redirect:/";
    }

}
