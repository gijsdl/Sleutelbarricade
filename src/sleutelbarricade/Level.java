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

    private static final int FRAME_WIDTH = 640;
    private static final int FRAME_HIGHT = 640;
    
    public static void main(String[] args) {
        
        JFrame level = new JFrame();
        level.setTitle("level");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setVisible(true);
        level.setSize(FRAME_WIDTH, FRAME_HIGHT);
        level.setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("/pics/background.png"));
        background.setSize(640, 640);
        level.setLayout(null);
        level.add(background);
        
        
        generate();
        
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                System.out.printf("%8d", layout[x][y]);

            }
            System.out.println("");
        }
    }

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
    }
}
