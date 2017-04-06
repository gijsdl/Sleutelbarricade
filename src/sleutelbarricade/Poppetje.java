

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

/**
 *
 * @author Ruben
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static sleutelbarricade.Poppetje.cordX;
import static sleutelbarricade.Poppetje.cordY;



public class Poppetje extends JFrame implements KeyListener {
    //Objecten voor plaatjes

    private BufferedImage gast;
    //start coördinaten poppetje
    private UUID uuid;
    public static int cordX = 0;
    public static int cordY = 0;
    private int oldCordX = 0;
    private int oldCordY = 0;
    public int sleutel;
    public static ImageIcon player = new ImageIcon("pics/poppetje.png"); //Het plaatje waarop het poppetje naar beneden kijkt.
    private static ImageIcon player1 = new ImageIcon("pics/poppetje1.png"); //Het plaatje waarop het poppetje naar rechts kijkt.
    private static ImageIcon player2 = new ImageIcon("pics/poppetje2.png"); //Het plaatje waarop het poppetje naar boven kijkt.
    private static ImageIcon player3 = new ImageIcon("pics/poppetje3.png"); //Het plaatje waarop het poppetje naar links kijkt.
    public static JLabel poppetje = new JLabel();
    int win = 0;

        

    public Poppetje() {
        this.uuid = UUID.randomUUID();
        poppetje.setIcon(player1);
        poppetje.setBounds(0, 0, 64, 64);
        add(poppetje);
        setFocusable(true);
        addKeyListener(this);
        PoppetjeHandler.getPoppetjes().add(this);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setSleutel(int sleutel) {
        this.sleutel = sleutel;
    }

    public int getSleutel() {
        return sleutel;
    }

    public void bewegen(int x, int y) {
       
        boolean check = Level.check(x, y, getUuid(), sleutel, win);
        
        if (check == true) {
            poppetje.setIcon(player);
            poppetje.setBounds(x * 64, y * 64, 64, 64);

            oldCordX = x;
            oldCordY = y;
            add(poppetje);

        } else {
            cordX = oldCordX;
            cordY = oldCordY;
        }
        if (x == 9 && y == 9) {

            JOptionPane.showMessageDialog(this, "U heeft dit level gewonnen!");
            win++;
            if (win == 3) {
                poppetje.setBounds(cordX, cordY, 64, 64);
                dispose();
                sleutel = 0;
                oldCordX = 0;
                oldCordY = 0;
                cordX = 0;
                cordY = 0;

                 spelStart s = new spelStart();
               s.setVisible(true);
               
               win = 0;
            } else {
                Level.generate(win);
                sleutel = 0;
                oldCordX = 0;
                oldCordY = 0;
                cordX = 0;
                cordY = 0;

                poppetje.setIcon(player);
                add(poppetje);
                poppetje.setBounds(cordX, cordY, 64, 64);
            }
        }

    }

    //While a key is pressed
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            //een tegel (64 pixels) naar rechts met pijltje naar rechts
            case KeyEvent.VK_RIGHT: {

                cordX += 1;

                bewegen(cordX, cordY);
                poppetje.setIcon(player1);

            }
            break;
            //een tegel (64 pixels) naar links met pijltje naar links
            case KeyEvent.VK_LEFT: {
                cordX -= 1;
                bewegen(cordX, cordY);
                poppetje.setIcon(player3);
            }
            break;
            //een tegel (64 pixels) omlaag met het pijltje omlaag
            case KeyEvent.VK_DOWN: {
                cordY += 1;
                bewegen(cordX, cordY);
                poppetje.setIcon(player);
            }
            break;
            //een tegel (64 pixels) omhoog met het pijltje omhoog
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

