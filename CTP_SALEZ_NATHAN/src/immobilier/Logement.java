/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immobilier;

import population.Contribuable;

/**
 *
 * @author user
 */
public abstract class Logement extends Habitation {
    
    /**
     * Locataire du logement (peut être le propriétaire)
     */
    private Contribuable locataire;

    /**
     * Constructeur par données de la classe Logement.
     * @param surface
     * @param secteur 
     */
    public Logement(int surface, int secteur) {
        super(surface, secteur);
        this.locataire = null;
    }
    
    /**
     * définit le contribuable locataire comme locataire de l’habitation. 
     * Si l’habitation possède déjà un locataire,
     * alors locataire ne peut pas devenir locataire, et la méthode renvoie false,
     * sinon elle renvoie true.
     * @param locataire
     * @return 
     */
    public boolean setLocataire(Contribuable locataire)
    {
        if( this.locataire == null && locataire != null)
        {
            this.locataire = locataire;
            // System.out.println("Locataire ajoutée !");
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public double valeurFonciere()
    {
        double coutUnitaireSurface = 12;
        switch( this.getSecteur() )
        {
            case 1 : 
                coutUnitaireSurface = 20;
            break;
            
            case 2 :
                coutUnitaireSurface = 18;
                break;
                
            case 3 :
                coutUnitaireSurface = 15;
                break;      
        }
        
        return coutUnitaireSurface*this.getSurface();
    }
    
    
    /**
     * Renvoie la valeur locative d'un logement.
     * @return 
     */
    public abstract double valeurLocative();
    
    
    

    @Override
    public String toString() {
        String sReturn = "Logement{" + super.toString() + ", locataire=";
        if( this.locataire != null)
            sReturn += locataire.toString();
        else
            sReturn += "null";
        return sReturn + '}';
    }
    
    
    public static void main(String[] args) {
        Contribuable c1 = new Contribuable("Pierre", 0.8); //taux de 0.8
        Contribuable c2 = new Contribuable("Paul", 0.7);
        Contribuable c3 = new Contribuable("Jack", 0.6);
        Contribuable c4 = new Contribuable("Jacques", 1.8);
        // 120 m2 en secteur 1, 3 étages et 100m2 de terrain
        Habitation h1 = new Maison(120, 1, 3, 100);
        Habitation h2 = new Maison(150, 2, -2, 0);
        // 80 m2 en secteur 1, avec 1 parking, sans cave
        Habitation h3 = new Appartement(80, 1, 1, false);
        Habitation h4 = new Appartement(100, 2, 0, true);
        c1.acheter(h1);
        c2.acheter(h2);
        c1.acheter(h3);
        c1.acheter(h4);
        System.out.println("c4 achete h4 ? : " + c4.acheter(h4)); // false
        c1.louer((Logement) h1);
        c2.louer((Logement) h2);
        c3.louer((Logement) h3);
        c4.louer((Logement) h4);
        System.out.println("c2 loue h3 ? : " + c2.louer((Logement) h3)); // false
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
    }
    
    
    
}
