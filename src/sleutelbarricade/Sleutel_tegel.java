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
public class Sleutel_tegel extends Tegel {
    private static int locationX;
    private static int locationY;

    private static int pincode;
    private static int status;
    private static int sleutelNummer;

    public Sleutel_tegel(int locationX, int locationY, int pincode, int status, int sleutelNummer) {
        super(locationX, locationY);
        this.locationX = locationX;
        this.locationY = locationY;

        this.pincode = pincode;
        this.status = status;
        this.sleutelNummer = sleutelNummer;

    }

    private static int[][] sleutelBase = new int[5][4];

    public static void store() {

        sleutelBase[sleutelNummer][0] = locationX;
        sleutelBase[sleutelNummer][1] = locationY;

        sleutelBase[sleutelNummer][2] = pincode;
        sleutelBase[sleutelNummer][3] = status;

    }
   
}
