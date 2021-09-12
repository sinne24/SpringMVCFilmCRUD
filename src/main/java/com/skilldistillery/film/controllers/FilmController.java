package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDaoJdbcImpl;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDaoJdbcImpl filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/home.jsp";
	}

	// @RequestMapping(path = "GetStateData.do", params = "name", method =
	// RequestMethod.GET)
	// public ModelAndView stateMethod(@RequestParam("name") String n) {

	@RequestMapping(path = { "retrieveFilm.do" }, params = "id", method = RequestMethod.GET)
	public ModelAndView retrieveFilm(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");

		int filmID = Integer.parseInt(id);
		mv.addObject("film", filmDao.findFilmById(filmID));

		return mv;

	}

	@RequestMapping(path = "createFilm.do",
            params = "film",
            method = RequestMethod.POST)
public ModelAndView createFilm(String title, String description, Integer releaseYear, int languageId, int rentalDuration,
		double rentalRate, Integer length, double replacementCost, String rating, String specialFeatures){
ModelAndView mv = new ModelAndView();
mv.setViewName("redirect:confirmation.do");
mv.addObject("film", filmDao.createFilm(title, description, releaseYear, languageId, rentalDuration,
				rentalRate, length, replacementCost, rating, specialFeatures));
      return mv;
}

	@RequestMapping(path = "confirmation.do", method = RequestMethod.GET)
	public ModelAndView filmCreated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/confirmation.jsp");
		return mv;
	}

	@RequestMapping(path = "actionComplete.do", method = RequestMethod.GET)
	public ModelAndView actionComplete() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/completedAction.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", params = "id", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:actionComplete.do");
		mv.addObject(filmDao.deleteFilm(filmId));
		return mv;
	}

	@RequestMapping(path = "editFilm.do", params = "film", method = RequestMethod.POST)
	public ModelAndView editFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:confirmation.do");
		mv.addObject(filmDao.editFilm(film));
		return mv;
	}

}
