import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.border.TitledBorder;

public class EnhancedForm { // Renamed class to EnhancedForm

    public static void main(String[] args) {
        // Set Nimbus Look and Feel for a modern look (should be first thing in main)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to default
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // Ignore if default also fails
            }
        }

        // Ensure the GUI is created on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // 1. Create the main frame (window)
        JFrame frame = new JFrame("Enhanced User Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        frame.setSize(500, 600); // Increased size to accommodate more fields
        frame.setLocationRelativeTo(null); // Center the window on the screen

        // 2. Create a main panel with a BorderLayout for overall structure
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15)); // Increased padding
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25)); // Overall padding

        // 3. Create a panel for form fields using GridBagLayout for more control
        // GridBagLayout is more complex but offers flexible alignment
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Enter Your Details",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14), Color.DARK_GRAY)); // Stylish titled border

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Padding for each component
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components fill horizontally

        // --- Name ---
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(25);
        nameField.setToolTipText("Enter your full name"); // Tooltip
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST; formPanel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0; formPanel.add(nameField, gbc);

        // --- Email ---
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(25);
        emailField.setToolTipText("Enter a valid email address (e.g., example@domain.com)");
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0; formPanel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0; formPanel.add(emailField, gbc);

        // --- Phone ---
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField(25);
        phoneField.setToolTipText("Enter your phone number");
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0; formPanel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0; formPanel.add(phoneField, gbc);

        // --- Age ---
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(25);
        ageField.setToolTipText("Enter your age in numbers");
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0; formPanel.add(ageLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0; formPanel.add(ageField, gbc);

        // --- Password ---
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(25); // Hides characters
        passwordField.setToolTipText("Enter a secure password (min 6 characters)");
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0; formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 1.0; formPanel.add(passwordField, gbc);

        // --- Gender (Radio Buttons) ---
        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleRadio = new JRadioButton("Male");
        JRadioButton femaleRadio = new JRadioButton("Female");
        JRadioButton otherRadio = new JRadioButton("Other");
        
        ButtonGroup genderGroup = new ButtonGroup(); // Ensures only one can be selected
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)); // Group radio buttons
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        genderPanel.setToolTipText("Select your gender");

        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0; formPanel.add(genderLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.weightx = 1.0; formPanel.add(genderPanel, gbc);

        // --- Country (Combo Box) ---
        JLabel countryLabel = new JLabel("Country:");
        String[] countries = {"", "India", "USA", "Canada", "UK", "Australia", "Other"};
        JComboBox<String> countryComboBox = new JComboBox<>(countries);
        countryComboBox.setToolTipText("Select your country");
        gbc.gridx = 0; gbc.gridy = 6; gbc.weightx = 0; formPanel.add(countryLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6; gbc.weightx = 1.0; formPanel.add(countryComboBox, gbc);

        // --- Comments (Text Area with Scroll Pane) ---
        JLabel commentsLabel = new JLabel("Comments:");
        JTextArea commentsArea = new JTextArea(5, 25); // 5 rows, 25 columns hint
        commentsArea.setLineWrap(true); // Wrap text at component boundary
        commentsArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(commentsArea); // Add scrollbars if content overflows
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setToolTipText("Any additional comments or notes");

        gbc.gridx = 0; gbc.gridy = 7; gbc.weightx = 0; gbc.anchor = GridBagConstraints.NORTHWEST; formPanel.add(commentsLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7; gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.BOTH; formPanel.add(scrollPane, gbc);
        
        // Reset weighty for next components to avoid them expanding too much
        gbc.weighty = 0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 4. Create a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0)); // Align buttons to the right, add spacing
        JButton submitButton = new JButton("Submit");
        submitButton.setToolTipText("Click to submit your information");
        JButton clearButton = new JButton("Clear");
        clearButton.setToolTipText("Click to clear all fields");

        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // 5. Add action listeners to buttons
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                String age = ageField.getText().trim();
                String password = new String(passwordField.getPassword()).trim(); // Get password as String
                
                String selectedGender = "";
                if (maleRadio.isSelected()) selectedGender = "Male";
                else if (femaleRadio.isSelected()) selectedGender = "Female";
                else if (otherRadio.isSelected()) selectedGender = "Other";
                
                String selectedCountry = (String) countryComboBox.getSelectedItem();
                String comments = commentsArea.getText().trim();

                // --- Validation ---
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || age.isEmpty() || password.isEmpty() || selectedGender.isEmpty() || selectedCountry.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields (Name, Email, Phone, Age, Password, Gender, Country).", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return; // Stop if any mandatory field is empty
                }

                // Email validation (simple regex)
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Age validation
                try {
                    int ageValue = Integer.parseInt(age);
                    if (ageValue <= 0 || ageValue > 120) { // Reasonable age range
                        JOptionPane.showMessageDialog(frame, "Please enter a valid age (1-120).", "Input Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Age must be a valid number.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                // Password validation (min 6 characters)
                if (password.length() < 6) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters long.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // --- Submission & File Saving ---
                String submissionDetails =
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Phone: " + phone + "\n" +
                    "Age: " + age + "\n" +
                    // "Password: " + password + "\n" + // Don't show password in message box for security
                    "Gender: " + selectedGender + "\n" +
                    "Country: " + selectedCountry + "\n" +
                    "Comments: " + (comments.isEmpty() ? "N/A" : comments) + "\n" +
                    "-----------------------------------\n"; // Separator for file

                // Save to file
                try (PrintWriter out = new PrintWriter(new FileWriter("user_submissions.txt", true))) { // 'true' for append mode
                    out.println(submissionDetails);
                    // For security, don't write password to plain text file either if it's sensitive.
                    // If you must, consider encryption or hashing. For this example, we'll omit.
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, "Error saving data to file: " + ioException.getMessage(), "File Save Error", JOptionPane.ERROR_MESSAGE);
                }

                // Show success message
                String welcomeMessage = "Welcome, " + name + "! 😊\n\n" +
                                        "Your information has been successfully submitted and saved.";
                JOptionPane.showMessageDialog(frame, welcomeMessage, "Submission Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                ageField.setText("");
                passwordField.setText("");
                genderGroup.clearSelection(); // Deselects all radio buttons
                countryComboBox.setSelectedIndex(0); // Selects the first item (empty string)
                commentsArea.setText("");
            }
        });

        // 6. Add panels to the main frame's content pane
        mainPanel.add(formPanel, BorderLayout.CENTER); // Form fields in the center area
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Buttons at the bottom area

        frame.add(mainPanel); // Add the main panel to the frame

        // 7. Pack the frame (adjusts size to fit components) and make it visible
        frame.pack(); // Adjusts frame size to fit all components ideally
        frame.setMinimumSize(frame.getSize()); // Prevent user from making it too small
        frame.setVisible(true);
    }
}