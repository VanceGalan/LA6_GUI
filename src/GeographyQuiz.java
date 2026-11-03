import javax.swing.*;
import java.awt.*;

public class GeographyQuiz {
    private JPanel cardLayout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTextField question1TextField;
    private JLabel question1Label;
    private JButton nextButton;
    private JLabel scoreLabel;

    private int score = 0;

    public GeographyQuiz() {
        question1Label.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(30,20,0,0));
        nextButton.setSize(30,10);

        nextButton.addActionListener(e-> {
            String answer = question1TextField.getText();
            if (answer.equals("Paris")) {
                score++;
            }
            scoreLabel.setText("Your score: " + score + "/3");
            question1TextField.setText("");

            CardLayout cardLay = (CardLayout) cardLayout.getLayout();
            cardLay.next(cardLayout);

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Geography Quiz");
        frame.setContentPane(new GeographyQuiz().cardLayout);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(400,300);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
