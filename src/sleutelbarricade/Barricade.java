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
    private static int[][] barricadeBase = new int[34][4];

    public static void store() {
        barricadeBase[barricadeNummer][0] = locationX;
        barricadeBase[barricadeNummer][1] = locationY;
        barricadeBase[barricadeNummer][2] = pincode;
        barricadeBase[barricadeNummer][3] = status;
        

    }
    
    public static void reset() {
        int[][] reset = new int[34][4];
        barricadeBase = reset;
        
    }

    public static boolean boxCheck(int x, int y , int sleutel){
         boolean check = false;
        for (int i = 0; i < 34; i++){
            if (barricadeBase[i][0] == x && barricadeBase[i][1] == y && barricadeBase[i][2] == sleutel && barricadeBase[i][3] == 1){
                barricadeBase[i][3]=0;
                check = true;
                
                
            }else if(barricadeBase[i][0] == x && barricadeBase[i][1] == y && barricadeBase[i][3] == 0){
                check = true;
            }
            
        }
        return check;
    }

}
