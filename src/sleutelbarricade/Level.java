package sleutelbarricade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris Bruijn, Ruben Bijck, Gijs de Lange
 */
public class Level {
// lengte en breedte van de JFrame initialiseren en een Jlabel aanmaken voor het poppetje.

    private static final int FRAME_WIDTH = 656;
    private static final int FRAME_HIGHT = 730;

    private static JFrame level = new Poppetje();

    public static void main(String[] args) {
//De rest van de waarden voor level instellen.
        level.setTitle("Sleutel Barricade");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(FRAME_WIDTH, FRAME_HIGHT);
        level.setLayout(new BorderLayout());
        level.getContentPane().setBackground(new Color(65, 116, 14));
// generate starten
        generateLevel(0);

        Poppetje.setCordX(0);
        Poppetje.setCordY(0);
        Poppetje.setSleutel(0);

    }
//start icon tekenen.

    public static void generateTegelStart() {
        
        JLabel block = new JLabel();
        block.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/kasteel.png")));
        block.setBounds(locationX, locationY, 64, 64);
        level.add(block);
    }
//lege tegel tekenen.

    public static void generateTegel() {
        
        JLabel block = new JLabel();

        block.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/niks.png")));
        block.setBounds(locationX, locationY, 64, 64);
        level.add(block);

    }
//muur tekenen.

    public static void generateMuur() {
        
        JLabel block = new JLabel();
        block.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/muur.png")));
        block.setBounds(locationX, locationY, 64, 64);
        level.add(block);
    }
//eintegel tekenen.

    public static void generateTegelEind() {
        
        JLabel block = new JLabel();
        block.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/eind.png")));
        block.setBounds(locationX, locationY, 64, 64);
        level.add(block);
    }
//als het nodig is barricade tekenen.

    public static void generateBarricade(int pincode, int x, int y, int status) {
        if (status == 1) {
            
            JLabel block = new JLabel();
            block.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/slot.png")));
            block.setBounds(locationX, locationY, 64, 64);

            Barricade barricade = new Barricade(x, y, pincode, status, barricadeNummer);
            JLabel code = new JLabel();
            code.setText(String.valueOf(pincode));
            code.setBounds(locationX + 22, locationY + 40, 30, 20);
            level.add(code);
            level.add(block);
        }
        barricadeNummer++;
    }
// als het nodig is sleutel tekenen.

    public static void generateSleutel(int pincode, int x, int y, int status) {
        if (status == 1) {
            
            JLabel block = new JLabel();
            block.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/sleutel.png")));
            block.setBounds(locationX, locationY, 64, 64);
            level.add(block);
            Sleutel_tegel block1 = new Sleutel_tegel(x, y, pincode, status, sleutelNummer);
            JLabel code = new JLabel();
            code.setText(String.valueOf(pincode));
            code.setBounds(locationX + 25, locationY + 40, 30, 20);
            level.add(code);
            level.add(block);
        }
        sleutelNummer++;
    }
//De rest van het JFrame toevoegen.

    public static void componenten() {

        JButton menu = new JButton("menu");
        menu.setBounds(10, 650, 100, 30);
        JButton restart = new JButton("reset");
        restart.setBounds(120, 650, 100, 30);
        JLabel sleutel = new JLabel();
        if (Poppetje.getSleutel() == 0) {
            sleutel.setText("U heeft geen sleutel");
        } else {
            sleutel.setText("Uw sleutel is " + String.valueOf(Poppetje.getSleutel()));
        }

        sleutel.setBounds(400, 650, 200, 30);
        ActionListener listener = new Level.ClickListener();
        ActionListener listener2 = new Level.ClickListener2();
        menu.addActionListener(listener);
        restart.addActionListener(listener2);
        JLabel background = new JLabel();
        
        background.setIcon(new javax.swing.ImageIcon(Level.class.getResource("/sleutelbarricade/pics/background.png")));
        background.setBounds(0, 0, 640, 640);
        level.add(background);

        level.setLayout(null);
        level.add(sleutel);
        level.add(menu);
        level.add(restart);
        level.setVisible(true);

        level.repaint();
    }

    //Intialiseren van de waarden die nodig zijn.
    private static int locationX = 0;
    private static int locationY = 0;
    private static int[][] layout;
    static Random random = new Random();
    private static int sleutelNummer = 0;
    private static int currentlevel = 0;
    private static int barricadeNummer = 0;

