package banque;

import java.io.Serializable;


public class OperationBancaire implements Comparable<Object>{
    protected double montant;
    protected String dateOperation;
    protected  String description;
    public OperationBancaire(double montant,String date,String description){
        this.montant=montant;
        this.dateOperation=date;
        this.description=description;
    }

    @Override
    public String toString() {
        return "OperationBancaire{montant=" + montant + ", le "+ dateOperation + ", " + description + '}';
    }

    //...........................pour trier la liste des opérations effectuées....................................//
    public int compareTo(Object o) {
        if(! (o instanceof OperationBancaire)) return 0;
        OperationBancaire b=(OperationBancaire)o;
        int x=b.dateOperation.compareTo(this.dateOperation);
        if (x==0) return b.description.compareTo(this.description);
        else return x;
    }
}