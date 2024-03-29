package Controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import application.CategoryGame;
import application.DifficultyGame;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import application.Score;

public class PlayController {
	@FXML
	private Label gameInfo;
	@FXML
	private Label showQuestion;
	@FXML
	private Label ready;
	@FXML
	private Label startGameLabel;
	@FXML
	private Button choice1;
	@FXML
	private Button choice2;
	@FXML
	private Button choice3;
	@FXML
	private Button choice4;
	@FXML
	private Button startGame;
	@FXML
	private Button viewScore;
	@FXML
	private ProgressBar timer;
	@FXML
	private ImageView logo;
	
	private CategoryGame categoryGame = new CategoryGame();
	private DifficultyGame difficultyGame = new DifficultyGame();
	private String Category;
	private String Difficulty;
	private double Score;
	private String userID;
	private boolean categoryGameOrNot;
	private HashMap<String, String[]> questions;
	private int count = 0;
	
	public HashMap<String, String[]> getQuestions() {
		return questions;
	}

	public void setQuestions(HashMap<String, String[]> questions) {
		this.questions = questions;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}
	
	public double getScore() {
		return this.Score;
	}

	public void setScore(double score) {
		this.Score = score;
	}	
	
	public String getDifficulty() {
		return Difficulty;
	}

	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
	}
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public boolean isCategoryGameOrNot() {
		return categoryGameOrNot;
	}

	public void setCategoryGameOrNot(boolean categoryGameOrNot) {
		this.categoryGameOrNot = categoryGameOrNot;
	}

	@FXML
	public void startGame(){
			showGameMenu();
			String[] oneQuestion = getRandomQuestion();
			count++;
			if(oneQuestion == null || count > 5){
				System.out.println(Score);
				if(isCategoryGameOrNot()){
					Score score = new Score(getUserID(),(int)getScore(),isCategoryGameOrNot(), getCategory());
					score.insertScore();
				}else{
					Score score = new Score(getUserID(),(int)getScore(),isCategoryGameOrNot(), getDifficulty());
					score.insertScore();
				}
				showScoreButton();
				return;
			}
			showLabel(showQuestion, oneQuestion[0]);
			showChoices(oneQuestion[1],oneQuestion[2],oneQuestion[3],oneQuestion[4]);
			Timeline timeline = new Timeline(
			        new KeyFrame(Duration.ZERO, new KeyValue(timer.progressProperty(), 0)),
			        new KeyFrame(Duration.seconds(10), e-> {
			            // do anything you need here on completion...
			        	startGame();
			            System.out.println("10 Seconds over");
			        }, new KeyValue(timer.progressProperty(), 1))    
			    );
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
			choice1.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	timeline.stop();
	               if(choice1.getText().equals(oneQuestion[1])){
	            	   Score = Score + Math.ceil((1 - timer.getProgress())*10);	
	               }
	               startGame();
	            }
	        });
			choice2.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	timeline.stop();
	               if(choice2.getText().equals(oneQuestion[1])){
	            	   Score = Score + Math.ceil((1 - timer.getProgress())*10);	           	   
	               }  
	               startGame();
	            }
	        });
			choice3.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	timeline.stop();
	               if(choice3.getText().equals(oneQuestion[1])){
	            	   Score = Score + Math.ceil((1 - timer.getProgress())*10);		            	   
	               }  
	               startGame();
	            }
	        });
			choice4.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	               timeline.stop();
	               if(choice4.getText().equals(oneQuestion[1])){
	            	   Score = Score + Math.ceil((1 - timer.getProgress())*10);	            	   
	               }  
	               startGame();
	               //System.out.println(Math.ceil((1 - timer.getProgress())*10));
	            }
	        });
			
			
	}
	
	public void wait(int seconds){
		long startTime =System.currentTimeMillis();
		long currentTime =startTime;
		long endTime = startTime+(seconds*1000);
		while(currentTime<endTime){
		    //Do something here
		    currentTime =System.currentTimeMillis();
		    if((endTime-currentTime) % 1000 == 0){
		    	System.out.println(endTime-currentTime);
		    }
		}
	}
	
	public void showLabel(Label showLabel, String message){
		showLabel.setText(message);
	}
	
	public void showGameMenu(){
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
		startGame.setVisible(false);
		ready.setVisible(false);
		startGameLabel.setVisible(false);
		logo.setVisible(false);
		timer.setVisible(true);
	}
	
	public void showChoices(String option1, String option2, String option3, String option4){
		//Show choices at random location
		Random rn = new Random();
		int randomNumber = rn.nextInt(4) + 1;
		switch(randomNumber){
			case 1:
				choice1.setText(option1);
				choice2.setText(option2);
				choice3.setText(option3);
				choice4.setText(option4);
				break;
			case 2:
				choice1.setText(option2);
				choice2.setText(option4);
				choice3.setText(option3);
				choice4.setText(option1);
				break;
			case 3:
				choice1.setText(option1);
				choice2.setText(option4);
				choice3.setText(option2);
				choice4.setText(option3);
				break;
			case 4:
				choice1.setText(option3);
				choice2.setText(option4);
				choice3.setText(option1);
				choice4.setText(option2);
				break;	
		}
		
	}
	
	public String[] getRandomQuestion(){
		// Get a random entry from the HashMap.
		String[] result = new String[5];
		Object[] crunchifyKeys = questions.keySet().toArray();
		System.out.println(crunchifyKeys.length);
		if(crunchifyKeys.length == 0){
			result = null;
			return result;
		}
		Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];	
		System.out.println("\n" + key + " :: " + questions.get(key)[0]);
		result[0] = (String) key;
		result[1] = (String) this.questions.get(key)[0];
		result[2] = (String) questions.get(key)[1];
		result[3] = (String) questions.get(key)[2];
		result[4] = (String) questions.get(key)[3];
		questions.remove(key);
		return result;
		
	}
	
	@FXML
	public void showCategoryGameInfo(){
		gameInfo.setText("Category");
		
	}
	@FXML
	public void showDifficultyGameInfo(){
		gameInfo.setText("Difficulty");
		
	}
	
	@FXML
	public void showClear(){
		gameInfo.setText("");
	}
	
	@FXML
	public void showScoreButton(){
		viewScore.setVisible(true);
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		startGame.setDisable(true);
		startGame.setVisible(false);
		ready.setVisible(true);
		startGameLabel.setVisible(true);
		startGameLabel.setText("Time to see how you did!");
		ready.setText("Game Finished!");
		logo.setVisible(true);
		timer.setVisible(false);
		showQuestion.setVisible(false);
	}
	
	@FXML
	public void goToCategory(ActionEvent event) throws IOException{
//		Parent category = FXMLLoader.load(getClass().getResource("/GameDesign/Category.fxml"));
//		Scene categoryScene = new Scene(category);
//		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//		window.setScene(categoryScene);
//		window.show();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/Category.fxml"));
		Parent root = (Parent) loader.load();
		PlayController controller = loader.getController();
		System.out.println("User ID passed to Category Selection: " + getUserID());
		controller.setUserID(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Category Selection");
		stage.show();
	}
	@FXML
	public void goToDifficulty(ActionEvent event) throws IOException{
//		Parent category = FXMLLoader.load(getClass().getResource("/GameDesign/Difficulty.fxml"));
//		Scene categoryScene = new Scene(category);
//		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//		window.setScene(categoryScene);
//		window.show();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/Difficulty.fxml"));
		Parent root = (Parent) loader.load();
		PlayController controller = loader.getController();
		System.out.println("User ID passed to Difficulty Selection: " + getUserID());
		controller.setUserID(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Difficulty Selection");
		stage.show();
		
	}
	
	@FXML
	public void goToPlayCategory(ActionEvent event) throws IOException{
		Button btn = (Button) event.getSource();
		String categoryText = btn.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/Play.fxml"));
		Parent root = (Parent) loader.load();
		PlayController controller = loader.getController();
		controller.setCategory(categoryText);
		controller.setQuestions(categoryGame.getFiveQuestions(controller.Category));
		controller.setUserID(getUserID());
		controller.setCategoryGameOrNot(true);
		System.out.println("User ID passed to Play Category Game: " + getUserID());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Play");
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	@FXML
	public void goToPlayDifficulty(ActionEvent event) throws IOException{
		Button btn = (Button) event.getSource();
		String diffcultyText = btn.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/Play.fxml"));
		Parent root = (Parent) loader.load();
		PlayController controller = loader.getController();
		controller.setDifficulty(diffcultyText);
		controller.setQuestions(difficultyGame.getFiveQuestions(controller.Difficulty));
		controller.setUserID(getUserID());
		controller.setCategoryGameOrNot(false);
		System.out.println("User ID passed to Play Difficulty Game: " + getUserID());
		//For new window Stage stage = new Stage();
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Play");
		stage.show();
	}
	
	@FXML
	public void goToScore(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/DisplayScore.fxml"));
		Parent root = (Parent) loader.load();
		ScoreController controller = loader.getController();
		System.out.println("Play Controller has score: " + getScore());
		controller.setScore(getScore());
		controller.showScore();
		controller.setUserID(getUserID());
		System.out.println("User ID passed to Score Controller: " + getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Score");
		stage.show();
	}
	
	public void MainMenu(javafx.event.ActionEvent actionEvent) throws IOException {
//      Parent mainmenu;
//      mainmenu = FXMLLoader.load(getClass().getResource("/GameDesign/MainMenu.fxml"));
//      Scene mainMenuScreen = new Scene(mainmenu);
//      Stage window1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//      window1.setTitle("Main Menu");
//      window1.setScene(mainMenuScreen);
//      window1.show();
      
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/MainMenu.fxml"));
		Parent root = (Parent) loader.load();
		MainMenuController controller = loader.getController();
		System.out.println("User ID passed to Main Menu: " + getUserID());
		controller.setUserID(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Main Menu");
		stage.show();

  }


	
}