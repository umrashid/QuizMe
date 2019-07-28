package application;

public class Score {
	private String userID;
	private int Score;
	private String category;
	private String difficulty;
	private boolean categoryGameOrNot;
	private Database db;
	private DifficultyGame difficultyGame;
	private CategoryGame categoryGame;
	
	public Score(String userID, int Score, boolean categoryGameOrNot, String value){
		this.userID = userID;
		this.Score = Score;
		this.categoryGameOrNot = categoryGameOrNot;
		if(categoryGameOrNot){
			this.category = value;
		}else{
			this.difficulty = value;
		}
		db = new Database();
		difficultyGame = new DifficultyGame();
		categoryGame = new CategoryGame();
		
	}
	
	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public int getScore() {
		return Score;
	}


	public void setScore(int score) {
		Score = score;
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


	public boolean isCategoryGameOrNot() {
		return categoryGameOrNot;
	}


	public void setCategoryGameOrNot(boolean categoryGameOrNot) {
		this.categoryGameOrNot = categoryGameOrNot;
	}


	public Database getDb() {
		return db;
	}


	public void setDb(Database db) {
		this.db = db;
	}


	public boolean insertScore(){
		
		if(isCategoryGameOrNot()){
			int categoryID = categoryGame.getCategoryID(getCategory());
			String insertUser = String.format("INSERT INTO scorecategory(userID, score, categoryID) VALUES('%s','%d','%d')", getUserID(), getScore(), categoryID);
			if(db.changeQuery(insertUser)){
				System.out.println("Category Score Inserted: \nUserID: " + getUserID()+ "\nScore: " + getScore());
				return true;
			}else{
				System.out.println("Category Score wasn't inserted in the database!");
				return false;
			}
		}else{
			int difficultyID = difficultyGame.getDifficultyID(getDifficulty());
			String insertUser = String.format("INSERT INTO scoredifficulty(userID, score, difficultyID) VALUES('%s','%d','%d')", getUserID(), getScore(), difficultyID);
			if(db.changeQuery(insertUser)){
				System.out.println("Difficulty Score Inserted: \nUserID: " + getUserID()+ "\nScore: " + getScore());
				return true;
			}else{
				System.out.println("Difficulty Score wasn't inserted in the database!");
				return false;
			}
		}
	}
}
