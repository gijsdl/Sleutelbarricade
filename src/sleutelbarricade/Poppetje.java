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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Poppetje extends JFrame implements KeyListener {
    //Objectne voor plaatjes

    private BufferedImage background;
    private BufferedImage gast;
    //start coördinaten poppetje
    private int cordX = 0;
    private int cordY = 0;
    private int oldCordX = 0;
    private int oldCordY = 0; 
    private ImageIcon player = new ImageIcon("pics/poppetje.png");
    private ImageIcon player1 = new ImageIcon("pics/poppetje1.png");
    private ImageIcon player2 = new ImageIcon("pics/poppetje2.png");
    private ImageIcon player3 = new ImageIcon("pics/poppetje3.png");
    private JLabel poppetje = new JLabel();

    public Poppetje() {
        create();
        
    }

    public void create() {
        poppetje.setIcon(player);
        poppetje.setBounds(0, 0, 64, 64);
        add(poppetje);
        setFocusable(true);
        addKeyListener(this);

    }

    public void bewegen(int x, int y) {
       boolean check = Level.check(x , y);
       if (check == true){
           poppetje.setIcon(player);
        poppetje.setBounds(x * 64, y * 64, 64, 64);
        
        oldCordX = x;
        oldCordY = y;
        add(poppetje);
        
       }else{
           cordX = oldCordX;
           cordY = oldCordY;
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
