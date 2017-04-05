/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

/**
 *
 * @author Gijs
 */
public class Barricade extends Tegel {
    private static int locationX;
    private static int locationY;

    private static int pincode;
    private static int status;
    private static int barricadeNummer;
    
    public Barricade(int locationX, int locationY, int pincode, int status, int barricadeNummer) {
        super(locationX, locationY);
         this.locationX = locationX;
        this.locationY = locationY;

        this.pincode = pincode;
        this.status = status;
        this.barricadeNummer = barricadeNummer;
    }
    
    
}
