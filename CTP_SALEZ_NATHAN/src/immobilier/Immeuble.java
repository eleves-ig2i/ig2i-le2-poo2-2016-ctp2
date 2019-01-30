/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immobilier;

import java.util.ArrayList;
import population.Contribuable;

/**
 *
 * @author user
 */
public class Immeuble extends Habitation {
    /**
     * Attribut caractérisant le nombre maximum d'appartements dans l'immeuble.
     */
    int nbAppartements;
    
    /**
     * On utilise un ArrayList, car on sait qu'on utilisera au maximum nbAppartements.
     */
    ArrayList<Appartement> listeAppartements;

    public Immeuble(int surface, int secteur, int nbAppartements) {
        super(surface, secteur);
        if( nbAppartements > 0)
            this.nbAppartements = nbAppartements;
        else
            this.nbAppartements = 0;
        
        this.listeAppartements = new ArrayList<>(this.nbAppartements);       
    }

    
    public int getNbAppartements() {
        return nbAppartements;
    }

    
    @Override
    public String toString() {
        return "Immeuble{" + super.toString() +  ", nbAppartements=" + nbAppartements +"}";
    }
    
    
    /**
     * ajoute l’appartement a à la
     * collection d’appartements de l’immeuble. Si l’ajout n’est pas possible (le nombre
     * maximal est atteint ou l’appartement est déjà dans l’immeuble) la méthode
     * renvoie false, et la méthode renvoie true si l’ajout a bien été effectué.
     * @param a
     * @return 
     */
    public boolean ajouterAppart(Appartement a)
    { 
        if( a == null 
                || ( this.listeAppartements.size() == this.nbAppartements - 1 )
                || ( this.listeAppartements.contains(a) ) 
                )
        {
            return false;
        }
        
        this.listeAppartements.add(a);
        return true;
            
    }

    @Override
    public double valeurFonciere() {
        double valFonciere = 0;
        
        for(Appartement a : this.listeAppartements)
        {
            valFonciere += a.valeurFonciere();
        }
        valFonciere *= 0.25;
        
        valFonciere += 125*(this.getSurface());
        
        return valFonciere;
    }
    
    
    public static void main(String[] args) {
        Immeuble imm = new Immeuble(600, 1, 4);
        Appartement app1 = new Appartement(120, 1, 3, true);
        Appartement app2 = new Appartement(180, 1, 2, false);
        Appartement app3 = new Appartement(200, 1, 2, true);
        Appartement app4 = new Appartement(100, 1, 0, true);
        Appartement app5 = new Appartement(120, 1, 2, false);
        imm.ajouterAppart(app1);
        imm.ajouterAppart(app2);
        imm.ajouterAppart(app3);
        imm.ajouterAppart(app4);
        System.out.println("Ajout app5 ? : "+imm.ajouterAppart(app5)); // false
        Contribuable proprio = new Contribuable("Jean", 0.75);
        proprio.acheter(imm); // mais il n’achète pas les appartements
        System.out.println("Taxe focnière : "+proprio.taxeFonciere());
    }
 
}
