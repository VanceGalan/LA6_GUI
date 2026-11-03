import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PasswordValidator {
    private JPanel mainPanel;
    private JPasswordField passwordTextField; // Changed to JPasswordField to support echo characters
    private JLabel statusLabel;

    public PasswordValidator() {
        // 1. Set component names for automated grading/testing
        passwordTextField.setName("passwordTextField");
        statusLabel.setName("statusLabel");

        // 2. Set the echo character to '*'
        passwordTextField.setEchoChar('*');

        // 3. Add DocumentListener to trigger validation on text change (Swing equivalent)
        DocumentListener validatorListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { validatePassword(); }
            @Override
            public void removeUpdate(DocumentEvent e) { validatePassword(); }
            @Override
            public void changedUpdate(DocumentEvent e) { validatePassword(); }
        };

        passwordTextField.getDocument().addDocumentListener(validatorListener);

        // Run initial check for empty state
        validatePassword();
    }

    private void validatePassword() {
        String password = new String(passwordTextField.getPassword());

        // Criteria 1: Length check (at least 8 characters)
        if (password.length() < 8) {
            statusLabel.setText("Password must be 8 characters long");
            statusLabel.setForeground(Color.RED);
            return;
        }

        // Criteria 2: Digit check
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        if (!hasDigit) {
            statusLabel.setText("Password must contain at least one digit");
            statusLabel.setForeground(Color.RED);
            return;
        }

        // Criteria 3: Special character check
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
                break;
            }
        }
        if (!hasSpecial) {
            statusLabel.setText("Password must contain at least one special character");
            statusLabel.setForeground(Color.RED);
            return;
        }

        // Criteria 4: Valid Password
        statusLabel.setText("Password is valid");
        statusLabel.setForeground(Color.GREEN);



    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(("Password Validator"));
        frame.setContentPane(new PasswordValidator().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(400, 200);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
