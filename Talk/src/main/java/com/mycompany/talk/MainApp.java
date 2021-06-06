package com.mycompany.talk;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Hi My Name is Muhammad Gulraiz. Testing My Chat Application 
public class MainApp extends Application {
   public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        
        //change
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/chatScreen.fxml"));
        
         Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Chat Application");
        stage.setScene(scene);
        stage.show();
        
        
        
    }

   
    public static void main(String[] args) {
        launch(args);
        
    }

}
