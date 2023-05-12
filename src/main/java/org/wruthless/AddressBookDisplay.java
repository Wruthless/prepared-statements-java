package org.wruthless;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddressBookDisplay extends JFrame {

    private Person currentEntry;
    private PersonQueries personQueries;
    private List<Person> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;


    // Browse Button
    private JButton browseButton;

    // Email
    private JLabel emailLabel;
    private JTextField emailTextField;

    // First Name
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;

    // ID
    private JLabel idLabel;
    private JTextField idTextField;

    // Index
    private JTextField indexTextField;

    // Last Name
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;

    // Max Text
    private JTextField maxTextField;

    // Next Button
    private JButton nextButton;

    // Of
    private JLabel ofLabel;

    // Phone
    private JLabel phoneLabel;
    private JTextField phoneTextField;

    // Previous Button
    private JButton previousButton;

    // Query Widgets
    private JButton queryButton;
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JTextField queryTextField;

    // Navigate Panel
    private JPanel navigatePanel;

    // Display Panel
    private JLabel displayPanel;

    // Insert Button
    private JButton insertButton;

    public AddressBookDisplay() {

        super("Address Book");

        // Connect to database and ready PreparedStatements
        personQueries = new PersonQueries();

        navigatePanel = new JPanel();
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JLabel();
        idLabel = new JLabel();
        idTextField = new JTextField(10);
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField(10);
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField(10);
        emailLabel = new JLabel();
        emailTextField = new JTextField(10);
        phoneLabel = new JLabel();
        phoneTextField = new JTextField(10);
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(10);
        queryButton = new JButton();
        browseButton = new JButton();
        insertButton = new JButton();

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(400, 355);
        setResizable(false);

        navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

        previousButton.setText("Previous");
        previousButton.setEnabled(false);
        previousButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        previousButtonActionPerformed(evt);
                    }
                }
            );

        navigatePanel.add(previousButton);
        navigatePanel.add(Box.createHorizontalStrut(10));

    }

}
