package com.croz.vicevi.persistence.repository;

import com.croz.vicevi.persistence.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JokeRepository extends JpaRepository<Joke, Integer> {

}
