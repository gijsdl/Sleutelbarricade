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
 
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
 

public class Poppetje extends JFrame implements KeyListener {
    //Objectne voor plaatjes
 
    private BufferedImage background;
    private BufferedImage gast;
    //start coördinaten poppetje
    private int cordX = 0;
    private int cordY = 45;
 
    public Poppetje() {
        setTitle("Sleutelbaricade");
        setSize(640, 640); //het scherm is 640 bij 640
        loadImages();
        setVisible(true); // venster visible maken
    }
 
    public void loadImages() {
        try {
            //paden voor plaatjes
            String pathBackground = "pics/background.png";
            background = ImageIO.read(new File(pathBackground));
            String pathPoppetje = "pics/poppetje.png";
            gast = ImageIO.read(new File(pathPoppetje));
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //keyboard listener aan deze jframe binden
        addKeyListener(this);
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //achtergrond tekenen (plaatje 1)
        g.drawImage(background, 0, 0, this);
        //Poppetje (plaatje 2)
        g.drawImage(gast, cordX, cordY, this);
    }
 
    public static void main(String[] args) {
        new Poppetje();
    }
 
 
    //While a key is pressed
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            //een tegel (64 pixels) naar rechts met pijltje naar rechts
            case KeyEvent.VK_RIGHT: {
                cordX+=64;
            }
            break;
            //een tegel (64 pixels) naar links met pijltje naar links
            case KeyEvent.VK_LEFT: {
                cordX-=64;
            }
            break;
            //een tegel (64 pixels) omlaag met het pijltje omlaag
            case KeyEvent.VK_DOWN: {
                cordY+=64;
            }
            break;
            //een tegel (64 pixels) omhoog met het pijltje omhoog
            case KeyEvent.VK_UP: {
                cordY-=64;
            }
            break;
        }
        repaint();
    }
 
    //als een knop ingedrukt wordt
    public void keyTyped(KeyEvent ke) {}
     
    //als een knop lostgelaten wordt
    public void keyReleased(KeyEvent ke) {}
}