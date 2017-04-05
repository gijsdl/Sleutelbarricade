/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Gijs
 */
public class Level {

    private static final int FRAME_WIDTH = 656;
    private static final int FRAME_HIGHT = 730;

    private static JFrame level = new JFrame();

    public static void main(String[] args) {

        level.setTitle("level");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(FRAME_WIDTH, FRAME_HIGHT);
        level.setLayout(new BorderLayout());

        JLabel background = new JLabel();
        ImageIcon pic = new ImageIcon("pics/background.png");
        background.setIcon(pic);
        background.setBounds(0, 0, 640, 640);

        JButton menu = new JButton("menu");
        menu.setBounds(10, 650, 100, 30);
        ActionListener listener = new Level.ClickListener();
        menu.addActionListener(listener);

        generate();
        level.add(background);
        level.add(menu);
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
    private static int win = 0;

    private static int sleutelNummer = 0;
    private static int barricadeNummer = 0;

    public static void generate() {
        if (win == 0) {
            layout = level1;
        } else if (win == 1) {
            layout = level2;
            Barricade.reset();
            Sleutel_tegel.reset();
        } else if (win == 2) {
            layout = level3;
            Barricade.reset();
            Sleutel_tegel.reset();
        }

        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 1) {
                    ImageIcon pic = new ImageIcon("pics/baricade.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 100;
                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 2) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);

                } else if (layout[x][y] == 3) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 100;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 4) {
                    ImageIcon pic = new ImageIcon("pics/eind.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);

                }
                locationY = locationY + 64;
            }
            locationX = locationX + 64;
            locationY = 0;
        }
    }

    private static class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] args = null;
            menu.main(args);

        }

    }

    private static int[][] level1 = {
        {0, 1, 2, 0, 0, 0, 0, 2, 2, 2},
        {0, 0, 0, 0, 3, 3, 0, 2, 2, 2},
        {0, 0, 2, 0, 0, 0, 0, 2, 2, 3},
        {0, 1, 2, 0, 0, 0, 0, 2, 2, 2},
        {0, 1, 2, 2, 1, 1, 1, 2, 2, 2},
        {0, 0, 2, 0, 0, 0, 1, 2, 2, 0},
        {0, 1, 2, 1, 1, 2, 1, 1, 0, 0},
        {0, 1, 2, 2, 2, 2, 0, 0, 0, 0},
        {3, 1, 2, 2, 0, 0, 0, 1, 0, 0},
        {0, 1, 2, 2, 0, 0, 0, 1, 0, 4}
    };

    private static int[][] level2 = {
        {0, 1, 1, 1, 0, 0, 3, 1, 1, 3},
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
        {0, 0, 0, 1, 0, 2, 1, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 2, 2, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 2, 0, 0, 0, 0},
        {3, 0, 0, 0, 2, 2, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0, 0, 4}
    };

    private static int[][] level3 = {
        {0, 0, 3, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 2, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 3, 1, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
        {1, 1, 2, 0, 0, 0, 3, 2, 2, 2},
        {3, 2, 0, 0, 0, 0, 2, 2, 0, 1},
        {1, 1, 1, 1, 0, 2, 2, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 0, 1, 2, 2},
        {1, 0, 0, 0, 0, 2, 2, 1, 0, 0},
        {1, 3, 0, 0, 0, 0, 0, 1, 0, 4}
    };

}
