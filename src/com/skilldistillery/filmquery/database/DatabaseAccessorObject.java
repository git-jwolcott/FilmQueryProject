package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		DatabaseAccessorObject dao = new DatabaseAccessorObject();
//
//	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM film JOIN language ON language.id = film.language_id JOIN film_category ON film_category.film_id = film.id JOIN category ON category.id = film_category.category_id WHERE film.id =?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguage(rs.getString("name"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setCategory(rs.getString("category.name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * from actor WHERE id =?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, actorId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (actor != null) {
			return actor;
		} else {
			return null;
		}
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorList = new ArrayList<Actor>();
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM film JOIN film_actor ON film_actor.film_id = film.id JOIN actor ON actor.id = film_actor.actor_id WHERE film.id =?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				actorList.add(findActorById(rs.getInt("film_actor.actor_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorList;
	}
	
	public List<Film> findFilmByKeyword(String key) {
		List<Film> filmList = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM film JOIN language ON language.id = film.language_id JOIN film_category ON film_category.film_id = film.id JOIN category ON category.id = film_category.category_id WHERE film.title like ? or film.description like ?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setString(1, "%" + key + "%");
			pst.setNString(2, "%" + key + "%");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				int year = rs.getInt("release_year");
				String name = rs.getString("name");
				int rentalDuration = rs.getInt("rental_duration");
				double rentRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				actors = (findActorsByFilmId(rs.getInt("id")));
				String category = rs.getString("category.name");
				Film film = new Film(filmId, title, desc, year, name, rentalDuration, rentRate, length, replacementCost, rating, specialFeatures, actors, category);
				filmList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filmList;
	}

}
