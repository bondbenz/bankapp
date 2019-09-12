package banque;

import java.util.*;
import java.io.*;
public class Compte implements Serializable{
    protected long numero_compte;
    protected Client proprietaire;
    protected double solde;
    protected TreeSet<OperationBancaire> listeOperations;
    protected static int nb_compte=0;

    public Compte (Client proprietaire,double solde) throws Exception {
        ObjectOutputStream out=null;		HashSet<Compte> All=new HashSet();
        this.proprietaire=proprietaire;
        this.solde=solde;
        nb_compte++;
        numero_compte=nb_compte;
        listeOperations=new TreeSet();
        try {
            All=findAll();

            out=new ObjectOutputStream(new FileOutputStream("Comptes.data"));
            for(Compte u :All)
                out.writeObject(u);

            out.writeObject(this);

        }catch(FileNotFoundException e){}


        finally{ if(out!=null) out.close();	}

    }


    public String toString (){
        return ("Compte numero:"+this.numero_compte+" de client: "+this.proprietaire.toString()
                +" dispose: "+this.solde+" DZD");
    }

//............................................le versement........................................ //

    public void verser(double montant,String date,String description) {
        solde=solde+montant;
        listeOperations.add(new OperationBancaire(montant,date,description));

    }

//............................................le retrait...........................................//

    public void retirer(double montant,String date ,String description) throws DepassementSoldeException {
        if (montant> solde)
            throw new DepassementSoldeException (" la somme de retrait dépasse le solde du compte");
        else solde=solde-montant;
        listeOperations.add(new OperationBancaire(-montant,date,description));

    }

//...................Avoir le relevé des n dernières opérations effectuées sur le compte................//

    public String listeOperations(int n){
        Iterator<OperationBancaire> it =listeOperations.iterator();
        int i=0;
        String operation="";
        while (i<n && it.hasNext()) {
            operation=operation+it.next().toString()+"\n";
            i=i+1;
        }
        return operation;
    }



    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Compte)) return false;

        return ((Compte)obj).numero_compte == this.numero_compte;	}

    public int hashCode() {	return Long.hashCode(this.numero_compte);	}

    public HashSet<Compte> findAll() throws ClassNotFoundException,FileNotFoundException, IOException {
        HashSet<Compte> All=new HashSet();

        ObjectInputStream in= new ObjectInputStream(new FileInputStream("Comptes.data"));

        while(true)
            try{	 All.add(((Compte)in.readObject()));	}


            catch(EOFException e){ break; }




        return All;
    }


}