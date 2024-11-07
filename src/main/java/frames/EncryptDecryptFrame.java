package frames;

import org.example.CaesarCipher;
import utils.FileManager;
import utils.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptDecryptFrame extends JFrame {
    private boolean isEncrypt;

    public EncryptDecryptFrame(String title, boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
        setTitle(title);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel fileLabel = new JLabel("Файл:");
        JTextField fileField = new JTextField();
        JLabel shiftLabel = new JLabel("Сдвиг:");
        JTextField shiftField = new JTextField();
        JLabel outputLabel = new JLabel("Выходной файл:");
        JTextField outputField = new JTextField();
        JButton processButton = new JButton(isEncrypt ? "Зашифровать" : "Расшифровать");

        panel.add(fileLabel);
        panel.add(fileField);
        panel.add(shiftLabel);
        panel.add(shiftField);
        panel.add(outputLabel);
        panel.add(outputField);
        panel.add(processButton);

        add(panel, BorderLayout.CENTER);

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = fileField.getText();
                int shift = Integer.parseInt(shiftField.getText());
                String outputFilePath = outputField.getText();

                FileManager fileManager = new FileManager();
                Validator validator = new Validator();

                if (!validator.isFileExists(filePath)) {
                    JOptionPane.showMessageDialog(null, "Файл не найден.");
                    return;
                }

                if (!validator.isValidKey(shift, CaesarCipher.ALPHABET)) {
                    JOptionPane.showMessageDialog(null, "Неверный сдвиг.");
                    return;
                }

                String text = fileManager.readFile(filePath);
                String resultText = isEncrypt ? CaesarCipher.encrypt(text, shift) : CaesarCipher.decrypt(text, shift);
                fileManager.writeFile(resultText, outputFilePath);

                JOptionPane.showMessageDialog(null, "Операция завершена.");
            }
        });

        setVisible(true);
    }
}