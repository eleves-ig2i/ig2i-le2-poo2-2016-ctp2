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
public class Appartement extends Logement {
    
    /**
     * Nombre de places du parking associé à l'instance.
     */
    private int nbParking;
    
    /**
     * Si une cave est associée à l'appartement, alors cet attribut vaut true.
     */
    private boolean cave;

    
    /**
     * Constructeur par données de la classe Appartement.
     * Si nbParking est négatig alors l'attribut associé vaudra 0
     * @param nbParking nombre de places du parking associé.
     * @param cave
     * @param surface
     * @param secteur 
     */
    public Appartement(int surface, int secteur, int nbParking, boolean cave) {
        super(surface, secteur);
        if( nbParking >= 0 )
            this.nbParking = nbParking;
        else
            this.nbParking = 0;
        this.cave = cave;
    }

    @Override
    public double valeurLocative() {
        double valLocative = 0;
        
        valLocative = 20*this.getSurface();
        valLocative += 57.50*nbParking;
        
        if( cave )
        {
            valLocative += 38.25;
        }
        
        return valLocative;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Appartement{" + super.toString() + ", nbParking=" + nbParking + ", cave=" + cave + '}';
    }
    
    
    
    
    
}
