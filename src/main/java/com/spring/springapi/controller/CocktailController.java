package com.spring.springapi.controller;

import com.spring.springapi.entity.Cocktail;
import com.spring.springapi.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CocktailController {
    private CocktailService cocktailService;

    @Autowired
    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/allcocktails")
    public List<Cocktail> getAllCoctails() {
        return this.cocktailService.getCocktails();
    }

    @PostMapping("/addcocktail")
    public void addCocktail(@RequestBody Cocktail cocktail) {
        this.cocktailService.addCocktail(cocktail);
    }

    @DeleteMapping(path = "/deletecocktail/{name}")
    public void deleteCocktail(@PathVariable("name") String name) {
        this.cocktailService.deleteCocktail(name);
    }

    @PutMapping(path = "/updatecocktail/{id}/{name}")
    public void updateCocktail(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        this.cocktailService.updateCocktail(id, name);
    }
}
