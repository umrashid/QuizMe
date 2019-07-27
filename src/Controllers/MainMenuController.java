package Controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
	
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
