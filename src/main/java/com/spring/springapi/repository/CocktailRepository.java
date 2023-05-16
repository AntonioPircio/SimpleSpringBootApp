package com.spring.springapi.repository;

import com.spring.springapi.entity.Cocktail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {

    @Query ("SELECT c from  Cocktail c where c.name = :name")
    Optional<Cocktail> findCocktailByName(String name);

    @Query ("SELECT c from Cocktail c where c.ID = :id")
    Optional<Cocktail> findCocktailBYID(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cocktail c WHERE c.name = :name")
    void deleteByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query ("UPDATE Cocktail c SET c.name = :name where c.ID = :id")
    void updateCocktail(@Param("id") Integer id,@Param("name") String name);




}
