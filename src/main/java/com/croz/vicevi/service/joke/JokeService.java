package com.croz.vicevi.service.joke;

import com.croz.vicevi.persistence.model.Joke;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;

public interface JokeService {
    Joke save(Joke joke);
    Page<Joke> findAll(PageRequest pageRequest);
    Joke like(Integer id);
    Joke dislike(Integer id);
}
