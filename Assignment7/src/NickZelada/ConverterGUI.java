package NickZelada;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ConverterGUI will create the GUI for the program and user interaction and
 * extends JFrame.
 *
 * @author Nick Zelada
 * @version 03/21/2019 I affirm that this program is entirely my own work and
 * other person's work is involved.
 */
public class ConverterGUI extends JFrame {

    Money currencies[] = {Money.USD, Money.EUR, Money.GBP}; // array of money
    JComboBox fromTo, toNew; // convert from and convert to
    JTextField input, output; // user input and output
    JButton convertBtn; // convert button

    /**
     * The constructor that will create the GUI object
     */
    public ConverterGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // close when exit

        setSize(500, 300); // size of the box
        setLayout(new GridLayout(0, 1)); // 0 rows 1 column

        add(new JLabel("Enter amount:")); // string 

        input = new JTextField(); // the user input

        add(input); // the input is saved

        add(new JLabel("Select currency:")); // string

        fromTo = new JComboBox(currencies); // the drop down menu

        add(fromTo); // the select currency is saved

        add(new JLabel("Select the new currency:")); // string

        toNew = new JComboBox(currencies); // the drop down menu

        add(toNew); // the select currency is saved

        add(new JLabel("Results:")); // string

        output = new JTextField(); // display result

        output.setEditable(false); // results can't be edit once displayed

        add(output); // adds the output

        convertBtn = new JButton("Convert"); // string

        add(convertBtn); // adds the convert button to the gui

        setVisible(true); // if true it displays
        convertBtn.addActionListener(new ActionListener() { /* tells program
             what should be done when hitting convertBtn */

            @Override
            /**
             * Overriding the actionPerformed method to make a certain work in a
             * certain behavior when ran.
             *
             * @param ActionEvent which is a class with the parameter of ae.
             */
            public void actionPerformed(ActionEvent ae) {

                try {

                    double amount = Double.parseDouble(input.getText());
// parse the input number

                    Money sourceCurrency = (Money) fromTo
                            .getSelectedItem(); // original currency

                    Money targetCurrency = (Money) toNew
                            .getSelectedItem(); // new currency

                    if (sourceCurrency == targetCurrency) { /* if it's the same
                         currency*/

                        JOptionPane.showMessageDialog(null,
                                "The original currency is the same as the new currency!");
// display message
                    } else {

                        double result = Converter.convert(amount, // converts
                                sourceCurrency, targetCurrency);

                        output.setText(String.format("%.2f", result)); /* formats
                         the numbers 
                         */

                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Please only put digits"); /*
                     displays when any other character besides digits is written */


                }

            }

        });

    }

    /**
     * The main function for the program to bring it all together and create it.
     *
     * @param args parameter
     */
    public static void main(String[] args) {

        new ConverterGUI(); // creates the GUI

    }
}
