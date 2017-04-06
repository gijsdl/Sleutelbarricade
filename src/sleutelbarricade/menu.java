/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Gijs
 */
public class menu {

    private static JButton restart;
    private static JButton stop;

    private static final int FRAME_WIDTH = 216;
    private static final int FRAME_HIGHT = 400;
    public static JFrame menu = new JFrame();

    public static void main(String[] args) {
        
        menu.setTitle("menu");
        
        menu.setVisible(true);
        
        JLabel background = new JLabel();
        ImageIcon pic = new ImageIcon("pics/menubg.png");
        background.setIcon(pic);
        background.setBounds(0,0, 1023, 850);
        
        

        menu.setSize(FRAME_WIDTH, FRAME_HIGHT);
        restart = new JButton("reset");
        stop = new JButton("stop");
        JPanel Panel = new JPanel();
        restart.setBounds(50, 50, 100, 100);
        stop.setBounds(50, 200, 100, 100);
        
        
        Panel.setLayout(null);
        menu.add(background);
        background.setVisible(true);
        Panel.add(restart);
        Panel.add(stop);
        menu.add(Panel);
        
        
        ActionListener listener = new menu.ClickListener();
        restart.addActionListener(listener);
        stop.addActionListener(listener);


    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == restart) {
                System.out.println("restart");
            }
            if (e.getSource() == stop) {
               Level.level.setVisible(false);
               menu.setVisible(false);
               spelStart s = new spelStart();
               s.setVisible(true);
                //System.out.println("stop");
            }
        }

    }

}
