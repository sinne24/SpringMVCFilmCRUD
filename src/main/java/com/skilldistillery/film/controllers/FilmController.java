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
		return "WEB-INF/home.jsp";
	}

	@RequestMapping(path = { "retrieveFilm.do" }, params = "id", method = RequestMethod.GET)
	public ModelAndView retrieveFilm(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");
		int filmID = Integer.parseInt(id);
		mv.addObject("film", filmDao.findFilmById(filmID));

		return mv;
	}

	@RequestMapping(path = "createFilm.do", params = "film", method = RequestMethod.POST)
	public ModelAndView createFilm(@RequestParam("title") String title, @RequestParam("description") String description, 
		@RequestParam("releaseYear") String releaseYear, @RequestParam("languageId") String languageId,
			@RequestParam("rentalDuration") String rentalDuration, @RequestParam("rentalRate") String rentalRate, 
				@RequestParam("length") String length, @RequestParam("replacementCost") String replacementCost, 
					@RequestParam("rating") String rating, @RequestParam("specialFeatures") String specialFeatures) { 
		
//					RedirectAttributes redir
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:confirmation.do");
		
		int year = Integer.parseInt(releaseYear);
		int langId = Integer.parseInt(languageId);
		int duration = Integer.parseInt(rentalDuration);
		double rate = Double.parseDouble(rentalRate);
		int len = Integer.parseInt(length);
		double repCost = Double.parseDouble(replacementCost);
		
//		redir.addFlashAttribute("film", filmDao.createFilm(title, description, year, langId, duration, rate,
//				len, repCost, rating, specialFeatures));
		
		mv.addObject("film", filmDao.createFilm(title, description, year, langId, duration, rate,
				len, repCost, rating, specialFeatures));
		return mv;
	}

	@RequestMapping(path = "confirmation.do", method = RequestMethod.GET)
	public ModelAndView filmCreated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}

	@RequestMapping(path = "actionComplete.do", method = RequestMethod.GET)
	public ModelAndView actionComplete() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/completedAction.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", params = "id", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("success", filmDao.deleteFilm(filmId));
		mv.setViewName("redirect:actionComplete.do");
		return mv;
	}

	@RequestMapping(path = "editFilm.do", params = "film", method = RequestMethod.POST)
	public ModelAndView editFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute(filmDao.editFilm(film));
		mv.setViewName("redirect:confirmation.do");
		return mv;
	}
}
