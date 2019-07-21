package Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import application.CategoryGame;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayController {
	
	@FXML
	private Label showQuestion;
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
	private ProgressBar timer;
	@FXML
	private CategoryGame categoryGame = new CategoryGame();
	private double Score ;
	
	public double getScore() {
		return this.Score;
	}

	public void setScore(double score) {
		this.Score = score;
	}

	private HashMap<String, String[]> questions = categoryGame.getQuestions();
	
	
	@FXML
	public void startGame(){
			showGameMenu();
			String[] oneQuestion = getRandomQuestion();
			if(oneQuestion == null){
				System.out.println(Score);
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
		timer.setVisible(true);
	}
	
	public void showChoices(String option1, String option2, String option3, String option4){
		choice1.setText(option1);
		choice2.setText(option2);
		choice3.setText(option3);
		choice4.setText(option4);
		
	}
	
	public String[] getRandomQuestion(){
		// Get a random entry from the HashMap.
		String[] result = new String[5];
		Object[] crunchifyKeys = questions.keySet().toArray();
		//System.out.println(crunchifyKeys.length);
		if(crunchifyKeys.length == 0){
			result = null;
			return result;
		}
		Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
		System.out.println("\n" + key + " :: " + questions.get(key)[0]);
		result[0] = (String) key;
		result[1] = (String) questions.get(key)[0];
		result[2] = (String) questions.get(key)[1];
		result[3] = (String) questions.get(key)[2];
		result[4] = (String) questions.get(key)[3];
		questions.remove(key);
		return result;
		
	}
	

	
}