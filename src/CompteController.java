package banque;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.*;

public class CompteController {

    private ClientController ccontrol;
    private ClientMain cmain;
    public static Compte compteClient;
    public TextField taux;
    public TextField dateVersement;
    public TextField montantVersement;
    public TextField descriptionVersement;
    public TextField montantRetrait;
    public TextField dateRetrait;
    public TextField descriptionRetrait;
    public TextField finale;


    @FXML
    public void creerCompte() throws Exception {
        if(ccontrol.compteType.equals("Courant")){
            double montantDecouverts = Double.parseDouble(taux.getText());
            compteClient = new CompteCourant(ccontrol.client,ccontrol.soldeClient,montantDecouverts);
            ObjectOutputStream out=null;
            try {
                out=new ObjectOutputStream(new FileOutputStream("Comptes.data"));
                out.writeObject(compteClient);

            }catch(FileNotFoundException e){}

            finally{ if(out!=null) out.close();	}

            cmain.showCreation();

        }else if(ccontrol.compteType.equals("Epargne")){
            float tauxInterets = Float.parseFloat(taux.getText());
            compteClient = new CompteEpargne(ccontrol.client,ccontrol.soldeClient,tauxInterets);
            ((CompteEpargne) compteClient).calculInterets();
            cmain.showCreation();
        }


    }



    public void Verser() throws Exception {
        double montant = Double.parseDouble(montantVersement.getText());
        compteClient.verser(montant,dateVersement.getText(),descriptionVersement.getText());
        finale.setText(String.valueOf(compteClient.solde));

    }

    public void Retirer() throws Exception , DepassementSoldeException {
        if (ccontrol.compteType.equals("Courant")){
            double montant = Double.parseDouble(montantRetrait.getText());
            try{
                compteClient.retirer(montant,descriptionRetrait.getText(),dateRetrait.getText());
                finale.setText(String.valueOf(compteClient.solde));
            }catch (DepassementSoldeException e){
                cmain.showErreur();
            }
        }else if (ccontrol.compteType.equals("Epargne")){
            double montant = Double.parseDouble(montantRetrait.getText());
            compteClient.retirer(montant,dateRetrait.getText(),descriptionRetrait.getText());
            finale.setText(String.valueOf(compteClient.solde));
        }

    }

    public void ListOperations() throws IOException {
        cmain.showOpers();

    }


}