package Controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
	
	private String userID;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void GameSelection(javafx.event.ActionEvent actionEvent) throws IOException {
//        Parent game;
//        game = FXMLLoader.load(getClass().getResource("/GameDesign/Game.fxml"));
//        Scene gameScene = new Scene(game);
//        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        window.setTitle("Game Selection");
//        window.setScene(gameScene);
//        window.show();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/Game.fxml"));
		Parent root = (Parent) loader.load();
		PlayController controller = loader.getController();
		System.out.println("User ID passed to Game Selection: " + getUserID());
		controller.setUserID(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Game Selection");
		stage.show();
	
	}
	
	public void Leaderboard(javafx.event.ActionEvent actionEvent) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/LeaderboardMenu.fxml"));
		Parent root = (Parent) loader.load();
		LeaderboardController controller = loader.getController();
		System.out.println("User ID passed to Leaderboard: " + getUserID());
		controller.setUserID(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Leaderboard Menu");
		stage.show();
	
	}
	
}
