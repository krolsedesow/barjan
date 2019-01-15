package com.barjan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BeatTheBoss extends JFrame implements ActionListener {


    private JButton P1punch, BExit, P2punch, P1Critical, P2Critical, AgeVer1, AgeVer2;
    private JLabel ShowHPP2, ShowHPP1;
    private JLabel Damage, Damage2;
    private JLabel NumLevel, LevelCrit;
    private JLabel Age1, Age2;
    private JTextField WriteAge1, WriteAge2;
    private double tempAge1, tempAge2;
    private int HPP2 = 100;
    private int HPP1 = 100;
    private int level = 0;


    public BeatTheBoss() {
        setSize(400, 500);
        setTitle("Mortal Punch");
        setBackground(Color.GREEN);
        setLayout(null);

        P1punch = new JButton(" P1 Punch!");
        P1punch.setBounds(20, 40, 120, 20);
        add(P1punch);
        P1punch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random PlayerPunch = new Random();

                HPP2 = HPP2 - PlayerPunch.nextInt(15);

                Damage.setText(String.valueOf(HPP2));

                NumLevel.setText("Level: " + String.valueOf(level));
                level++;
            }
        });

        P2punch = new JButton(" P2 Punch!");
        P2punch.setBounds(20, 100, 120, 20);
        add(P2punch);
        P2punch.addActionListener(this);

        P1Critical = new JButton(" P1 Critical Hit!");
        P1Critical.setBounds(20, 200, 120, 20);
        add(P1Critical);
        P1Critical.addActionListener(this);

        P2Critical = new JButton(" P2 Critical Hit!");
        P2Critical.setBounds(180, 200, 120, 20);
        add(P2Critical);
        P2Critical.addActionListener(this);

        BExit = new JButton("Exit");
        BExit.setBounds(140, 400, 100, 20);
        add(BExit);
        BExit.addActionListener(this);

        AgeVer1 = new JButton(" P1 Verify");
        AgeVer1.setBounds(250, 250, 100, 20);
        add(AgeVer1);
        AgeVer1.addActionListener(this);

        AgeVer2 = new JButton("P2 Verify");
        AgeVer2.setBounds(250, 300, 100, 20);
        add(AgeVer2);
        AgeVer2.addActionListener(this);

        Age1 = new JLabel("Write your Age P1 : ");
        Age1.setBounds(20, 250, 120, 20);
        add(Age1);

        Age2 = new JLabel("Write your Age P2 : ");
        Age2.setBounds(20, 300, 120, 20);
        add(Age2);

        WriteAge1 = new JTextField(" ");
        WriteAge1.setBounds(150, 250, 120, 20);
        add(WriteAge1);

        WriteAge2 = new JTextField(" ");
        WriteAge2.setBounds(150, 300, 120, 20);
        add(WriteAge2);

        ShowHPP2 = new JLabel("Player 2 HP");
        ShowHPP2.setBounds(200, 40, 100, 20);
        add(ShowHPP2);

        ShowHPP1 = new JLabel("Player 1 HP");
        ShowHPP1.setBounds(200, 100, 100, 20);
        add(ShowHPP1);

        LevelCrit = new JLabel("Critial Hit Use Ones");
        LevelCrit.setBounds(120, 150, 150, 20);
        LevelCrit.setForeground(Color.magenta);
        add(LevelCrit);


        Damage = new JLabel(" ");
        Damage.setBounds(300, 40, 100, 20);
        Damage.setForeground(Color.red);
        add(Damage);

        Damage2 = new JLabel(" ");
        Damage2.setBounds(300, 100, 100, 20);
        Damage2.setForeground(Color.red);
        add(Damage2);

        NumLevel = new JLabel("Level: " + level);
        NumLevel.setBounds(150, 15, 150, 20);
        NumLevel.setForeground(Color.BLUE);
        NumLevel.setFont(new Font("<changeme>", Font.PLAIN, 16));
        add(NumLevel);

    }

    // public void windowActivated(WindowEvent event){}
    public static void main(String[] args) {

        BeatTheBoss MyWindow = new BeatTheBoss();
        MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyWindow.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        {

            {
                if (source == P1Critical) {
                    Random P1CHit = new Random();
                    HPP2 = HPP2 - P1CHit.nextInt(50);
                    Damage.setText(String.valueOf(HPP2));


                }
                if (HPP2 <= 0) {
                    JOptionPane.showMessageDialog(null, "Player 1 Win!");


                } else if (source == P2punch) {
                    Random PlayerPunch2 = new Random();

                    HPP1 = HPP1 - PlayerPunch2.nextInt(15);

                    Damage2.setText(String.valueOf(HPP1));
                    NumLevel.setText("Level: " + String.valueOf(level));
                    level++;
                } else if (source == P2Critical) {

                    Random P2CHit = new Random();
                    HPP1 = HPP1 - P2CHit.nextInt(50);
                    Damage2.setText(String.valueOf(HPP1));
                }
                if (HPP1 <= 0) {
                    JOptionPane.showMessageDialog(null, "Player 2 Win!");
                }


                if (source == AgeVer1) {
                    tempAge1 = Double.parseDouble(WriteAge1.getText());
                    if (tempAge1 < 18) {
                        JOptionPane.showMessageDialog(null, "You are too Young!");
                        dispose();


                        if (tempAge1 > 18) {
                            JOptionPane.showMessageDialog(null, "You are Redy to GO!");
                        }
                    }
                }
                if (source == AgeVer2) {
                    tempAge2 = Double.parseDouble(WriteAge1.getText());
                    if (tempAge2 < 18) {
                        JOptionPane.showMessageDialog(null, "You are too Young!");
                        dispose();
                        if (tempAge2 > 18) {
                            JOptionPane.showMessageDialog(null, "You are Redy to GO!");
                        }
                    }}
                if (source == BExit) {
                    dispose();
                }
            }
        }
    }
}






