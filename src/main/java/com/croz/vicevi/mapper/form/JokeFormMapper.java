package com.croz.vicevi.mapper.form;

import com.croz.vicevi.form.JokeForm;
import com.croz.vicevi.persistence.model.Joke;
import com.croz.vicevi.service.category.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class JokeFormMapper{

    @Autowired
    CategoryServiceImpl categoryService;

    public Joke mapToEntity(JokeForm jokeForm) throws EntityNotFoundException {
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        joke.setLikes(0);
        joke.setDislikes(0);
        joke.setDifference(0);
        //Setting up category, can throw EntityNotFoundException
        joke.setCategory(categoryService.findById(jokeForm.getCategoryId()));
        return joke;

    }


}
