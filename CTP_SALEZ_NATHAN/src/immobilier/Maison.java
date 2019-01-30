/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package immobilier;

/**
 *
 * @author user
 */
public class Maison extends Logement {
    
    /**
     * nombre d'étages de la maison (minimum 1 etage qui est le rez de chaussee
     */
    private int nbEtages;
    
    private int superficieTerrain;

    
    /**
     * Constructeur par données de la classe Maison.
     * Si nbEtages < 1 alors l'attribut associé vaudra 1
     * si superficieTerrain < 0 alors l'attribut associé vaudra 0
     * @param nbEtages
     * @param superficieTerrain
     * @param surface
     * @param secteur 
     */
    public Maison(int superficieTerrain, int nbEtages, int secteur, int surface) {
        super(surface, secteur);
        if( nbEtages >= 1)
            this.nbEtages = nbEtages;
        else
            this.nbEtages = 1;
        
        if( superficieTerrain >= 0)
            this.superficieTerrain = superficieTerrain;
        else
            this.superficieTerrain = 0;
    }
    
    
    @Override
    public double valeurLocative() {
        double valLocative = 0;
        double coutUnitaireSurfaceMaison = 18, coutUnitaireEtage = 85, coutUnitaireSurfaceTerrain = 3.25;
        int secteur = this.getSecteur();
        
        if( secteur == 1 || secteur == 2)
        {
            coutUnitaireSurfaceMaison = 25;
            coutUnitaireEtage = 100;
            coutUnitaireSurfaceTerrain = 2.50;
        }
        
        valLocative = coutUnitaireSurfaceMaison*this.getSurface();
        valLocative += coutUnitaireSurfaceTerrain*this.superficieTerrain;
        valLocative += coutUnitaireEtage*this.nbEtages;
        
        return valLocative;
    }

    
    
    
    
    

    @Override
    public String toString() {
        return "Maison{" + super.toString() + ", nbEtages=" + nbEtages + ", superficieTerrain=" + superficieTerrain + '}';
    }
    
    
    
    
    
    

    
    
    
}
