/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package population;

import immobilier.Appartement;
import immobilier.Habitation;
import immobilier.Logement;
import immobilier.Maison;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Contribuable {
    private String nom;
    
    /**
     * taux compris entre 0.0 et 1.0
     */
    private double tauxImposition;
    
    /**
     * Liste des propriétés du constribuable.
     */
    private LinkedList<Habitation> listeProprietes;

    /**
     * Liste des locataires du contribuable.
     */
    private LinkedList<Logement> listeLocations;
    
    
    /**
     * Constructeur par défaut, utilisé pour le constructeur par données.
     * nom = "NAME"
     * tauxImposition = 1
     * listeProprietes est généré par le constructeur par défaut de LinkedList.
     * listeLocations est généré par le constructeur par défaut de LinkedList.
     */
    public Contribuable() {
        nom = "NAME";
        tauxImposition = 1;
        listeProprietes = new LinkedList<>();
        listeLocations = new LinkedList<>();
    }

    
    /**
     * Constructeur par données de la classe Contribuable.
     * Si nom est null, alors l'attribut associé vaudra "NAME"
     * Si tauxImposition est incorrect, alors l'attribut associé vaudra 1.
     * @param nom
     * @param tauxImposition 
     */
    public Contribuable(String nom, double tauxImposition) {
        this();
        
        if( nom != null)
            this.nom = nom;
        
        this.setTauxImposition(tauxImposition);
    }


    public void setTauxImposition(double tauxImposition) {        
        if( 0 <= tauxImposition && tauxImposition < 1)
            this.tauxImposition = tauxImposition;
    }

    public String getNom() {
        return nom;
    }

    public double getTauxImposition() {
        return tauxImposition;
    }
    
    
    /**
     * doit définir que le contribuable est propriétaire
     * de l’habitation (il faut modifier les attributs des deux côtés de la relation).
     * Si l’habitation possède déjà un propriétaire, l’achat ne peut pas se
     * concrétiser, et la méthode renvoie false, sinon elle renvoie true.
     * @param h
     * @return 
     */
    public boolean acheter(Habitation h)
    {
        if( h == null)
            return false;
        
        if( h.setProprietaire(this) )   // modification côté habitation (si possible)
        {
            this.listeProprietes.add(h);  // modif côté contribuable.
            return true;
        }
        else
            return false;
    }
    
    
    /**
     * doit définir que le contribuable est locataire
     * du logement (il faut modifier les attributs des deux côtés de la relation).
     * Si le logement possède déjà un locataire, la location ne peut pas se
     * concrétiser, et la méthode renvoie false, sinon elle renvoie true.
     * @param l
     * @return 
     */
    public boolean louer(Logement l)
    {
        if( l == null)
            return false;
        
        if( l.setLocataire(this) )   // modification côté logement (si possible)
        {
            this.listeLocations.add(l);  // modif côté contribuable.
            return true;
        }
        else
            return false;
    }
    
    /**
     * Renvoie la taxe foncière d'un contribuable.
     * @return 
     */
    public double taxeFonciere()
    {
        double taxe = 0;
        // somme des valeurs foncières de toutes les propriétés de ce contribuable
        for(Habitation h : this.listeProprietes)
        {
            taxe += h.valeurFonciere();
        }
        
        // multiplier cette somme par le taux d’imposition.
        taxe *= this.tauxImposition;
        return taxe;
    }
    
    
    /**
     * Renvoie la taxe d'habitation d'un contribuable.
     * @return 
     */
    public double taxeHabitation()
    {
        double taxe = 0;
        
        for(Logement l : this.listeLocations )
        {
            taxe += l.valeurLocative();
        }
        
        taxe *= this.tauxImposition;
        
        return taxe;
    }

    @Override
    public String toString() {
        return "Contribuable{" + "nom=" + nom + ", tauxImposition=" + tauxImposition + '}';
    }
    
    
    public static void main(String[] args) {
        // test Q1
        /*
        Contribuable c1 = new Contribuable("Pierre", 0.8); //taux de 0.8
        Contribuable c2 = new Contribuable("Paul", 0.7);
        Contribuable c3 = new Contribuable("Jack", 0.6);
        Contribuable c4 = new Contribuable("Jacques", 1.8);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        */
        
        // Test Q13
        /*
        Contribuable c1 = new Contribuable("Pierre", 0.2); 
        
        Contribuable c2 = new Contribuable("Paul", 0.6);
        Habitation h1 = new Maison(0,0,1,140);
        c2.acheter(h1);
        
        Contribuable c3 = new Contribuable("Jack", 0.8);
        Habitation h2 = new Appartement(60,2,0,false);
        Habitation h3 = new Appartement(75,4,0,false);
        c3.acheter(h2);
        c3.acheter(h3);
        
        System.out.println("Taxe foncière c1 : " + c1.taxeFonciere());
        System.out.println("Taxe foncière c2 : " + c2.taxeFonciere());
        System.out.println("Taxe foncière c3 : " + c3.taxeFonciere());
        */
        
        
        // Test Q16
        /*
        Contribuable c1 = new Contribuable("Pierre", 0.3); 
        Logement l1 = new Appartement(85,0,0,true);
        c1.louer(l1);
        
        Contribuable c2 = new Contribuable("Paul", 0.6);
        Logement l2 = new Maison(500,3,1,140);
        c2.louer(l2);
        
        Contribuable c3 = new Contribuable("Jack", 1);
        Logement l3 = new Appartement(60,0,1,true);
        Logement l4 = new Maison(1000,2,3,175);
        c3.louer(l3);
        c3.louer(l4);
        
        System.out.println("Taxe habitation c1 : " + c1.taxeHabitation());
        System.out.println("Taxe habitation c2 : " + c2.taxeHabitation());
        System.out.println("Taxe habitation c3 : " + c3.taxeHabitation());
        */
        
        
        
        
    }
    
    
    
    
}
