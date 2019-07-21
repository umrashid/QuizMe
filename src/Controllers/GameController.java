package Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import application.CategoryGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

public class GameController {
	@FXML
	private Label gameInfo;
	private Label showQuestion;
	private CategoryGame categoryGame = new CategoryGame();
	private String categoryExplanation;
	private String difficultyExplanation;
	
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
	public void goToCategory(ActionEvent event) throws IOException{
		Parent category = FXMLLoader.load(getClass().getResource("/GameDesign/Category.fxml"));
		Scene categoryScene = new Scene(category);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(categoryScene);
		window.show();
	}
	
	public void goToDifficulty(ActionEvent event) throws IOException{
		Parent category = FXMLLoader.load(getClass().getResource("/GameDesign/Difficulty.fxml"));
		Scene categoryScene = new Scene(category);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(categoryScene);
		window.show();
	}
	
	@FXML
	public void goToPlay(ActionEvent event) throws IOException{
		Parent game = FXMLLoader.load(getClass().getResource("/GameDesign/Play.fxml"));
		Scene gameScene = new Scene(game);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(gameScene);
		window.show();
	}
	
	
	
	
}
