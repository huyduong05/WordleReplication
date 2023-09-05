import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface extends JFrame {
    private JLabel[][] wordLabels;
    private int rowDex = 0;
    private int colDex = 0;

    /**
     * Creates the userInterface object
     */
    public UserInterface() {
        super(); 
        WordChecker back = new WordChecker();
        JFrame frame = new JFrame("Wordle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1000);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        // Label title = new Label("Wordle");
        wordLabels = new JLabel[6][5];
        GridLayout gridLayout = new GridLayout(7, 5,10, 25);
        panel.setLayout(gridLayout);

        for (int i = 0; i < 6; i++) {
            for (int z = 0; z < 5; z++) {
                JLabel label = new JLabel(" ");
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
                label.setOpaque(true);
                // centers the text
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                wordLabels[i][z] = label; 
                panel.add(label);
            }
        }

        JTextField inputField = new JTextField(5);
        inputField.setColumns(5);
        // centers the input box
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(inputField);
        panel.add(centerPanel, BorderLayout.CENTER);
        inputField.addActionListener(new ActionListener() {
        JButton newGame = new JButton("Click to reset game ");

            /**
             * Takes in the user's input and checks it
             */
            public void actionPerformed(ActionEvent e) {
                if (colDex == 5 && rowDex == 6) {
                    inputField.setEditable(false);
                        inputField.setEditable(false);
                        centerPanel.add(newGame);
                        newGame.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                new UserInterface();
                            }
                        });
                    }

                String text = inputField.getText();
                text = text.toLowerCase();
                if (text.length() == 5 && back.actualWord(text)) {
                    String word = "";
                    for (int i = 0; i < 5; i++) {
                        char s = text.charAt(i);
                        word += s;
                        if(Character.isLetter(s)) {     
                            wordLabels[rowDex][colDex].setText(Character.toUpperCase(s) + "");
                            wordLabels[rowDex][colDex].setFont(new Font("DialogInput", Font.PLAIN, 60));
                            colDex++;
                        }
                    }
                    int [] check = back.checker(word);
                            //return array of int 2, right position , 1 right letter, 0 wrong letter
                    for (int i = 0; i < 5; i++) {
                        changeLabel(wordLabels[rowDex][i], check[i]);
                    }
                    if (back.rightWord(text, 0)) { 
                        inputField.setText("           You Win!"); 
                        inputField.setEditable(false); 
                    }
                }
                if (colDex == 5 && !back.rightWord(text, 0)) {
                    rowDex++;
                    if (rowDex < 6) {
                        colDex = 0;   
                        inputField.setText("");
                    } else { 
                        inputField.setText("           You Lose!");
                        inputField.setEditable(false);
                        JTextField correct = new JTextField(5);
                        panel.add(correct);
                        correct.setVisible(true);
                        correct.setEditable(false);
                        correct.setText("  Correct Word: " + back.getAnswer());
                    }
                }
                
            }
        });
    
        JPanel wordInput = new JPanel();
        wordInput.add(inputField);
        
        // add color changer 
        panel.add(wordInput);

        panel.add(inputField);
        frame.add(panel);
        frame.setVisible(true);
        inputField.setEditable(true);
    }

    /**
     * Changes the label depending on if the letter is correct or not
     * @param label - the letter to be checked
     * @param status - if the letter is correct or not
     */
    public void changeLabel(JLabel label, int status ) {
        if (status == 2) {
            label.setBackground(Color.GREEN);
        } else if (status == 1) {
            label.setBackground(Color.YELLOW);
        } else if (status == 0) {
            label.setBackground(Color.GRAY);
        } else {
            label.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        new UserInterface();
    }
}