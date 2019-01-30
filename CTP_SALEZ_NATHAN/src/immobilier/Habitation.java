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
public abstract class Habitation {
    private static int lastId = 0;
    
    /**
     * identifiant de l'instance.
     */
    private int reference;
    
    /**
     * surface en m²
     */
    private int surface;
    
    /**
     * numéro de secteur
     */
    private int secteur;
    
    
    private Contribuable proprietaire;

    
    /**
     * Constructeur par défaut, utilisé pour le constructeur par données.
     * L'identifiant est défini dans ce constructeur.
     * surface = 0;
     * secteur = 0;
     * proprietaire = null;
     */
    public Habitation() {
        reference = ++lastId;
        surface = 0;
        secteur = 0;
        proprietaire = null;
    }

    
    /**
     * Constructeur par données de la classe Contribuable.
     * Si surface négatif, alors l'attribut associé vaudra 0.
     * Si secteur négatif alors l'attribut associé vaudra 0.
     * proprietaire vaudra null
     * @param surface
     * @param secteur
     */
    public Habitation(int surface, int secteur) {
        this();
        if( surface >= 0)
            this.surface = surface;
        if( secteur >= 0)
            this.secteur = secteur;
    }

    public int getSurface() {
        return surface;
    }

    public int getSecteur() {
        return secteur;
    }
    
    
    /**
     * Renvoie la valeur foncière d'une habitation.
     * @return 
     */
    public abstract double valeurFonciere();
    
    
    /**
     * définit le contribuable proprio comme propriétaire de l’habitation. 
     * Si l’habitation possède déjà un propriétaire,
     * alors proprio ne peut pas devenir propriétaire, et la méthode renvoie false,
     * sinon elle renvoie true.
     * @param proprio
     * @return 
     */
    public boolean setProprietaire(Contribuable proprio)
    {
        if( this.proprietaire == null && proprio != null)
        {
            this.proprietaire = proprio;
            // System.out.println("Propriétaire ajoutée !");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    

    @Override
    public String toString() {
        String sReturn = "Habitation{" + "reference=" + reference + ", surface=" + surface + ", secteur=" + secteur + ", proprietaire=";
        if( this.proprietaire != null) 
            sReturn += proprietaire.toString();
        else
            sReturn += "null";
        sReturn += '}';
        
        return sReturn;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
