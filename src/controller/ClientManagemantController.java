package controller;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Client;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public class ClientManagemantController implements Initializable {

    public ScrollPane sp_Main;
    public TextField txtMassage;
    public Button btnSend;
    public VBox vboxMassnger;

    private Client client;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
