package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {

		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film.id, film.title, film.description, "
					+ "film.release_year, film.language_id, language.name, "
					+ "film.rental_duration, film.rental_rate, film.length, "
					+ "film.replacement_cost, film.rating, film.special_features "
					+ "FROM film JOIN language ON language.id = film.language_id " + "WHERE film.id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setReleaseYear(rs.getInt("film.release_year"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLanguage(rs.getString("language.name"));
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getDouble("film.rental_rate"));
				film.setLength(rs.getInt("film.length"));
				film.setReplacementCost(rs.getDouble("film.replacement_cost"));
				film.setRating(rs.getString("film.rating"));
				film.setSpecialFeatures(rs.getString("film.special_features"));
				film.setActors(findActorsByFilmId(filmId));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public Actor findActorById(int actorId) {

		Actor actor = null;
		String sql = "SELECT a.id, a.first_name, a.last_name, fa.film_id, "
				+ "film.title FROM actor a JOIN film_actor fa "
				+ "ON fa.actor_id = a.id JOIN film ON film.id = fa.film_id " + "WHERE a.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			ResultSet actorResult = ps.executeQuery();

			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("a.id"));
				actor.setFirst_name(actorResult.getString("a.first_name"));
				actor.setLast_name(actorResult.getString("a.last_name"));
				actor.setFilms(findFilmsByActorId(actorId));
			}
			actorResult.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			String sql = "SELECT a.id, a.first_name, a.last_name, fa.film_id "
					+ "FROM actor a JOIN film_actor fa ON fa.actor_id = a.id "
					+ "JOIN film ON film.id = fa.film_id WHERE film.id = ?";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet actorResult = ps.executeQuery();

			while (actorResult.next()) {
				int id = actorResult.getInt("a.id");
				String firstName = actorResult.getString("a.first_name");
				String lastName = actorResult.getString("a.last_name");

				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			actorResult.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public List<Film> findFilmByKeyword(String keywordChoice) {

		List<Actor> ac = new ArrayList<>();
		List<Film> filmCollection = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film.id, film.title, film.description, film.release_year, "
					+ "film.language_id, language.name, film.rental_duration, film.rental_rate, "
					+ "film.length, film.replacement_cost, film.rating, film.special_features "
					+ "FROM film JOIN language ON language.id = film.language_id "
					+ "WHERE film.title LIKE ? OR film.description LIKE ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keywordChoice + "%");
			ps.setString(2, "%" + keywordChoice + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int filmId = rs.getInt("film.id");
				String title = rs.getString("film.title");
				String description = rs.getString("film.description");
				Integer year = rs.getInt("film.release_year");
				int languageId = rs.getInt("film.language_id");
				String language = rs.getString("language.name");
				int rentalDuration = rs.getInt("film.rental_duration");
				double rentalRate = rs.getDouble("film.rental_rate");
				Integer length = rs.getInt("film.length");
				double replacementCost = rs.getDouble("film.replacement_cost");
				String rating = rs.getString("film.rating");
				String specialFeatures = rs.getString("film.special_features");

				Actor actor = new Actor();
				actor = findActorByFilmId(filmId);
				ac.add(actor);

				Film film = new Film(filmId, title, description, year, languageId, language, rentalDuration, rentalRate,
						length, replacementCost, rating, specialFeatures, ac);
				filmCollection.add(film);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmCollection;
	}

	@Override
	public Actor findActorByFilmId(int filmId) {
		Actor actor = null;

		try {
			String sql = "SELECT a.id, a.first_name, a.last_name, fa.film_id, "
					+ "film.title FROM actor a JOIN film_actor fa "
					+ "ON fa.actor_id = a.id JOIN film ON film.id = fa.film_id " + "WHERE film.id = ?";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet actorResult = ps.executeQuery();

			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("a.id"));
				actor.setFirst_name(actorResult.getString("a.first_name"));
				actor.setLast_name(actorResult.getString("a.last_name"));
				actor.setFilms(findFilmsByActorId(actorResult.getInt("a.id")));
			}
			actorResult.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> filmCollection = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film_actor.film_id, film.title, film.description, film_actor.actor_id, "
					+ "film.release_year, film.language_id, language.name, "
					+ "film.rental_duration, film.rental_rate, film.length, "
					+ "film.replacement_cost, film.rating, film.special_features "
					+ "FROM film JOIN language ON language.id = film.language_id "
					+ "JOIN film_actor ON film.id = film_actor.film_id " + "WHERE film_actor.actor_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int filmId = rs.getInt("film_actor.film_id");
				String title = rs.getString("film.title");
				String description = rs.getString("film.description");
				Integer year = rs.getInt("film.release_year");
				int languageId = rs.getInt("film.language_id");
				String language = rs.getString("language.name");
				int rentalDuration = rs.getInt("film.rental_duration");
				double rentalRate = rs.getDouble("film.rental_rate");
				Integer length = rs.getInt("film.length");
				double replacementCost = rs.getDouble("film.replacement_cost");
				String rating = rs.getString("film.rating");
				String specialFeatures = rs.getString("film.special_features");

				Film film = new Film(filmId, title, description, year, languageId, language, rentalDuration, rentalRate,
						length, replacementCost, rating, specialFeatures);

				filmCollection.add(film);

			}
			rs.close();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmCollection;
	}

	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO actor (first_name, last_name) " + " VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, actor.getFirst_name());
			stmt.setString(2, actor.getFirst_name());

			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();

				if (keys.next()) {
					int newActorId = keys.getInt(1);
					actor.setId(newActorId);

					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);

						for (Film film : actor.getFilms()) {
							stmt.setInt(1, film.getId());
							stmt.setInt(2, newActorId);
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + actor);
		}
		return actor;
	}
	
	public boolean saveActor(Actor actor) {
		  Connection conn = null;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "UPDATE actor SET first_name=?, last_name=? "
		               + " WHERE id=?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, actor.getFirst_name());
		    stmt.setString(2, actor.getLast_name());
		    stmt.setInt(3, actor.getId());
		    
		    int updateCount = stmt.executeUpdate();
		    
		    if (updateCount == 1) {
		      // Replace actor's film list
		      sql = "DELETE FROM film_actor WHERE actor_id = ?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, actor.getId());
		      updateCount = stmt.executeUpdate();
		    
		      sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
		      stmt = conn.prepareStatement(sql);
		      
		      for (Film film : actor.getFilms()) {
		        stmt.setInt(1, film.getId());
		        stmt.setInt(2, actor.getId());
		        updateCount = stmt.executeUpdate();
		      }
		      conn.commit();           // COMMIT TRANSACTION
		    }
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    
		    if (conn != null) {
		      try { 
		    	  conn.rollback(); 
		      } // ROLLBACK TRANSACTION ON ERROR
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
		}
	
	public boolean deleteActor(Actor actor) {
		  Connection conn = null;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    
		    String sql = "DELETE FROM film_actor WHERE actor_id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, actor.getId());
		    
		    int updateCount = stmt.executeUpdate();
		    sql = "DELETE FROM actor WHERE id = ?";
	
		    stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, actor.getId());
		    updateCount = stmt.executeUpdate();
		    conn.commit();             // COMMIT TRANSACTION
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
		}


}
