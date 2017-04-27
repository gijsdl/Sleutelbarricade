package sleutelbarricade;

/**
 *
 * @author Crhis Bruijn, Ruben Buijck, Gijs de Lange
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Poppetje extends JFrame implements KeyListener {

    //initialiseren van de benodigde variabelen.
    private static int cordX = 0;
    private static int cordY = 0;
    private int oldCordX = 0;
    private int oldCordY = 0;
    private static int sleutel;
    private static ImageIcon player = new javax.swing.ImageIcon(Poppetje.class.getResource("/sleutelbarricade/pics/poppetje.png")); //Het plaatje waarop het poppetje naar beneden kijkt.
    private static ImageIcon player1 = new javax.swing.ImageIcon(Poppetje.class.getResource("/sleutelbarricade/pics/poppetje1.png")); //Het plaatje waarop het poppetje naar rechts kijkt.
    private static ImageIcon player2 = new javax.swing.ImageIcon(Poppetje.class.getResource("/sleutelbarricade/pics/poppetje2.png")); //Het plaatje waarop het poppetje naar boven kijkt.
    private static ImageIcon player3 = new javax.swing.ImageIcon(Poppetje.class.getResource("/sleutelbarricade/pics/poppetje3.png")); //Het plaatje waarop het poppetje naar links kijkt.
    private static JLabel poppetje = new JLabel();
    private static int win = 0;

// het plaatje van poppetje plaatsen op het JFrame.
    public Poppetje() {
        cordX = 0;
        cordY = 0;
        oldCordX = 0;
        oldCordY = 0;

        poppetje.setIcon(player);
        poppetje.setBounds(0, 0, 64, 64);
        add(poppetje);
        setFocusable(true);
        addKeyListener(this);

    }
//getters en setters

    public static void setSleutel(int sleutel) {
        Poppetje.sleutel = sleutel;
    }

    public static int getSleutel() {
        return sleutel;
    }

    public static int getCordX() {
        return cordX;
    }

    public static void setCordX(int cordX) {
        Poppetje.cordX = cordX;
    }

    public static int getCordY() {
        return cordY;
    }

    public static void setCordY(int cordY) {
        Poppetje.cordY = cordY;
    }

// zorgen dat het poppetje kan bewegen ever het veld.
    public void bewegen(int x, int y) {
        // kijken bij Level of hij daarheen mag bewegen.
        boolean check = Level.checkMovement(x, y, sleutel, win);

        if (check == true) {
            poppetje.setIcon(player);
            poppetje.setBounds(x * 64, y * 64, 64, 64);

            oldCordX = x;
            oldCordY = y;
            add(poppetje);

        } else {
            //als hij niet naar het nieuwe coördinaat toe kan worden de coördinaten weer het oude.
            cordX = oldCordX;
            cordY = oldCordY;
        }
        //als hij op het laatste veld is melden dat hij gewonnen heeft.
        if (x == 9 && y == 9) {
            win();

        }

    }

    public void win() {

        
        win++;
        // na 3 keer winnen word er verteld dat hij het spel gewonnen heeft en word de speler terug gebracht bij het menu en worden alle waardens hersteld.
        if (win == 3) {
            JOptionPane.showMessageDialog(this, "U heeft dit spel gewonnen!");
            
            dispose();

            spelStart s = new spelStart();
            s.setVisible(true);

            win = 0;
        } else {
            JOptionPane.showMessageDialog(this, "U heeft dit level gewonnen!");
            sleutel = 0;
            oldCordX = 0;
            oldCordY = 0;
            cordX = 0;
            cordY = 0;
            Level.generateLevel(win);

        }

    }

    // het kijken of er iemand op de pijltjes toetsen drukt.
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            //een tegel naar rechts met pijltje naar rechts
            case KeyEvent.VK_RIGHT: {

                cordX += 1;

                bewegen(cordX, cordY);
                poppetje.setIcon(player1);

            }
            break;
            //een tegel naar links met pijltje naar links
            case KeyEvent.VK_LEFT: {
                cordX -= 1;
                // het nieuwe coördinaat versturen.
                bewegen(cordX, cordY);
                // poppetje naar de nieuwe laten wijzen.
                poppetje.setIcon(player3);
            }
            break;
            //een tegel omlaag met het pijltje omlaag
            case KeyEvent.VK_DOWN: {
                cordY += 1;
                bewegen(cordX, cordY);
                poppetje.setIcon(player);
            }
            break;
            //een tegel omhoog met het pijltje omhoog
            case KeyEvent.VK_UP: {
                cordY -= 1;
                bewegen(cordX, cordY);
                poppetje.setIcon(player2);
            }
            break;
        }

    }

    //als een knop ingedrukt wordt
    public void keyTyped(KeyEvent ke) {
    }

    //als een knop lostgelaten wordt
    public void keyReleased(KeyEvent ke) {
    }
}
