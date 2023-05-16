package com.spring.springapi.service;

import com.spring.springapi.entity.Cocktail;
import com.spring.springapi.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocktailService {
    private final CocktailRepository cocktailRepository;

    @Autowired
    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;

    }

    public List<Cocktail> getCocktails() {
        return this.cocktailRepository.findAll();
    }

    public void addCocktail(Cocktail cocktail) {
        Optional<Cocktail> coktailOptional = this.cocktailRepository.findCocktailByName(cocktail.getName());
        if (coktailOptional.isPresent()) {
            throw new IllegalStateException("COCKTAIL ALREADY INSERTED");
        }
        this.cocktailRepository.save(cocktail);
    }

    public void deleteCocktail(String name) {
        Optional<Cocktail> cocktailOptional = this.cocktailRepository.findCocktailByName(name);
        if (cocktailOptional.isPresent()) {
            this.cocktailRepository.deleteByName(name);
        } else {
            throw new IllegalStateException("COCKTAIL DOES NOT EXIXST");
        }
    }

    public void updateCocktail(Integer id, String name) {
        Optional<Cocktail> cocktailOptional = this.cocktailRepository.findCocktailBYID(id);
        if (cocktailOptional.isPresent()) {
            this.cocktailRepository.updateCocktail(id,name);
        } else {
            throw new IllegalStateException("COCKTAIL NOT PRESENT");
        }
    }


}
