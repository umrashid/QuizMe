package application;

import java.util.HashMap;

public class CategoryGame {
	public HashMap<String, String[]> getQuestions(){
		HashMap<String, String[]> hmap = new HashMap<String, String[]>();
		hmap.put("What is the capital of Canada?", new String[]{"Ottawa", "Vancouver", "Toronto", "Regina"});
		hmap.put("What is the capital of USA?", new String[]{"Washington DC", "Chicago", "Los Angeles", "New York"});
		hmap.put("What is the capital of UK?", new String[]{"London", "Manchester", "Liverpool", "Birmingham"});
		return hmap;
	}
}
