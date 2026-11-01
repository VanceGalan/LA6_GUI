import javax.swing.*;
import java.awt.*;
import java.lang.String;

public class CharacterRemover {

    private JPanel mainPanel;
    private JLabel stringLabel;
    private JCheckBox vowelCheckBox;
    private JCheckBox consonantCheckBox;
    private JCheckBox numbersCheckBox;
    private JButton removeButton;
    private JButton restoreButton;

    public CharacterRemover() {
        mainPanel.setName("mainPanel");
        stringLabel.setName("stringLabel");
        vowelCheckBox.setName("vowelCheckBox");
        consonantCheckBox.setName("consonantCheckBox");
        numbersCheckBox.setName("numbersCheckBox");

        stringLabel.setBorder(BorderFactory.createEmptyBorder(30,0,10,0));


        removeButton.addActionListener(e -> {

            boolean isVowelSelected = vowelCheckBox.isSelected();
            boolean isConsonantSelected = consonantCheckBox.isSelected();
            boolean isNumbersSelected = numbersCheckBox.isSelected();

            String currString = stringLabel.getText();
            String newString = "";

            for (int i = 0; i < currString.length(); i++) {
                char c = currString.charAt(i);

                boolean isVowel = "AEIOU".indexOf(c) != -1;
                boolean isConsonant = Character.isLetter(c) && !isVowel;
                boolean isDigit = Character.isDigit(c);
                boolean keep = true;

                if (isVowelSelected && isVowel) {
                    keep = false;
                }

                if (isConsonantSelected && isConsonant) {
                    keep = false;
                }

                if (isNumbersSelected && isDigit) {
                    keep = false;
                }

                if (keep) {
                    newString += c;
                }
            }

            stringLabel.setText(newString);
        });

        restoreButton.addActionListener(e -> {
            stringLabel.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Remover");
        frame.setContentPane(new CharacterRemover().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(500,300);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
