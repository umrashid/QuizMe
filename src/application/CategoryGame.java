package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


public class CategoryGame {
	private Database db = new Database();
	
	
	public HashMap<String, String[]> getQuestions(String category){
		HashMap<String, String[]> hmap = new HashMap<String, String[]>();
		String query = String.format("Select * from question where categoryID= %d" , getCategoryID(category));
		ResultSet rs = db.runQuery(query);
		try {
			while(rs.next()){
				String question = rs.getString("question");
				String[] options = new String[4];
				options[0] = rs.getString("correct");
				options[1] = rs.getString("option1");
				options[2] = rs.getString("option2");
				options[3] = rs.getString("option3");
				hmap.put(question, options);
				
			}
		} catch (SQLException e) {
			
		}
		
		return hmap;
		
	}
	
	public HashMap<String, String[]> getFiveQuestions(String category){
		HashMap<String, String[]> hmap = new HashMap<String, String[]>();
		String query = String.format("Select * from question where categoryID= %d" , getCategoryID(category));
		ResultSet rs = db.runQuery(query);
		try {
			while(rs.next()){
				String question = rs.getString("question");
				String[] options = new String[4];
				options[0] = rs.getString("correct");
				options[1] = rs.getString("option1");
				options[2] = rs.getString("option2");
				options[3] = rs.getString("option3");
				hmap.put(question, options);
				
			}
		} catch (SQLException e) {
			
		}
		return randomFive(hmap);
		
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
	
	
	public HashMap<String, String[]> randomFive(HashMap<String, String[]> questions){
		HashMap<String, String[]> result = new HashMap<String, String[]>();
		ArrayList<String>  toBeShuffled = new ArrayList<String>(); 
		Set<String> allQuestionKeys = questions.keySet();
		for (String keys: allQuestionKeys){
			toBeShuffled.add(keys);
			System.out.println(keys);
		}
		Collections.shuffle(toBeShuffled);
		for (int i = 0; i < 5; i++){
			String questionKey = toBeShuffled.get(i);
			System.out.println(questionKey);
			result.put(questionKey, questions.get(questionKey));
		}
		return result;
	}
}
