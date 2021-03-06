/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.kategorieDAO;
import DAO.podkategorieDAO;
import DAO.producentDAO;
import DAO.produktyDAO;
import DAO.zamowieniaDAO;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Produkty;
import modele.Zamowienia;


public class userPanelController implements Initializable {

    @FXML
    private Tab tabbedProductUser;
    @FXML
    private Label textNameProduct;
    @FXML
    private Label textParamProduct;
    @FXML
    private Label textDescribeProduct;
    @FXML
    private Label textPriceProduct;
    @FXML
    private Label textCatProduct;
    @FXML
    private Label textUnderCatProduct;
    @FXML
    private Label textProducentProduct;
    @FXML
    private ImageView showIMGproduct;
    private ComboBox choseSearch;
    @FXML
    private Button buyingButton;
    @FXML
    private TableView<Produkty> tabProduct;
    @FXML
    private TableColumn<Produkty, String> nameTableProduct;
    @FXML
    private TableColumn<Produkty, String> paramTableProduct;
    @FXML
    private TableColumn<Produkty, String> descTableProduct;
    @FXML
    private TableColumn<Produkty, Float> priceTableProduct;
    @FXML
    private TableColumn<Produkty, String> catTableProduct = new TableColumn<>("kategorie");
    @FXML
    private TableColumn<Produkty, String> underCatTableProduct = new TableColumn<>("podkategorie");
    @FXML
    private TableColumn<Produkty, String> producentTableProduct = new TableColumn<>("producent");
    @FXML
    private Tab tabbedOrdersUsers;
    @FXML
    private Label labelBoughtProduct;
    @FXML
    private Label labelBoughtPrice;
    @FXML
    private Label labelOrderStatus;
    @FXML
    private ImageView showBoughtIMG;
    @FXML
    private TextField searchingBoughtField;
    private ComboBox choseBoughtSearch;
    @FXML
    private TextField searchingField;
    @FXML
    private TableView<Zamowienia> tabBought;
    @FXML
    private TableColumn<Zamowienia, String> prodNameTableBought = new TableColumn<>("produkty");
    @FXML
    private TableColumn<Zamowienia, String> priceTableBought = new TableColumn<>("produkty");
    @FXML
    private TableColumn<Zamowienia, String> statusTableBought;
    @FXML
    private Label valueOrderLabel;
    
    //obiekty DAO, ktore beda manipulować danymi w przyciskach        
    private final kategorieDAO catDAO = new kategorieDAO();
    private final podkategorieDAO underCatDAO = new podkategorieDAO();
    private final producentDAO producentDAO = new producentDAO();
    private final produktyDAO produktyDAO = new produktyDAO();
    private final zamowieniaDAO zamowieniaDAO = new zamowieniaDAO();
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wklejanieProduktu();
        wklejanieZamowienia();
        
        //kupowanie produktu;
        buyingButton.setOnAction((ActionEvent event)->{
            if(tabProduct.getSelectionModel().getSelectedItem() != null){
                Produkty produkt = new Produkty();
                produkt = tabProduct.getSelectionModel().getSelectedItem();
                produktyDAO.buyProduct(produkt);
                tabBought.setItems(FXCollections.observableList(zamowieniaDAO.getAllUser()));
                valueOrderLabel.setText(Float.toString(zamowieniaDAO.ValueOrders()));
                showIMGproduct.setImage(null);
                
            }
        });
        
        //wyswietlanie obok wlasciwosci nacisnietego rekordu w produktach do wyboru
        tabProduct.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Produkty> obs, Produkty oldSelection, Produkty newSelection) -> {
            if (newSelection != null) {
               textNameProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getNazwa_produktu());
               textDescribeProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getOpis_produktu());
               textParamProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getParametry_produktu());
               textPriceProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getCena_produktu().toString());
               textCatProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getPodkategorie().getKategorie().getNazwa_kategorii());
               textUnderCatProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getPodkategorie().getNazwa_podkategorii());
               textProducentProduct.setText(tabProduct.getSelectionModel().getSelectedItem().getProducent().getNazwa_producenta());
               if(tabProduct.getSelectionModel().getSelectedItem().getZdjecie_produktu() != null){
                showIMGproduct.setImage(new Image(new ByteArrayInputStream(tabProduct.getSelectionModel().getSelectedItem().getZdjecie_produktu())));
               }
        }
        });
        
        //wyswietlanie w textfieldach i choiceboxach itp itd nacisnietych wlasciwosci rekordu
        tabBought.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Zamowienia> obs, Zamowienia oldSelection, Zamowienia newSelection) -> {
            if (newSelection != null) {
               labelBoughtProduct.setText(tabBought.getSelectionModel().getSelectedItem().getProdukt().getNazwa_produktu());
               labelBoughtPrice.setText(tabBought.getSelectionModel().getSelectedItem().getProdukt().getCena_produktu().toString());
               labelOrderStatus.setText(tabBought.getSelectionModel().getSelectedItem().getStatus());
        }
        });
        //szukajkaProdukty
        searchingField.setOnKeyReleased(keyEvent ->{
            if("".equals(searchingField.getText())){
                tabProduct.setItems(FXCollections.observableArrayList(produktyDAO.getAll()));
            }else{
                tabProduct.setItems(FXCollections.observableArrayList(produktyDAO.searchingProduct(searchingField.getText())));
            }
        });
        //SzukajkaZamowienia
        searchingBoughtField.setOnKeyReleased(keyEvent ->{
            if("".equals(searchingBoughtField.getText())){
                tabBought.setItems(FXCollections.observableArrayList(zamowieniaDAO.getAllUser()));
            }else{
                tabBought.setItems(FXCollections.observableArrayList(zamowieniaDAO.searchingOrderUser(searchingBoughtField.getText())));
            }
        });
        
        
    }
    
    
    
    
    
    
    private void wklejanieProduktu(){
                 // wyswietlanie w odpowiednich kolumnac tableview odpowiednie wartosci
                nameTableProduct.setCellValueFactory(new PropertyValueFactory<>("nazwa_produktu"));
                paramTableProduct.setCellValueFactory(new PropertyValueFactory<>("parametry_produktu"));
                descTableProduct.setCellValueFactory(new PropertyValueFactory<>("opis_produktu"));
                priceTableProduct.setCellValueFactory(new PropertyValueFactory<>("cena_produktu"));
                //wyswietlanie w kolumnach tableview odpwoiednich wartości, czyli nazwy danych rekordów zamiast referencji do klucza
                catTableProduct.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getPodkategorie().getKategorie().getNazwa_kategorii()));
                underCatTableProduct.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getPodkategorie().getNazwa_podkategorii()));
                producentTableProduct.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getProducent().getNazwa_producenta()));
                tabProduct.setItems(FXCollections.observableList(produktyDAO.getAll()));
            }
    private void wklejanieZamowienia(){
                // wyswietlanie w odpowiednich kolumnac tableview odpowiednie wartosci
                prodNameTableBought.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getProdukt().getNazwa_produktu()));
                priceTableBought.setCellValueFactory(pomoc -> new SimpleStringProperty(pomoc.getValue().getProdukt().getCena_produktu().toString()));
                statusTableBought.setCellValueFactory(new PropertyValueFactory<>("status"));
                valueOrderLabel.setText(Float.toString(zamowieniaDAO.ValueOrders()));
                tabBought.setItems(FXCollections.observableList(zamowieniaDAO.getAllUser()));
            }   
}
