import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;


public class DatabaseConnector {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = DatabaseCredentials.DB_URL;
	private static final String USERNAME = DatabaseCredentials.USERNAME;
	private static final String PASSWORD = DatabaseCredentials.PASSWORD;
	
	private Connection conn = null;
	private Statement stm = null;
	
	public final List<String> GetGenres() {
		List<String> result = new ArrayList<String>();
		
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			
			String query = "SELECT DISTINCT genre FROM movie ORDER BY genre ASC";
			
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				result.add(rs.getString("genre"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
		return result;
	}

	public final List<Movie> getMovie(String title, String genre, String rating) {
		List<Movie> listMovie = new ArrayList<Movie>();

		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			String query;
			
			if(genre != "All" && rating != "Rating") {
				query = "SELECT * FROM movie WHERE title LIKE '%" + title + "%' AND genre='" + genre + "' AND rating>"+rating;
			} else if(genre == "All" && rating != "Rating") {
				query = "SELECT * FROM movie WHERE title LIKE '%" + title + "%' AND rating>"+rating;
			} else if(genre != "All" && rating == "Rating") {
				query = "SELECT * FROM movie WHERE title LIKE '%" + title + "%' AND genre='" + genre + "'";
			} else {
				query = "SELECT * FROM movie WHERE title LIKE '%" + title + "%'";
			}
			
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				Movie m = new Movie();
				m.id			= rs.getInt("idmovie");
				m.title 		= rs.getString("title");
				m.genre 		= rs.getString("genre");
				m.plot 			= rs.getString("plot");
				m.rating 		= rs.getString("rating");
				m.director		= rs.getString("director");
				m.release_date	= rs.getString("release_date");
				m.runtime		= rs.getInt("runtime");
				listMovie.add(m);
			}
		} 
		catch(Exception e) { e.printStackTrace(); }
		finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) { sqlex.printStackTrace(); }
		}
 		return listMovie;
	}

	public final String[] getMovieDetails(int id) {
		String[] results = new String[8];
		
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM movie WHERE idmovie='" + id + "'");
			
			while(rs.next()) {
				results[1] = rs.getString(2);
				results[2] = rs.getString(3);
				results[3] = rs.getString(4);
				results[4] = rs.getString(5);
				results[5] = rs.getString(6);
				results[6] = rs.getString(7);
				results[7] = rs.getString(8);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
		return results;
	}
	
	public final Movie getMovieDetailsList(int id) {
		Movie m = new Movie();
		
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM movie WHERE idmovie='" + id + "'");
			
			while(rs.next()) {
				m.id			= rs.getInt("idmovie");
				m.title			= rs.getString("title");
				m.genre			= rs.getString("genre");
				m.plot			= rs.getString("plot");
				m.rating		= rs.getString("rating");
				m.director		= rs.getString("director");
				m.release_date	= rs.getString("release_date");
				m.runtime		= rs.getInt("runtime");
				m.imagepath		= rs.getString("image");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
		return m;
	}

	public final boolean updateMovieDetails(Movie m) {
		boolean success = false;
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			String query = "UPDATE `guproject`.`movie`" + "SET title='" + m.title + "' ,rating='" + m.rating + "',genre='" + m.genre + "',director='" + m.director + "'" + ",plot='" + m.plot + "',runtime='" + m.runtime + "',release_date='" + m.release_date + "',image='" + m.imagepath + "' WHERE idmovie='" + m.id + "'";
			stm.executeUpdate(query);
			success = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
		return success;
	}
	
	
	public final boolean DeleteMovie(Movie m) {
		boolean success = false;
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			String query = "DELETE FROM `guproject`.`movie` WHERE title = '"+ m.title+"'";
			stm.executeUpdate(query);
			success = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
		return success;
	}

	public final boolean insertMovie(Movie m) {
		boolean success = false;
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			String query = "INSERT INTO `movie` (`idmovie`, `title`, `rating`, `genre`, `director`, `plot`, `runtime`, `release_date`, `image`) VALUES (NULL, '"
					+ m.title
					+ "', '"
					+ m.rating
					+ "', '"
					+ m.genre
					+ "', '"
					+ m.director
					+ "', '"
					+ m.plot
					+ "', '"
					+ m.runtime
					+ "', '"
					+ m.release_date
					+ "', '"
					+ m.imagepath + "')";
			
			stm.executeUpdate(query);
			success = true;
		} catch (Exception e) {
			// Maybe log errors to file?
		} finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch (SQLException sqlex) {
				// Maybe log errors to file?
			}
		}
		return success;
	}

	public final List<Comment> getComments(int mid) {
		List<Comment> listComment = new ArrayList<Comment>();
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			stm = conn.createStatement();
			
			String query = "SELECT idmovie,cid, username, comment FROM comments LEFT JOIN movie USING (idmovie) WHERE idmovie='"+mid+"'";
			
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				Comment c  = new Comment();
				c.mid = rs.getInt("idmovie");
				c.cid = rs.getInt("cid");
				c.name = rs.getString("username");
				c.text = rs.getString("comment");
				listComment.add(c);
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		finally {
			try {
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch(SQLException sqlex) { sqlex.printStackTrace(); }
		}
		return listComment;
	}
}
