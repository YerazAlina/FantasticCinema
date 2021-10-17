package nl.inholland.javafx.UI;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage loginScreen) throws Exception {
        loginScreen.setHeight(210);
        loginScreen.setWidth(290);
        loginScreen.setTitle("Login");

        //labels and fields
        Label usernameLabel = new Label("Username"); //
        TextField usernameInput = new TextField(); //
        usernameInput.setPromptText("username");
        Label passwordLabel = new Label("Password"); //
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("password");

        //password field only show the button if....
        String password = passwordInput.getText();

        //button
        Button loginButton = new Button("Log in");
        loginButton.setVisible(false);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(checkPassword(passwordInput.getText()))
                {
                    //todo: mainwindow?
                }
            }
        });

        //grid
        GridPane gridPane = new GridPane();
        //makes sure that grid is not touching the border
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10); // Vertical spacing between grid items
        gridPane.setHgap(8); // Horizontal spacing between grid items

        //adding label to grid
        GridPane.setConstraints(usernameLabel, 0, 0); // first column, first row
        GridPane.setConstraints(usernameInput, 1, 0); // second column, first row
        GridPane.setConstraints(passwordLabel, 0, 1); // first column, second row
        GridPane.setConstraints(passwordInput, 1, 1); // second column, second row //is this correct?

        GridPane.setConstraints(loginButton, 1, 2); // Right align in the grid
        gridPane.getChildren().addAll(usernameLabel, passwordLabel, usernameInput, passwordInput, loginButton);

        Scene scene = new Scene(gridPane);
        loginScreen.setScene(scene);

        loginScreen.show();
    }


    private Boolean checkPassword(String password) {
        Boolean containsLetter = false;
        Boolean containsSpecialChar = false;
        Boolean containsDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)){
                containsDigit = true;
            }
            else if (Character.isAlphabetic(c)){
                containsLetter = true;
            }
            else{
                containsSpecialChar = true;
            }
        }
        return password.length() > 7 && (containsDigit && containsLetter && containsSpecialChar);
    }
}

