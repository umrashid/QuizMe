package Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.w3c.dom.events.EventListener;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.NewUser;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.EventObject;

public class LoginController{
	//Username and Password fields for login
    @FXML
    private JFXTextField userNameLogin;
    @FXML
    private JFXPasswordField passwordLogin;
    
    //Create User Fields for creating a user
    @FXML
    private JFXTextField usernameCreate;
	@FXML
    private JFXTextField firstNameCreate;
    @FXML
    private JFXTextField lastNameCreate;
    @FXML
    private JFXTextField emailCreate;
    @FXML
    private JFXPasswordField passwordCreate;
    @FXML
    private Label message;
    
    /* ----------------------------- Getters and Setters ------------------------------------------*/
    public JFXTextField getUserNameLogin() {
		return userNameLogin;
	}

	public void setUserNameLogin(JFXTextField userNameLogin) {
		this.userNameLogin = userNameLogin;
	}

	public JFXPasswordField getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(JFXPasswordField passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	
	@FXML
	public JFXTextField getUsernameCreate() {
		return usernameCreate;
	}

	public void setUsernameCreate(JFXTextField usernameCreate) {
		this.usernameCreate = usernameCreate;
	}

	public JFXTextField getFirstNameCreate() {
		return firstNameCreate;
	}

	public void setFirstNameCreate(JFXTextField firstNameCreate) {
		this.firstNameCreate = firstNameCreate;
	}

	public JFXTextField getLastNameCreate() {
		return lastNameCreate;
	}

	public void setLastNameCreate(JFXTextField lastNameCreate) {
		this.lastNameCreate = lastNameCreate;
	}

	public JFXTextField getEmailCreate() {
		return emailCreate;
	}

	public void setEmailCreate(JFXTextField emailCreate) {
		this.emailCreate = emailCreate;
	}

	public JFXPasswordField getPasswordCreate() {
		return passwordCreate;
	}

	public void setPasswordCreate(JFXPasswordField passwordCreate) {
		this.passwordCreate = passwordCreate;
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}
    
    /*----------------------------------------------------------------------------------------------*/
    
//    // The Create user fields //
//    private TextField userName;
//    private TextField firstName;
//    private TextField lastName;
//    private TextField email;
//    private PasswordField password;
//    private Button logInButton;
//    private Label bottomLabel;

    
   

	public void SignUpScene(javafx.event.ActionEvent actionEvent) throws IOException {

            Parent SignUp;
            SignUp = FXMLLoader.load(getClass().getResource("/LoginDesign/NewUser.fxml"));
            Scene loginScene = new Scene(SignUp);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();

    }

    

	public void LoginScene(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent login;
        login = FXMLLoader.load(getClass().getResource("/GameDesign/logIn.fxml"));
        Scene loginScene1 = new Scene(login);
        Stage window1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window1.setScene(loginScene1);
        window1.show();

    }
    
    @FXML
    public void addUser() {
    	if(checkEmptyFieldsShowError() == false){
    		hideMessage();
    		application.NewUser newUser = new application.NewUser(usernameCreate.getText(), passwordCreate.getText(), firstNameCreate.getText(), lastNameCreate.getText(), emailCreate.getText());
    		if(newUser.createUser()){
    			showMessage("Account Creation Successful.");
    		}else{
    			showMessage("Account Creation Unsuccessful! User already exists");
    		}
    	}
    }


    public void logUserIn(javafx.event.ActionEvent actionEvent) throws IOException {
        application.ExistingUser ExistingUser = new application.ExistingUser(getUserNameLogin().getText(), getPasswordLogin().getText());
        if(ExistingUser.verifyPassword()){
            Parent Game;
            Game = FXMLLoader.load(getClass().getResource("/GameDesign/Game.fxml"));
            Scene loginScene1 = new Scene(Game);
            Stage window2 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window2.setScene(loginScene1);
            window2.show();

        }
    }
    
    public boolean checkEmptyFieldsShowError(){
    	
	 	if(getUsernameCreate().getText().equals("") || getUsernameCreate().getText().equals(null)){
	 		showMessage("Missing Field: Username");
	 		return true;
	 	}else if(getFirstNameCreate().getText().equals("") || getFirstNameCreate().getText().equals(null)){
	 		showMessage("Missing Field: First Name");
	 		return true;
	 	}else if(getLastNameCreate().getText().equals("") || getLastNameCreate().getText().equals(null)){
	 		showMessage("Missing Field: Last Name");
	 		return true;
	 	}else if(getEmailCreate().getText().equals("") || getEmailCreate().getText().equals(null)){
	 		showMessage("Missing Field: Email");
	 		return true;
	 	}else if(getPasswordCreate().getText().equals("") || getPasswordCreate().getText().equals(null)){
	 		showMessage("Missing Field: Password");
	 		return true;
	 	}else{
	 		return false;
	 	}
    }
    
    public void showMessage(String message){
    	this.message.setVisible(true);
    	this.message.setText(message);
    }
    
    public void hideMessage(){
    	this.message.setVisible(false);
    	this.message.setText("");
    }


}
