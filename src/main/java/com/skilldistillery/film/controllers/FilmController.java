package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.FilmDaoJdbcImpl;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDaoJdbcImpl filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "home";
	}

	@RequestMapping(path = { "retrieveFilm.do" }, params = "id", method = RequestMethod.GET)
	public ModelAndView retrieveFilm(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int filmID = Integer.parseInt(id);
		mv.addObject("film", filmDao.findFilmById(filmID));

		return mv;
	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(@RequestParam("title") String title, @RequestParam("description") String description, 
		@RequestParam("releaseYear") String releaseYear, @RequestParam("languageId") String languageId,
			@RequestParam("rentalDuration") String rentalDuration, @RequestParam("rentalRate") String rentalRate, 
				@RequestParam("length") String length, @RequestParam("replacementCost") String replacementCost, 
					@RequestParam("rating") String rating, @RequestParam("specialFeatures") String specialFeatures) {
			Film film = new Film();
			
			int year = Integer.parseUnsignedInt(releaseYear);
			int langId = Integer.parseInt(languageId);
			int duration = Integer.parseInt(rentalDuration);
			double rate = Double.parseDouble(rentalRate);
			int len = Integer.parseInt(length);
			double repCost = Double.parseDouble(replacementCost);
			
			film.setTitle(title);
			film.setDescription(description);
			film.setReleaseYear(year);
			film.setLanguageId(langId);
			film.setRentalDuration(duration);
			film.setRentalRate(rate);
			film.setLength(len);
			film.setReplacementCost(repCost);
			film.setRating(rating);
			film.setSpecialFeatures(specialFeatures);
			
			
			ModelAndView mv = new ModelAndView();
						
			mv.addObject("film" , filmDao.createFilm(film));
		
			mv.setViewName("completedAction");
			
			return mv;
		}

	@RequestMapping(path = "confirmation.do", method = RequestMethod.GET)
	public ModelAndView filmCreated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "actionComplete.do", method = RequestMethod.GET)
	public ModelAndView actionComplete() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("completedAction");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("id") String filmId) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(filmId);

		mv.addObject("delete film", filmDao.deleteFilm(id));
		mv.setViewName("completedDelete");
		return mv;
	}
	
	@RequestMapping(path = "retrieveFilmToEdit.do", params = "id", method = RequestMethod.GET)
	public ModelAndView retrieveFilmtoEdit(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultToEdit");
		int filmID = Integer.parseInt(id);
		mv.addObject("film", filmDao.findFilmById(filmID));

		return mv;
	}
	
	@RequestMapping(path = "editFilm.do", method = RequestMethod.POST)
	public ModelAndView editFilm(@RequestParam("title") String title, @RequestParam("description") String description, 
		@RequestParam("releaseYear") String releaseYear, @RequestParam("languageId") String languageId,
			@RequestParam("rentalDuration") String rentalDuration, @RequestParam("rentalRate") String rentalRate, 
				@RequestParam("length") String length, @RequestParam("replacementCost") String replacementCost, 
					@RequestParam("rating") String rating, @RequestParam("specialFeatures") String specialFeatures) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		
		int year = Integer.parseInt(releaseYear);
		int langId = Integer.parseInt(languageId);
		int duration = Integer.parseInt(rentalDuration);
		double rate = Double.parseDouble(rentalRate);
		int len = Integer.parseInt(length);
		double repCost = Double.parseDouble(replacementCost);
		
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(year);
		film.setLanguageId(langId);
		film.setRentalDuration(duration);
		film.setRentalRate(rate);
		film.setLength(len);
		film.setReplacementCost(repCost);
		film.setRating(rating);
		film.setSpecialFeatures(specialFeatures);

		mv.addObject("film", filmDao.editFilm(film));
		mv.setViewName("completedEdit");
		return mv;
	}
}

