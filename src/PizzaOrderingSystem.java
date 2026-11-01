import javax.swing.*;
import java.awt.*;

public class PizzaOrderingSystem {
    private JPanel mainPanel;
    private JLabel sizeLabel;
    private JComboBox<String> pizzaSizeChoice;
    private JComboBox<String> pizzaToppingsChoice;
    private JComboBox<String> extraCheeseChoice;
    private JButton calculateButton;
    private JLabel toppingsLabel;
    private JLabel cheeseLabel;
    private JLabel totalLabel;

    public PizzaOrderingSystem() {
        mainPanel.setName("mainPanel");
        sizeLabel.setName("sizeLabel");
        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaToppingsChoice.setName("pizzaToppingsChoice");
        extraCheeseChoice.setName("extraCheeseChoice");
        calculateButton.setName("calculateButton");
        toppingsLabel.setName("toppingsLabel");
        cheeseLabel.setName("cheeseLabel");
        totalLabel.setName("totalLabel");

        sizeLabel.setBorder(BorderFactory.createEmptyBorder(5,145,3,10));
        pizzaSizeChoice.addItem("Small");
        pizzaSizeChoice.addItem("Medium");
        pizzaSizeChoice.addItem("Large");
        pizzaSizeChoice.setPreferredSize(new Dimension(200, 10));

        toppingsLabel.setBorder(BorderFactory.createEmptyBorder(5,145,3,10));
        pizzaToppingsChoice.addItem("Mushroom");
        pizzaToppingsChoice.addItem("Pepperoni");
        pizzaToppingsChoice.addItem("Onions");
        pizzaToppingsChoice.setPreferredSize(new Dimension(200, 10));

        cheeseLabel.setBorder(BorderFactory.createEmptyBorder(5,145,3,10));
        extraCheeseChoice.addItem("Yes");
        extraCheeseChoice.addItem("No");
        extraCheeseChoice.setPreferredSize(new Dimension(200, 10));
//        extraCheeseChoice.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));

        calculateButton.addActionListener(e -> {

            double total = 0;

            if (pizzaSizeChoice.getSelectedItem() == "Small") {
                total += 12;
                if (extraCheeseChoice.getSelectedItem() == "Yes") {
                    total += 3;
                }
            } else if (pizzaSizeChoice.getSelectedItem() == "Medium") {
                total += 17;
                if (extraCheeseChoice.getSelectedItem() == "Yes") {
                    total += 3;
                }
            } else {
                total += 22;
                if (extraCheeseChoice.getSelectedItem() == "Yes") {
                    total += 3;
                }
            }

            String finalTotal = String.format("%.2f", total);
            totalLabel.setText(finalTotal);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pizza Order System");
        frame.setContentPane(new PizzaOrderingSystem().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500,400);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
