package banque;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CompteCreationController {
    private ClientController ccontrol;
    private CompteController ccompte;
    public TextField nom;
    public TextField prenom;
    public TextField date;
    public TextField type;
    public TextField solde;

    @FXML
    public void showInfo(){
        nom.setText(ccontrol.client.nom);
        prenom.setText(ccontrol.client.prenom);
        date.setText(ccontrol.client.date_naissance);
        solde.setText(String.valueOf(ccontrol.soldeClient));
        type.setText(ccontrol.compteType);

    }

}
