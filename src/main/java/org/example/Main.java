package org.example;

import frames.EncryptDecryptFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Caesar Cipher");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));

            JButton encryptButton = new JButton("Шифрование");
            JButton decryptButton = new JButton("Расшифровка");

            panel.add(encryptButton);
            panel.add(decryptButton);

            frame.add(panel, BorderLayout.CENTER);

            encryptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EncryptDecryptFrame("Шифрование", true);
                }
            });

            decryptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EncryptDecryptFrame("Расшифровка", false);
                }
            });

            frame.setVisible(true);
        });
    }
}