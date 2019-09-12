package banque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ClientController {
    public ObservableList<String> typesCompte = FXCollections.observableArrayList("Courant","Epargne");
    private ClientMain cmain;
    @FXML
    public ChoiceBox typeCompte;
    public static String compteType;
    public static Client client;
    public static double soldeClient;
    public TextField nom;
    public TextField prenom;
    public TextField date;
    public TextField solde;
    @FXML
    public void initialize(){
        typeCompte.setItems(typesCompte);
    }

    public void Clicked() throws IOException {

        cmain.showCompteMain();
        compteType = typeCompte.getValue().toString();
        client = new Client(nom.getText(),prenom.getText(),date.getText());
        soldeClient = Double.parseDouble(solde.getText());
    }

}
