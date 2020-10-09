package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
//	
//	public public DatabaseAccessorObject() throws ClassNotFoundException {
//	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DatabaseAccessorObject dao = new DatabaseAccessorObject();

	}

	@Override
	public Film findFilmById(int filmId) throws SQLException{
		Film film = null;
		String user = "student";
		String pass = "student";
		String sqlText = "SELECT * FROM film WHERE film.id =?";
		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement pst = conn.prepareStatement(sqlText);
				ResultSet rs = pst.executeQuery();) {
				pst.setInt(1, filmId);

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.settitle(rs.getString("first_name"));
				film.setLastName(rs.getString("last_name"));
				sb.append(" ");
				System.out.println(sb.toString());
				sb.delete(0, sb.length());
			}
		}
		return null;
	}

	public Actor findActorById(int actorId) {
		return null;
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		return null;
	}

}
