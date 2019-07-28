package Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ScoreController {
	
	@FXML
	private Label showScore;
	
	private double Score;
	
	public Label getShowScore() {
		return showScore;
	}
	public void setShowScore(Label showScore) {
		this.showScore = showScore;
	}
	public double getScore() {
		return Score;
	}
	public void setScore(double score) {
		this.Score = score;
	}
	
	public void showScore(){
		System.out.println("Score in score controller is: " + getScore());
		showScore.setText(Double.toString(getScore()));
	}
	
	
	public void MainMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent mainmenu;
        mainmenu = FXMLLoader.load(getClass().getResource("/GameDesign/MainMenu.fxml"));
        Scene mainMenuScreen = new Scene(mainmenu);
        Stage window1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window1.setTitle("Main Menu");
        window1.setScene(mainMenuScreen);
        window1.show();

    }
	
	public void GameSelection(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent game;
        game = FXMLLoader.load(getClass().getResource("/GameDesign/Game.fxml"));
        Scene gameScene = new Scene(game);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setTitle("Game Selection");
        window.setScene(gameScene);
        window.show();
	
	}
	

	
	
	

}
