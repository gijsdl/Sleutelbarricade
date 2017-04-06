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
import javax.swing.JOptionPane;

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
        System.out.println(x + " " + y);
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
       if ( x == 9 && y == 9){
           
           JOptionPane.showMessageDialog(this, "U heeft dit level gewonnen!");
       }
        
    }

    //While a key is pressed
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            //een tegel (64 pixels) naar rechts met pijltje naar rechts
            case KeyEvent.VK_RIGHT: {
               
                cordX += 1;
                
                bewegen(cordX, cordY);
                
            }
            break;
            //een tegel (64 pixels) naar links met pijltje naar links
            case KeyEvent.VK_LEFT: {
                cordX -= 1;
                bewegen(cordX, cordY);
            }
            break;
            //een tegel (64 pixels) omlaag met het pijltje omlaag
            case KeyEvent.VK_DOWN: {
                cordY += 1;
                bewegen(cordX, cordY);
            }
            break;
            //een tegel (64 pixels) omhoog met het pijltje omhoog
            case KeyEvent.VK_UP: {
                cordY -= 1;
                bewegen(cordX, cordY);
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
