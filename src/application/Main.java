package application;
	
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/LoginDesign/Confirmation.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Game Selection");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		Database db = new Database();
//		ResultSet rs = db.runQuery("select * from users");
//		try {
//			while(rs.next()){
//			     //Retrieve by column name
//			     String id  = rs.getString("userid");
//  
//			     //Display values
//			     System.out.println("ID: " + id);
//			  }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ExistingUser user = new ExistingUser("player5","hello");
		user.verifyPassword();
		launch(args);
		
		
		
	}
}
