/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Gijs
 */
public class Level {

<<<<<<< HEAD
    private static final int FRAME_WIDTH = 656;
    private static final int FRAME_HIGHT = 679;
=======
    private static final int FRAME_WIDTH = 657;
    private static final int FRAME_HIGHT = 683;
    private static JFrame level = new JFrame();
    
>>>>>>> gijs
    
    public static void main(String[] args) {
        
       
        level.setTitle("level");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        level.setSize(FRAME_WIDTH, FRAME_HIGHT);
        level.setLayout(new BorderLayout());
        JLabel background = new JLabel();
        ImageIcon pic = new ImageIcon("pics/background.png");
        background.setIcon(pic);
        background.setBounds(0, 0, 640, 640);
        
        
        
        
        generate();
        level.add(background);
       level.setLayout(null);
        level.setVisible(true);
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                System.out.printf("%8d", layout[y][x]);

            }
            System.out.println("");
        }
    }
    private static int locationX = 0;
    private static int locationY = 0;
            
    private static int[][] layout;
    static Random random = new Random();

    public static void generate() {
        layout = new int[10][10];
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (x == 0 && y == 0) {
                    layout[0][0] = 0;
                } else if (y == 9 && x == 9) {
                    layout[9][9] = 3;
                } else {
                    layout[x][y] = random.nextInt(3);
                }
            }

        }
         for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
            if (layout[x][y] == 1){
                 ImageIcon pic = new ImageIcon("pics/baricade.png");
                 JLabel block = new JLabel();
                 block.setIcon(pic);
                 block.setBounds(locationX, locationY, 64, 64);
                 level.add(block);
                 
                 
            }else if (layout[x][y] == 2){
                 ImageIcon pic = new ImageIcon("pics/slot.png");
                 JLabel block = new JLabel();
                 block.setIcon(pic);
                 block.setBounds(locationX, locationY, 64, 64);
                 level.add(block);
                
            }else if (layout[x][y] == 3){
                 ImageIcon pic = new ImageIcon("pics/eind.png");
                 JLabel block = new JLabel();
                 block.setIcon(pic);
                 block.setBounds(locationX, locationY, 64, 64);
                 level.add(block);
            }
            locationY = locationY + 64;
            }
            locationX = locationX +64;
            locationY = 0;
    }
}
}
