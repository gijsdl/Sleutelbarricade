
package sleutelbarricade;

/**
 *
 * @author Crhis Bruijn, Ruben Buijck, Gijs de Lange
 */

//superclass van Sleutel_tegel en Barricade.
public class Tegel {
    private int locationX;
    private int locationY;
    private int pincode;
    private int status;

    public Tegel(int locationX, int locationY, int pincode, int status){
        this.locationX = locationX;
        this.locationY = locationY;
        this.pincode = pincode;
        this.status = status;
        
    }
    
}
