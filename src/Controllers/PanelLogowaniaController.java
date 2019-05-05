/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.uzytkownicyDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Arlen
 */
public class PanelLogowaniaController implements Initializable {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button logInButton;
    private uzytkownicyDAO uzytk = new uzytkownicyDAO();
    @FXML
    private Label badLoginLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        logInButton.setOnAction((ActionEvent event)->{
            if(uzytk.auth(loginField.getText(), passField.getText()) == true){
                try {   
                    Parent application = FXMLLoader.load(getClass().getResource("/projektpo2/ProjektPO2.fxml"));
                    Scene applicationScene = new Scene(application);
                    applicationScene.getStylesheets().add("/CSS/mainApplicationCSS.css");
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(applicationScene);
                    window.setTitle("Baza Danych");
                    window.show();
                } catch (IOException ex) {
                    Logger.getLogger(PanelLogowaniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                badLoginLabel.setText("Zły login lub hasło!");
            }
                                
        });
    }    
    
}
