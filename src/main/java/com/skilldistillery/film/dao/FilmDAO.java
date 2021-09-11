package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

		  public Film findFilmById(int filmId);
		  public Actor findActorById(int actorId);
		  public List<Actor> findActorsByFilmId(int filmId);
		  public List<Film> findFilmByKeyword(String keywordChoice);
		  public List<Film> findFilmsByActorId(int actorId);
		  public Actor findActorByFilmId(int filmId);
		  public Actor createActor(Actor actor);
		  public boolean saveActor(Actor actor);
		  public boolean deleteActor(Actor actor);
		  public boolean createFilm(String title, String description, Integer releaseYear, int languageId, int rentalDuration,
					double rentalRate, Integer length, double replacementCost, String rating, String specialFeatures);
		  public boolean deleteFilm(int filmId);
		  public Film editFilm(Film film);
		
		
}
