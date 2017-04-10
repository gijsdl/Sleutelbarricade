
package sleutelbarricade;

/**
 *
 * @author Crhis Bruijn, Ruben Buijck, Gijs de Lange
 */
public class Barricade extends Tegel {
//initialiseren van de door de constuctor gegeven variabelen.

    private static int locationX;
    private static int locationY;

    private static int pincode;
    private static int status;
    private static int barricadeNummer;

    //constructor een value geven.
    public Barricade(int locationX, int locationY, int pincode, int status, int barricadeNummer) {
        super(locationX, locationY);
        this.locationX = locationX;
        this.locationY = locationY;

        this.pincode = pincode;
        this.status = status;
        this.barricadeNummer = barricadeNummer;

    }
    // initialiseren van de array die de data onhoud.
    private static int[][] barricadeBase = new int[34][4];

    // het oplsaan van de gegevens
    public static void store() {
        barricadeBase[barricadeNummer][0] = locationX;
        barricadeBase[barricadeNummer][1] = locationY;
        barricadeBase[barricadeNummer][2] = pincode;
        barricadeBase[barricadeNummer][3] = status;

    }
// nieuwe array om de oude weer leeg te maken bij een nieuwe generatie.

    public static void reset() {
        int[][] reset = new int[34][4];
        barricadeBase = reset;

    }
// kijken of het poppetje hier heen kan lopen.

    public static boolean boxCheck(int x, int y, int sleutel) {
        boolean check = false;
        for (int i = 0; i < 34; i++) {
            // kijken of de locatie en de sleutel die de speler heeft met elkaar kloppen.
            if (barricadeBase[i][0] == x && barricadeBase[i][1] == y && barricadeBase[i][2] == sleutel && barricadeBase[i][3] == 1) {
                barricadeBase[i][3] = 0;
                check = true;
                // kijken of de box al barricade al open is.
            } else if (barricadeBase[i][0] == x && barricadeBase[i][1] == y && barricadeBase[i][3] == 0) {
                check = true;
            }

        }
        return check;
    }
    
    public static int barricadePincode( int barricadeNummer){
        return barricadeBase[barricadeNummer][2];
    }
// kijken voor de status en daarmee of hij opnieuw gegenereerd moet worden.

    public static boolean placeCheack(int barricadeNummer) {
        boolean status = true;
        if (barricadeBase[barricadeNummer][3] == 0) {
            status = false;
        }
        return status;
    }

}
