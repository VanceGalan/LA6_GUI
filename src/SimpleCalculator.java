import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JPanel mainPanel;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber1;
    private JLabel num2Label;
    private JLabel lblResult;
    private JLabel num1Label;

    public SimpleCalculator() {
        tfNumber1.setSize(20,10);

        cbOperations.addItem("+");
        cbOperations.addItem("-");
        cbOperations.addItem("*");
        cbOperations.addItem("/");
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        try {
            // Parse input values from text fields
            double num1 = Double.parseDouble(tfNumber1.getText());
            double num2 = Double.parseDouble(tfNumber2.getText());
            String operator = (String) cbOperations.getSelectedItem();
            double result = 0;

            // Perform calculation based on selected operator in combo box
            if (operator != null) {
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            lblResult.setText("Error: Div by 0");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
            }

            // Display the result in lblResult (format nicely to remove trailing .0 if whole number)
            if (result == (long) result) {
                lblResult.setText(String.format("%d", (long) result));
            } else {
                lblResult.setText(String.valueOf(result));
            }

        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setContentPane(new SimpleCalculator().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(700, 300);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
