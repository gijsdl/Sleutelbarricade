/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gijs
 */
public class Menu_fill extends JFrame {

    private JButton restart;
    private JButton stop;

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HIGHT = 400;

    public Menu_fill() {
        createComponets();
        setSize(FRAME_WIDTH, FRAME_HIGHT);
    }

    public void createComponets() {
        restart = new JButton("reset");
        stop = new JButton("stop");
        JPanel Panel = new JPanel();
        restart.setBounds(50, 50, 100, 100);
        stop.setBounds(50, 200, 100, 100);

        Panel.setLayout(null);
        Panel.add(restart);
        Panel.add(stop);
        add(Panel);

        ActionListener listener = new ClickListener();
        restart.addActionListener(listener);
        stop.addActionListener(listener);

    }

    public class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == restart) {
                System.out.println("restart");
            }
            if (e.getSource() == stop) {
                System.out.println("stop");
            }
        }

    }
}
