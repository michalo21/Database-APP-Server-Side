/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.pracownicyDAO;
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
    @FXML
    private Label badLoginLabel;
    
    
    private final uzytkownicyDAO uzyt = new uzytkownicyDAO();
    private final pracownicyDAO prac = new pracownicyDAO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        logInButton.setOnAction((ActionEvent event)->{          
            if(uzyt.authUser(loginField.getText(),passField.getText()) > 0){
                try {
                    Parent application = FXMLLoader.load(getClass().getResource("/projektbazy/userPanel.fxml"));
                    Scene applicationScene = new Scene(application);
                    applicationScene.getStylesheets().add("/CSS/mainApplicationCSS.css");
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(applicationScene);
                    window.setTitle("Sklep Komputerowy, witaj użytkowniku!");
                    window.show();
                } catch (IOException ex) {
                    Logger.getLogger(PanelLogowaniaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(prac.authAdmin(loginField.getText(),passField.getText()) > 0){
               try {
                    Parent application = FXMLLoader.load(getClass().getResource("/projektbazy/adminPanel.fxml"));
                    Scene applicationScene = new Scene(application);
                    applicationScene.getStylesheets().add("/CSS/mainApplicationCSS.css");
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(applicationScene);
                    window.setTitle("Sklep Komputerowy - panel pracownika");
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
