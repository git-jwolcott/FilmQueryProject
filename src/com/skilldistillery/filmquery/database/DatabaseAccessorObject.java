package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.InventoryItem;
import com.skilldistillery.filmquery.entities.Language;

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
		String sqlText = "SELECT * FROM film " + "JOIN language ON language.id = film.language_id "
				+ "JOIN film_category ON film_category.film_id = film.id "
				+ "JOIN category ON category.id = film_category.category_id WHERE film.id =?";
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
				film.setLanguage(findLanguageByFilmId(filmId));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setCategory(findCategoryByFilmId(filmId));
				film.setInventoryItem(findInventoryItemByFlimId(filmId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	public Language findLanguageByFilmId(int filmId) {
		Language lang = null;
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM film JOIN language ON language.id = film.language_id WHERE film.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				lang = new Language();
				lang.setId(rs.getInt("id"));
				lang.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lang;
	}

	public Category findCategoryById(int categoryId) {
		Category cat = null;
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM category WHERE id =?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, categoryId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (cat != null) {
			return cat;
		} else {
			return null;
		}

	}

	public List<Category> findCategoryByFilmId(int filmId) {
		List<Category> categoryList = new ArrayList<>();
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM film JOIN film_category ON film_category.film_id = film.id JOIN category ON category.id = film_category.category_id WHERE film.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				categoryList.add(findCategoryById(rs.getInt("category.id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;

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
				actorList.add(findActorById(rs.getInt("actor.id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorList;
	}

	public List<Film> findFilmByKeyword(String key) {
		List<Film> filmList = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();
		Language language = null;
		List<Category> category = new ArrayList<>();
		List<InventoryItem> item = new ArrayList<>();
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
				String desc;
				if (rs.getString("description") == null) {
					desc = "Unknown";
				} else {
					desc = rs.getString("description");
				}
				int year;
				if (rs.getInt("release_year") == 0) {
					year = 9999;
				} else {
					year = rs.getInt("release_year");
				}
				language = (findLanguageByFilmId(rs.getInt("id")));
				int rentalDuration = rs.getInt("rental_duration");
				double rentRate = rs.getDouble("rental_rate");
				int length;
				if (rs.getInt("length") == 0) {
					length = 9999;
				} else {
					length = rs.getInt("length");
				}
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures;
				if(rs.getString("special_features") == null){
					specialFeatures = "Unknown";
				}
				else {
					specialFeatures = rs.getNString("special_features");
				}
				actors = (findActorsByFilmId(rs.getInt("id")));
				category = (findCategoryByFilmId(rs.getInt("id")));
				item = (findInventoryItemByFlimId(rs.getInt("id")));
				Film film = new Film(filmId, title, desc, year, language, rentalDuration, rentRate, length,
						replacementCost, rating, specialFeatures, actors, category, item);
				filmList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return filmList;
	}

	public InventoryItem findInventoryItemById(int inventoryItemId) {
		InventoryItem item = null;
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM inventory_item WHERE inventory_item.id = ?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, inventoryItemId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				item = new InventoryItem();
				item.setId(rs.getInt("id"));
				if (rs.getString("media_condition") == null) {
					item.setMediaCondition("Unknown");
				} else {
					item.setMediaCondition(rs.getString("media_condition"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (item != null) {
			return item;
		} else {
			return null;
		}

	}

	@Override
	public List<InventoryItem> findInventoryItemByFlimId(int filmId) {
		List<InventoryItem> inventoryList = new ArrayList<>();
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM inventory_item LEFT JOIN film ON film.id = inventory_item.film_id WHERE film.id =?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);) {

			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				inventoryList.add(findInventoryItemById(rs.getInt("inventory_item.id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inventoryList;

	}

}
