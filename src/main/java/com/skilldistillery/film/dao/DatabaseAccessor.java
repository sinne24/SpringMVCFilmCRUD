package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  public Actor findActorById(int actorId);
  public List<Actor> findActorsByFilmId(int filmId);
  public List<Film> findFilmByKeyword(String keywordChoice);
  public List<Film> findFilmsByActorId(int actorId);
  public Actor findActorByFilmId(int filmId);
  public Actor createActor(Actor actor);
  public boolean saveActor(Actor actor);
  public boolean deleteActor(Actor actor);
}
