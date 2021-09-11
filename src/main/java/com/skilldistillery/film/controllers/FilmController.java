package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDaoJdbcImpl;

@Controller 
public class FilmController {
	
	@Autowired 
	private FilmDaoJdbcImpl filmDao;
	
	@RequestMapping( path = {"/","home.do"} )
	public String home() {
		return"WEB-INF/home.jsp";
	}

	//@RequestMapping(path = "GetStateData.do", params = "name", method = RequestMethod.GET)
	//public ModelAndView stateMethod(@RequestParam("name") String n) {
	
	@RequestMapping( path = {"retrieveFilm.do"}, params = "id", method = RequestMethod.GET)
	public ModelAndView retrieveFilm(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");

		int filmID = Integer.parseInt(id);
		mv.addObject("film", filmDao.findFilmById(filmID));
		
		return mv;
	}
}
