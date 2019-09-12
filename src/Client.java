package banque;

import java.io.Serializable;

public class Client implements Serializable{
    protected String nom;
    protected String prenom;
    protected String date_naissance;


    public Client(String nom,String prenom,String date){
        this.nom=nom;
        this.prenom=prenom;
        this.date_naissance=date;
    }


    public String toString(){
        return (this.nom+" "+this.prenom+" "+this.date_naissance);
    }
}