import javax.swing.*;

public class FoodOrderingSystem {
    private JPanel mainPanel;
    private JLabel foodChoices;
    private JLabel discountChoices;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JButton btnOrder;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JLabel pricePizza;
    private JLabel priceBurger;
    private JLabel priceFries;
    private JLabel priceSoftDrinks;
    private JLabel price;
    private JLabel priceSundae;
    private JLabel orderLabel;

    public FoodOrderingSystem() {

        ButtonGroup discountBtn = new ButtonGroup();
        discountBtn.add(rbNone);
        discountBtn.add(rb5);
        discountBtn.add(rb10);
        discountBtn.add(rb15);

        btnOrder.addActionListener(e -> {
            double price = 0;

            if (cPizza.isSelected()) {
                price += 100;
            }
            if (cBurger.isSelected()) {
                price += 80;
            }
            if (cFries.isSelected()) {
                price += 65;
            }
            if (cSoftDrinks.isSelected()) {
                price += 55;
            }
            if (cTea.isSelected()) {
                price += 50;
            }
            if (cSundae.isSelected()) {
                price += 40;
            }

            if (rb5.isSelected()) {
                price = price * .95;
            } else if (rb10.isSelected()) {
                price = price * 0.90;
            } else if (rb15.isSelected()) {
                price = price * 0.85;
            } else {
                price = price;
            }

            String finalPrice = String.format("%.2f", price);
            orderLabel.setText("The total price is Php " + finalPrice);
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Food Ordering System");
        frame.setContentPane(new FoodOrderingSystem().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(450,350);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