    public static void generateLevel(int win) {
        // Current level opslaan voor het reseten en opnieuw tekenen. 
        currentlevel = win;

        barricadeNummer = 0;
        sleutelNummer = 0;
        level.getContentPane().removeAll();
        locationX = 0;
        locationY = 0;
        Barricade.reset();
        Sleutel_tegel.reset();
        // Kijken welke lavel hij moet genereren.
        if (win == 0) {
            layout = level1;

        } else if (win == 1) {
            layout = level2;

        } else if (win == 2) {
            layout = level3;

        }
        // Blokken die op die lokatie aanwezig moeten zijn plaatsen en indien nodig ook een pincode erbij zetten.
        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 0) {
                    generateTegel();

                } else if (layout[x][y] == 1) {
                    generateMuur();

                } else if (layout[x][y] == 2) {

                    Random rand = new Random();
                    int random = rand.nextInt(3) + 1;
                    int pincode = random * 25;
                    int status = 1;
                    generateBarricade(pincode, x, y, status);
                    Barricade.store();

                } else if (layout[x][y] == 3) {
                    generateTegelEind();

                } else if (layout[x][y] == 4) {
                    int pincode = 100;
                    int status = 1;
                    generateSleutel(pincode, x, y, status);
                    Sleutel_tegel.store();

                } else if (layout[x][y] == 5) {
                    int pincode = 200;
                    int status = 1;
                    generateSleutel(pincode, x, y, status);
                    Sleutel_tegel.store();

                } else if (layout[x][y] == 6) {
                    int pincode = 300;
                    int status = 1;
                    generateSleutel(pincode, x, y, status);
                    Sleutel_tegel.store();

                } else if (layout[x][y] == 7) {
                    int pincode = 400;
                    int status = 1;
                    generateSleutel(pincode, x, y, status);
                    Sleutel_tegel.store();

                } else if (layout[x][y] == 8) {
                    int pincode = 100;
                    int status = 1;
                    generateBarricade(pincode, x, y, status);
                    Barricade.store();

                } else if (layout[x][y] == 9) {
                    int pincode = 200;
                    int status = 1;
                    generateBarricade(pincode, x, y, status);
                    Barricade.store();

                } else if (layout[x][y] == 10) {
                    int pincode = 300;
                    int status = 1;
                    generateBarricade(pincode, x, y, status);
                    Barricade.store();

                } else if (layout[x][y] == 11) {
                    int pincode = 400;
                    int status = 1;
                    generateBarricade(pincode, x, y, status);
                    Barricade.store();

                } else if (layout[x][y] == 12) {
                    generateTegelStart();
                }

