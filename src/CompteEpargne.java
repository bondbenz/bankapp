package banque;

import java.io.Serializable;

public class CompteEpargne extends Compte implements Serializable {
    protected float tauxInterets;

    public CompteEpargne(Client proprietaire,double solde,float taux) throws Exception {
        super(proprietaire,solde);
        tauxInterets=taux;
    }


    public void calculInterets() {
        solde=solde+solde*tauxInterets;
    }


}