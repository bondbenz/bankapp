package banque;

import java.io.Serializable;

public class CompteCourant extends Compte implements Serializable {
    protected double montantDecouvertPermis;

    public CompteCourant(Client proprietaire,double solde, double decouvert) throws  Exception{
        super(proprietaire,solde);
        montantDecouvertPermis=decouvert;
    }

    @Override
    public void retirer(double montant,String description,String date) throws DepassementSoldeException {
        if (montant> solde || montant> montantDecouvertPermis)
            throw new DepassementSoldeException("la somme de retrait dépasse le montant du découvert permis");
        else solde=solde-montant;
        listeOperations.add(new OperationBancaire(-montant,date,description));

    }

}