
package sleutelbarricade;

import java.util.UUID;

/**
 *
 * @author Crhis Bruijn, Ruben Buijck, Gijs de Lange
 */
public class Sleutel_tegel extends Tegel {
 //initialiseren van de door de constuctor gegeven variabelen.
    private static int locationX;
    private static int locationY;

    private static int pincode;
    private static int status;
    private static int sleutelNummer;
 //constructor een value geven.
    public Sleutel_tegel(int locationX, int locationY, int pincode, int status, int sleutelNummer) {
        super(locationX, locationY);
        this.locationX = locationX;
        this.locationY = locationY;

        this.pincode = pincode;
        this.status = status;
        this.sleutelNummer = sleutelNummer;

    }
// initialiseren van de array die de data onhoud.
    private static int[][] sleutelBase = new int[5][4];

    public static void store() {

        sleutelBase[sleutelNummer][0] = locationX;
        sleutelBase[sleutelNummer][1] = locationY;

        sleutelBase[sleutelNummer][2] = pincode;
        sleutelBase[sleutelNummer][3] = status;

    }
// nieuwe array om de oude weer leeg te maken bij een nieuwe generatie.
    public static void reset() {
        int[][] reset = new int[5][4];

        sleutelBase = reset;
    }
// kijken welke sleutel het poppetje krijgt en deze aan het geven.
    public static void sleutelcheck(int x, int y, UUID uuid) {
        for (int j = 0; j < 5; j++) {if (sleutelBase[j][0] == x && sleutelBase[j][1] == y && sleutelBase[j][3] == 0){
            
                break;
            }else if (sleutelBase[j][0] == x && sleutelBase[j][1] == y && sleutelBase[j][3] == 1) {
                Poppetje poppetje = PoppetjeHandler.getPoppetje(uuid);
                poppetje.setSleutel(sleutelBase[j][2]);
                sleutelBase[j][3]= 0;
                
                break;
            }
            
        }
    }
    // kijken voor de status en daarmee of hij opnieuw gegenereerd moet worden.
    public static boolean placeCheack( int sleutelNummer){
        boolean status = true;
        if (sleutelBase[sleutelNummer][3]== 0){
            status = false;
        }
        return status;
    }

}
