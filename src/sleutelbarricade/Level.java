/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.UUID;
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

    public static JFrame level = new Poppetje();

    public static void main(String[] args) {

        level.setTitle("level");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(FRAME_WIDTH, FRAME_HIGHT);
        level.setLayout(new BorderLayout());
        level.getContentPane().setBackground(new Color(65, 116, 14));

        generate(0);

    }
    private static int locationX = 0;
    private static int locationY = 0;

    private static int[][] layout;
    static Random random = new Random();
    private static int sleutelNummer = 0;

    private static int barricadeNummer = 0;

    public static void generate(int win) {
        if (win == 0) {
            layout = level1;
            Barricade.reset();
            Sleutel_tegel.reset();
            barricadeNummer = 0;
            sleutelNummer = 0;
            level.getContentPane().removeAll();
            locationX = 0;
            locationY = 0;
        } else if (win == 1) {
            layout = level2;

            Barricade.reset();
            Sleutel_tegel.reset();
            level.getContentPane().removeAll();
            level.setVisible(false);
            locationX = 0;
            locationY = 0;

            barricadeNummer = 0;
            sleutelNummer = 0;
            System.out.println("test");
        } else if (win == 2) {
            layout = level3;
            Barricade.reset();
            Sleutel_tegel.reset();
            barricadeNummer = 0;
            sleutelNummer = 0;
            level.getContentPane().removeAll();
            locationX = 0;
            locationY = 0;
        }

        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 0) {

                    ImageIcon pic = new ImageIcon("pics/niks.png");
                    JLabel block = new JLabel();

                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                }
                if (layout[x][y] == 1) {
                    ImageIcon pic = new ImageIcon("pics/muur.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);

                } else if (layout[x][y] == 2) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = random.nextInt(3) + 1;
                    pincode = pincode * 25;
                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 3) {
                    ImageIcon pic = new ImageIcon("pics/eind.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);

                } else if (layout[x][y] == 4) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 100;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 5) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 200;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 6) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 300;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 7) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 400;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 8) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 100;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 9) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 200;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 10) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 300;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 11) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 400;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                }
                locationY = locationY + 64;
            }
            locationX = locationX + 64;
            locationY = 0;
        }
        JButton menu = new JButton("menu");
        menu.setBounds(10, 650, 100, 30);
        JButton restart = new JButton("reset");
        restart.setBounds(120, 650, 100, 30);
        ActionListener listener = new Level.ClickListener();
        menu.addActionListener(listener);
        restart.addActionListener(listener);
        JLabel background = new JLabel();
        ImageIcon pic = new ImageIcon("pics/background.png");
        background.setIcon(pic);
        background.setBounds(0, 0, 640, 640);
        level.add(background);

        level.setLayout(null);
        level.add(menu);
        level.add(restart);
        level.setVisible(true);
        System.out.println("test2");
        level.repaint();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Level.level.setVisible(false);
            spelStart s = new spelStart();
            s.setVisible(true);
        }

    }

    private static int[][] level1 = {
        {0, 1, 8, 0, 0, 0, 0, 2, 2, 2},
        {0, 0, 0, 0, 4, 6, 0, 2, 2, 2},
        {0, 0, 8, 0, 0, 0, 0, 10, 10, 4},
        {0, 1, 8, 0, 0, 0, 0, 2, 2, 2},
        {0, 1, 8, 8, 1, 1, 1, 2, 8, 2},
        {0, 9, 8, 0, 0, 0, 1, 8, 2, 0},
        {0, 1, 8, 1, 1, 10, 1, 1, 0, 0},
        {0, 1, 8, 2, 2, 8, 0, 0, 0, 0},
        {5, 1, 8, 2, 0, 0, 0, 1, 0, 0},
        {0, 1, 8, 2, 0, 0, 0, 1, 0, 3}
    };

    private static int[][] level2 = {
        {0, 1, 1, 1, 0, 0, 5, 1, 1, 6},
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
        {0, 0, 0, 1, 0, 10, 1, 0, 0, 0},
        {0, 0, 0, 8, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 8, 8, 9, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 8, 0, 0, 0, 0},
        {4, 0, 0, 0, 5, 8, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 10, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0, 0, 3}
    };

    private static int[][] level3 = {
        {0, 0, 4, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 5, 1, 9, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
        {1, 1, 8, 0, 0, 0, 5, 2, 10, 10},
        {6, 9, 0, 0, 0, 0, 2, 2, 0, 1},
        {1, 1, 1, 1, 1, 10, 8, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 0, 1, 11, 11},
        {1, 1, 0, 0, 0, 2, 2, 1, 0, 0},
        {1, 7, 0, 0, 0, 0, 0, 1, 0, 3}
    };

    public static boolean check(int x, int y, UUID uuid, int sleutel) {
        boolean check = false;
        if (x > 9 || y > 9 || x < 0 || y < 0) {
            check = false;
        } else if (layout[x][y] == 0) {
            check = true;
        } else if (layout[x][y] == 1) {
            check = false;
        } else if (layout[x][y] == 3) {
            check = true;
        } else if (layout[x][y] == 4 || layout[x][y] == 5 || layout[x][y] == 6 || layout[x][y] == 7) {
            check = true;

            Sleutel_tegel.sleutelcheck(x, y, uuid);

        } else if (layout[x][y] == 8 || layout[x][y] == 9 || layout[x][y] == 10 || layout[x][y] == 11) {
            System.out.println(x + " " + y + " " + sleutel + " " +  "test");
            boolean open = Barricade.boxCheck(x, y, sleutel);
            if (open == true) {
                System.out.println("open");
                check = true;
            } else {
                System.out.println("close");
                check = false;
            }
        }

        return check;

    }
    public void redraw(int win){
        if (win == 0) {
            layout = level1;
            Barricade.reset();
            Sleutel_tegel.reset();
            barricadeNummer = 0;
            sleutelNummer = 0;
            level.getContentPane().removeAll();
            locationX = 0;
            locationY = 0;
        } else if (win == 1) {
            layout = level2;

            Barricade.reset();
            Sleutel_tegel.reset();
            level.getContentPane().removeAll();
            level.setVisible(false);
            locationX = 0;
            locationY = 0;

            barricadeNummer = 0;
            sleutelNummer = 0;
            System.out.println("test");
        } else if (win == 2) {
            layout = level3;
            Barricade.reset();
            Sleutel_tegel.reset();
            barricadeNummer = 0;
            sleutelNummer = 0;
            level.getContentPane().removeAll();
            locationX = 0;
            locationY = 0;
        }

        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 0) {

                    ImageIcon pic = new ImageIcon("pics/niks.png");
                    JLabel block = new JLabel();

                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                }
                if (layout[x][y] == 1) {
                    ImageIcon pic = new ImageIcon("pics/muur.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);

                } else if (layout[x][y] == 2) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = random.nextInt(3) + 1;
                    pincode = pincode * 25;
                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 3) {
                    ImageIcon pic = new ImageIcon("pics/eind.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);

                } else if (layout[x][y] == 4) {
                    boolean place = Sleutel_tegel.placeCheack(sleutelNummer);
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 100;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    
                    sleutelNummer++;

                } else if (layout[x][y] == 5) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 200;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 6) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 300;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 7) {
                    ImageIcon pic = new ImageIcon("pics/sleutel.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);
                    level.add(block);
                    int pincode = 400;
                    int status = 1;
                    Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Sleutel_tegel.store();
                    sleutelNummer++;

                } else if (layout[x][y] == 8) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 100;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 9) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 200;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 10) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 300;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                } else if (layout[x][y] == 11) {
                    ImageIcon pic = new ImageIcon("pics/slot.png");
                    JLabel block = new JLabel();
                    block.setIcon(pic);
                    block.setBounds(locationX, locationY, 64, 64);

                    int pincode = 400;

                    int status = 1;
                    Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
                    JLabel code = new JLabel();
                    code.setText(String.valueOf(pincode));
                    code.setBounds(locationX, locationY, 64, 64);
                    level.add(code);
                    level.add(block);
                    Barricade.store();
                    barricadeNummer++;

                }
                locationY = locationY + 64;
            }
            locationX = locationX + 64;
            locationY = 0;
        }
        JButton menu = new JButton("menu");
        menu.setBounds(10, 650, 100, 30);
        JButton restart = new JButton("reset");
        restart.setBounds(120, 650, 100, 30);
        ActionListener listener = new Level.ClickListener();
        menu.addActionListener(listener);
        restart.addActionListener(listener);
        JLabel background = new JLabel();
        ImageIcon pic = new ImageIcon("pics/background.png");
        background.setIcon(pic);
        background.setBounds(0, 0, 640, 640);
        level.add(background);

        level.setLayout(null);
        level.add(menu);
        level.add(restart);
        level.setVisible(true);
        System.out.println("test2");
        level.repaint();
    }
    }
}