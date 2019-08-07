package com.jyoonpro.bnc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;

public class Main extends JPanel {
    private JTextField digit1;
    private JTextField digit2;
    private JTextField digit3;
    private JTextField digit4;
    private JButton guess;
    private JList<String> resultList;
    private JButton newGame;
    private JLabel comment;

    Game game;

    public Main() {
        //construct preComponents
        DefaultListModel<String> model = new DefaultListModel<>();

        //construct components
        digit1 = new JTextField (5);
        digit2 = new JTextField (5);
        digit3 = new JTextField (5);
        digit4 = new JTextField (5);
        guess = new JButton ("GUESS");
        resultList = new JList<>(model);
        newGame = new JButton ("New Game");
        comment = new JLabel ("Guess the number!");

        //adjust size and set layout
        setPreferredSize (new Dimension (671, 284));
        setLayout (null);

        //add components
        add (digit1);
        add (digit2);
        add (digit3);
        add (digit4);
        add (guess);
        add (resultList);
        add (newGame);
        add (comment);

        //set component bounds (only needed by Absolute Positioning)
        digit1.setBounds (85, 80, 60, 60);
        digit2.setBounds (155, 80, 60, 60);
        digit3.setBounds (225, 80, 60, 60);
        digit4.setBounds (295, 80, 60, 60);
        guess.setBounds (85, 160, 270, 60);
        resultList.setBounds (425, 80, 165, 140);
        newGame.setBounds (485, 30, 100, 25);
        comment.setBounds (85, 30, 270, 25);

        // Set fonts
        Font font = new Font("SansSerif", Font.BOLD, 30);

        digit1.setFont(font);
        digit1.setHorizontalAlignment(JTextField.CENTER);
        digit2.setFont(font);
        digit2.setHorizontalAlignment(JTextField.CENTER);
        digit3.setFont(font);
        digit3.setHorizontalAlignment(JTextField.CENTER);
        digit4.setFont(font);
        digit4.setHorizontalAlignment(JTextField.CENTER);

        // Set action listeners
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game = new Game();
                clear();
                model.clear();
            }
        });
        guess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String a1 = digit1.getText(0, 1);
                    String a2 = digit2.getText(0, 1);
                    String a3 = digit3.getText(0, 1);
                    String a4 = digit4.getText(0, 1);

                    String response = game.checkAns(a1, a2, a3, a4);
                    if (response.equals("Correct!")) {
                        model.add(0, String.format("Correct! Finished in %d turns.", game.turn));
                    } else if (response.equals("Duplicate")) {
                        clear();
                    } else {
                        model.add(0, String.format("%d. %s%s%s%s : %s", game.turn, a1, a2, a3, a4, response));
                        clear();
                    }

                } catch (BadLocationException e) {
                    e.printStackTrace();
                    clear();
                }
            }
        });

        digit1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                digit2.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        digit2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                digit3.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        digit3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                digit4.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        digit4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                guess.requestFocus();
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        game = new Game();
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Main());
        frame.pack();
        frame.setVisible (true);
    }

    private void clear() {
        digit1.setText("");
        digit2.setText("");
        digit3.setText("");
        digit4.setText("");
        digit1.requestFocus();
    }
}
