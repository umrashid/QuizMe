package application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Leaderboard {
	private Database db = new Database();
	private String userID;
	private String category;
	private String difficulty;
	
	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public String totalPointsCategory(){
		int categoryID = getCategoryID(getCategory());
		String query = String.format("Select * from leaderboard_category_total where userID='%s' and categoryID='%d'", getUserID(), categoryID);
		ResultSet rs = db.runQuery(query);
		try {
			rs.next();
			int totalpoints = rs.getInt("totalpoints");
			System.out.println("TotalPoints is " + totalpoints);
			return Integer.toString(totalpoints);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public String averageScoreCategory(){
		int categoryID = getCategoryID(getCategory());
		String query = String.format("Select * from leaderboard_category_average where userID='%s' and categoryID='%d'", getUserID(), categoryID);
		ResultSet rs = db.runQuery(query);
		try {
			rs.next();
			int averagePoints = rs.getInt("averagePoints");
			System.out.println("Average Points is " + averagePoints);
			return Integer.toString(averagePoints);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String rankCategory(){
		int categoryID = getCategoryID(getCategory());
		String query = String.format("Select * from leaderboard_category_total where categoryID='%d' order by totalpoints DESC", categoryID);
		ResultSet rs = db.runQuery(query);
		try {
			int rank = 1;
			while(rs.next()){
				String username = rs.getString("userID");
				System.out.println(username + " : " + rank);
				if(getUserID().equals(username)){
					return Integer.toString(rank);
				}
				rank++;
			}
			return "N/A";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public String[][] topTenCategory(){
		String[][] results = new String[10][2];
		int categoryID = getCategoryID(getCategory());
		String query = String.format("Select * from leaderboard_category_total where categoryID='%d' order by totalpoints DESC", categoryID);
		ResultSet rs = db.runQuery(query);
		try {
			int rank = 0;
			while(rs.next() && rank < 10){
				String username = rs.getString("userID");
				int totalpoints = rs.getInt("totalpoints");
				results[rank][0] = username;
				results[rank][1] = Integer.toString(totalpoints);
				System.out.println(username + " : " + totalpoints);
				rank++;
			}
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results;
		}
	}
	
	public String totalPointsDifficulty(){
		int difficultyID = getDifficultyID(getDifficulty());
		String query = String.format("Select * from leaderboard_difficulty_total where userID='%s' and difficultyID='%d'", getUserID(), difficultyID);
		ResultSet rs = db.runQuery(query);
		try {
			rs.next();
			int totalpoints = rs.getInt("totalpoints");
			System.out.println("TotalPoints is " + totalpoints);
			return Integer.toString(totalpoints);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public String averageScoreDifficulty(){
		int difficultyID = getDifficultyID(getDifficulty());
		String query = String.format("Select * from leaderboard_difficulty_average where userID='%s' and difficultyID='%d'", getUserID(), difficultyID);
		ResultSet rs = db.runQuery(query);
		try {
			rs.next();
			int averagePoints = rs.getInt("averagePoints");
			System.out.println("Average Points is " + averagePoints);
			return Integer.toString(averagePoints);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String rankDifficulty(){
		int difficultyID = getDifficultyID(getDifficulty());
		String query = String.format("Select * from leaderboard_difficulty_total where difficultyID='%d' order by totalpoints DESC", difficultyID);
		ResultSet rs = db.runQuery(query);
		try {
			int rank = 1;
			while(rs.next()){
				String username = rs.getString("userID");
				System.out.println(username + " : " + rank);
				if(getUserID().equals(username)){
					return Integer.toString(rank);
				}
				rank++;
			}
			return "N/A";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public String[][] topTenDifficulty(){
		String[][] results = new String[10][2];
		int difficultyID = getDifficultyID(getDifficulty());
		String query = String.format("Select * from leaderboard_difficulty_total where difficultyID='%d' order by totalpoints DESC", difficultyID);
		ResultSet rs = db.runQuery(query);
		try {
			int rank = 0;
			while(rs.next() && rank < 10){
				String username = rs.getString("userID");
				int totalpoints = rs.getInt("totalpoints");
				results[rank][0] = username;
				results[rank][1] = Integer.toString(totalpoints);
				System.out.println(username + " : " + totalpoints);
				rank++;
			}
			return results;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results;
		}
	}
	
	
	
	public int getDifficultyID(String difficulty){
		String query = String.format("Select * from difficultylevels where difficultyLevel='%s'", difficulty.trim());
		int difficultyID = 0;
		ResultSet rs = db.runQuery(query);
		try {
			rs.next();
			difficultyID = rs.getInt("difficultyID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Difficulty ID is " + difficultyID);
		return difficultyID;
	}
	
	public int getCategoryID(String category){
		String query = String.format("Select * from categories where CategoryName='%s'", category.trim());
		int categoryID = 0;
		ResultSet rs = db.runQuery(query);
		try {
			rs.next();
			categoryID = rs.getInt("categoryID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Category ID is " + categoryID);
		return categoryID;
	}

}
