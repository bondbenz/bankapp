package banque;


import javafx.scene.control.TextArea;

public class ListeOpController {
    private CompteController ccontrol;
    public TextArea listop;
    public void showOps(){
        listop.setText(String.valueOf(ccontrol.compteClient.listeOperations));
    }
}
