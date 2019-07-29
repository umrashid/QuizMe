package Controllers;

import java.io.IOException;

import application.Leaderboard;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LeaderboardController {
	private String userID;
	
	@FXML
	private Label showUsername;
	@FXML
	private Label showRank;
	@FXML
	private Label showTotal;
	@FXML
	private ProgressIndicator averageScoreShow;
	@FXML
	private MenuButton selectCategory;
	@FXML
	private TableView rankTable;
	@FXML
	private TableColumn rankColumn;
	@FXML
	private TableColumn nameColumn;
	@FXML
	private TableColumn totalScoreColumn;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@FXML
	public void LeaderboardCategory(javafx.event.ActionEvent actionEvent) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/Leaderboard.fxml"));
		Parent root = (Parent) loader.load();
		LeaderboardController controller = loader.getController();
		System.out.println("User ID passed to Leaderboard Category: " + getUserID());
		controller.setUserID(getUserID());
		controller.showUsername.setText(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Leaderboard for Category");
		stage.show();
	
	}
	
	public void LeaderboardDifficulty(javafx.event.ActionEvent actionEvent) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameDesign/LeaderboardDifficulty.fxml"));
		Parent root = (Parent) loader.load();
		LeaderboardController controller = loader.getController();
		System.out.println("User ID passed to Leaderboard Difficulty: " + getUserID());
		controller.setUserID(getUserID());
		controller.showUsername.setText(getUserID());
		/*For new window Stage stage = new Stage();*/
		Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // For existing window
		stage.setScene(new Scene(root));
		stage.setTitle("Leaderboard for Difficulty");
		stage.show();
	
	}
	
	@FXML
	public void displayLeaderboardCategory(javafx.event.ActionEvent actionEvent){
		MenuItem menuItem = (MenuItem) actionEvent.getSource();
		String categoryText = menuItem.getText();
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.setUserID(getUserID());
		leaderboard.setCategory(categoryText);
		String totalPoints = leaderboard.totalPointsCategory();
		String averagePoints = leaderboard.averageScoreCategory();
		String rank = leaderboard.rankCategory();
		String[][] topten = leaderboard.topTenCategory();
		selectCategory.setText(categoryText);
		showTotal.setVisible(true);
		showTotal.setText(totalPoints);
		showRank.setVisible(true);
		showRank.setText(rank);
		averageScoreShow.setVisible(true);
		averageScoreShow.setProgress(Double.parseDouble(averagePoints)/50);
		rankColumn.setCellValueFactory( new PropertyValueFactory<Rank,String>("rank"));
		nameColumn.setCellValueFactory( new PropertyValueFactory<Rank,String>("userID"));
		totalScoreColumn.setCellValueFactory( new PropertyValueFactory<Rank,String>("totalPoints"));
		final ObservableList<Rank> data = FXCollections.observableArrayList();
	   for(int i = 0; i < topten.length; i++){
		   String rankString = Integer.toString(i+1); 
		   data.add(new Rank(rankString ,topten[i][0], topten[i][1]));
	   }
			
		rankTable.setItems(data);
	}
	public void displayLeaderboardDifficulty(javafx.event.ActionEvent actionEvent){
		MenuItem menuItem = (MenuItem) actionEvent.getSource();
		String difficultyText = menuItem.getText();
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.setUserID(getUserID());
		leaderboard.setDifficulty(difficultyText);
		String totalPoints = leaderboard.totalPointsDifficulty();
		String averagePoints = leaderboard.averageScoreDifficulty();
		String rank = leaderboard.rankDifficulty();
		String[][] topten = leaderboard.topTenDifficulty();
		selectCategory.setText(difficultyText);
		showTotal.setVisible(true);
		showTotal.setText(totalPoints);
		showRank.setVisible(true);
		showRank.setText(rank);
		averageScoreShow.setVisible(true);
		averageScoreShow.setProgress(Double.parseDouble(averagePoints)/50);
		rankColumn.setCellValueFactory( new PropertyValueFactory<Rank,String>("rank"));
		nameColumn.setCellValueFactory( new PropertyValueFactory<Rank,String>("userID"));
		totalScoreColumn.setCellValueFactory( new PropertyValueFactory<Rank,String>("totalPoints"));
		final ObservableList<Rank> data = FXCollections.observableArrayList();
	   for(int i = 0; i < topten.length; i++){
		   String rankString = Integer.toString(i+1); 
		   data.add(new Rank(rankString ,topten[i][0], topten[i][1]));
	   }
			
		rankTable.setItems(data);
	}
	
	public static class Rank{
		private final SimpleStringProperty rank;
        private final SimpleStringProperty userID;
        private final SimpleStringProperty totalPoints;
          
        private Rank(String rank, String userID, String totalPoints) {
            this.rank = new SimpleStringProperty(rank);
            this.userID = new SimpleStringProperty(userID);
            this.totalPoints = new SimpleStringProperty(totalPoints);
        }
        
        public String getRank(){
        	return rank.get();
        }
        
        public void setRank(String rank){
        	this.rank.set(rank);
        }
        
        public String getUserID(){
        	return userID.get();
        }
        
        public void setUserID(String userID){
        	this.userID.set(userID);
        }
        
        public String getTotalPoints(){
        	return totalPoints.get();
        }
        
        public void setTotalPoints(String totalPoints){
        	this.totalPoints.set(totalPoints);
        }
	

       
		
        
        
	}
}