                locationY = locationY + 64;
            }
            locationX = locationX + 64;
            locationY = 0;
        }
        componenten();
    }

    // het opnieuw tekenen van het JFrame om de opgehaalde sleutel en geöpende barricade weg te halen.
    public static void redraw(int win) {
        barricadeNummer = 0;
        sleutelNummer = 0;
        level.getContentPane().removeAll();
        locationX = 0;
        locationY = 0;
        if (win == 0) {
            layout = level1;

        } else if (win == 1) {
            layout = level2;

        } else if (win == 2) {
            layout = level3;

        }

        for (int x = 0; x < layout.length; x++) {
            for (int y = 0; y < layout.length; y++) {
                if (layout[x][y] == 0) {
                    generateTegel();

                } else if (layout[x][y] == 1) {
                    generateMuur();

                } else if (layout[x][y] == 2) {
                    int pincode = Barricade.barricadePincode(barricadeNummer);
                    int status = 1;
                    generateBarricade(pincode, x, y, status);

                } else if (layout[x][y] == 3) {
                    generateTegelEind();

                } else if (layout[x][y] == 4) {

                    int pincode = 100;
                    int status;
                    //kijken bij Sleutel_tegel of het plaatje nog afgedukt moet worden.
                    boolean place = Sleutel_tegel.statusCheack(sleutelNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateSleutel(pincode, x, y, status);

                } else if (layout[x][y] == 5) {
                    int pincode = 200;
                    int status;
                    boolean place = Sleutel_tegel.statusCheack(sleutelNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateSleutel(pincode, x, y, status);

                } else if (layout[x][y] == 6) {
                    int pincode = 300;
                    int status;
                    boolean place = Sleutel_tegel.statusCheack(sleutelNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateSleutel(pincode, x, y, status);

                } else if (layout[x][y] == 7) {
                    int pincode = 400;
                    int status;
                    boolean place = Sleutel_tegel.statusCheack(sleutelNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateSleutel(pincode, x, y, status);

                } else if (layout[x][y] == 8) {
                    int pincode = 100;
                    int status;
                    //Kijken bij Barricade of dit plaatje nog afgedrukt moet worden.
                    boolean place = Barricade.statusCheack(barricadeNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateBarricade(pincode, x, y, status);

                } else if (layout[x][y] == 9) {
                    int pincode = 200;
                    int status;
                    boolean place = Barricade.statusCheack(barricadeNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateBarricade(pincode, x, y, status);

                } else if (layout[x][y] == 10) {
                    int pincode = 300;
                    int status;
                    boolean place = Barricade.statusCheack(barricadeNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateBarricade(pincode, x, y, status);

                } else if (layout[x][y] == 11) {
                    int pincode = 400;
                    int status;
                    boolean place = Barricade.statusCheack(barricadeNummer);
                    if (place == true) {
                        status = 1;
                    } else {
                        status = 0;
                    }
                    generateBarricade(pincode, x, y, status);

                } else if (layout[x][y] == 12) {
                    generateTegelStart();
                }

                locationY = locationY + 64;
            }
            locationX = locationX + 64;
            locationY = 0;
        }
        componenten();
    }
//Void voor het luisteren van de stop button.

    private static class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Spel sluiten en menu opstarten.
            Level.level.setVisible(false);
            spelStart s = new spelStart();
            s.setVisible(true);
        }

    }

//Void voor het luisteren van de reset button.
    private static class ClickListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // het reseten van het level en coördinaten van poppetje.
            Poppetje.setCordX(0);
            Poppetje.setCordY(0);
            Poppetje.setSleutel(0);
            generateLevel(currentlevel);

        }

    }
    //Level 1 ,2 en 3 initialiseren.
    //0 = tegel
    //1 = muur
    //2 = neppe barricade
    //3 = eind tegel
    //4 = sleutel 100
    //5 = sleutel 200
    //6 = sleutel 300
    //7 = sleutel 400
    //8 = barricade 100
    //9 = barricade 200
    //10 = barricade 300
    //11 = barricade 400
    //12 = start kasteel
    //Note X en Y worden omgedraait. Dus de rij naar links gaat naar beneden.

    private static int[][] level1 = {
        {12, 1, 8, 0, 0, 0, 0, 2, 2, 2},
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
        {12, 1, 1, 1, 0, 0, 5, 1, 1, 6},
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
        {0, 0, 0, 1, 0, 10, 1, 0, 0, 0},
        {0, 0, 0, 8, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 8, 8, 9, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 8, 0, 0, 0, 0},
        {4, 0, 0, 0, 9, 8, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 10, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0, 0, 3}
    };

    private static int[][] level3 = {
        {12, 0, 4, 1, 1, 1, 0, 0, 0, 0},
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
//Het checken of het poppetje naar de plek toe kan lopen waar hij naar toe wil.

    public static boolean checkMovement(int x, int y, int sleutel, int win) {
        boolean check = false;
        // Zorgen dat het poppetje niet uit het veld loopt.
        if (x > 9 || y > 9 || x < 0 || y < 0) {
            check = false;
            //Kijken met de rest van de blokken.
        } else if (layout[x][y] == 0) {
            check = true;
        } else if (layout[x][y] == 1) {
            check = false;
        } else if (layout[x][y] == 2) {
            //Kijken of het poppetje een sleutel heeft. Deze barricade is voor de sier dus is de uitkomst altijd false.
            if (sleutel == 0) {
                JOptionPane.showMessageDialog(level, "U heeft geen sleutel");

            } else {
                JOptionPane.showMessageDialog(level, "Deze sleutel past niet.");
            }
            check = false;
        } else if (layout[x][y] == 3) {
            check = true;

        } else if (layout[x][y] == 4 || layout[x][y] == 5 || layout[x][y] == 6 || layout[x][y] == 7) {
            check = true;
            // kijken bij Sleutel_tegel of hij een sleutel krijgt.
            Sleutel_tegel.sleutelcheck(x, y);
            redraw(win);

        } else if (layout[x][y] == 8 || layout[x][y] == 9 || layout[x][y] == 10 || layout[x][y] == 11) {
            //kijken bij Barricade of het poppetje de juist sleutel heeft om de barricade te openen.
            boolean open = Barricade.barricadeCheck(x, y, sleutel);
            if (open == true) {

                check = true;
                redraw(win);

            } else {
                //Kijken of het poppetje een sleutel heeft.
                if (sleutel == 0) {
                    JOptionPane.showMessageDialog(level, "U heeft geen sleutel");

                } else {
                    JOptionPane.showMessageDialog(level, "Deze sleutel past niet.");
                }
                check = false;
            }
        } else if (layout[x][y] == 12) {
            check = true;
        }

        return check;

    }

}
