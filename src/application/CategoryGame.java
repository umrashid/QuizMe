package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class CategoryGame {
	private Database db = new Database();
	
	public HashMap<String, String[]> getQuestions(){
		HashMap<String, String[]> hmap = new HashMap<String, String[]>();
		hmap.put("What is the capital of Canada?", new String[]{"Ottawa", "Vancouver", "Toronto", "Regina"});
		hmap.put("What is the capital of USA?", new String[]{"Washington DC", "Chicago", "Los Angeles", "New York"});
		hmap.put("What is the capital of UK?", new String[]{"London", "Manchester", "Liverpool", "Birmingham"});
		return hmap;
		
		
		
	}
	
	public HashMap<String, String[]> getQuestions(String category){
		HashMap<String, String[]> hmap = new HashMap<String, String[]>();
		String query = String.format("Select * from questions where categoryID='%d" , getCategoryID(category));
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
		return categoryID;
	}
}
