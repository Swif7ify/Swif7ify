package AlloCare;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.Calendar;

public class logIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                logIn frame = new logIn();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public logIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 696, 421);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setForeground(new Color(113, 113, 113));
        lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lblNewLabel.setBounds(357, 66, 137, 29);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_3 = new JLabel("Sign In");
        lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
        lblNewLabel_3.setBounds(357, 8, 325, 48);
        contentPane.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBackground(new Color(250, 250, 250));
        textField.setBounds(357, 106, 312, 29);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(113, 113, 113));
        lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        lblPassword.setBounds(360, 164, 137, 29);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(250, 250, 250));
        passwordField.setBounds(357, 203, 312, 29);
        contentPane.add(passwordField);
        passwordField.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));

        RoundedButton btnNewButton = new RoundedButton("Log In", 30);
        btnNewButton.setFocusPainted(false); 
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(46, 66, 67));
        btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        btnNewButton.setBounds(357, 257, 315, 35);
        contentPane.add(btnNewButton);

        RoundedButton btnCreate = new RoundedButton("Create", 30);
        btnCreate.setFocusPainted(false); 
        btnCreate.setBorderPainted(false);
        btnCreate.setForeground(new Color(255, 255, 255));
        btnCreate.setBackground(new Color(46, 66, 67));
        btnCreate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        btnCreate.setBounds(357, 302, 312, 35);
        contentPane.add(btnCreate);
        
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    btnNewButton.doClick();
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnNewButton.doClick();
                }
            }
        });


     	JButton btnNewButton_1 = new JButton();
     	btnNewButton_1.setText("Delete Account");
     	btnNewButton_1.setBorderPainted(false);
     	btnNewButton_1.setFocusPainted(false); 

    	btnNewButton_1.setBackground(new Color(255, 255, 255));
    	btnNewButton_1.setIcon(null);
    	btnNewButton_1.setBounds(455, 345, 121, 29);
    	contentPane.add(btnNewButton_1);
       	ImageIcon logo = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\Untitled.png");
       	Image pic = logo.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
       	ImageIcon resizedBG2 = new ImageIcon(pic);
       	
       	JPanel panel = new JPanel();
        panel.setBounds(-13, 0, 355, 473);
        contentPane.add(panel);
        panel.setLayout(null);
               
        JLabel lblNewLabel_2 = new JLabel("@FLUXUS");
        lblNewLabel_2.setBounds(10, 353, 345, 27);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 14));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
                
        JLabel lblNewLabel_6 = new JLabel("Flowing out Revolutionary Ideas");
        lblNewLabel_6.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(10, 188, 345, 42);
        panel.add(lblNewLabel_6);
        
        JLabel lblNewLabel_5 = new JLabel("AlloCare");
        lblNewLabel_5.setBackground(new Color(0, 104, 56));
        lblNewLabel_5.setFont(new Font("Brush Script MT", Font.PLAIN, 52));
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(10, 130, 345, 58);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\bg\\login.jpg"));
        lblNewLabel_1.setBounds(0, -37, 354, 529);
        panel.add(lblNewLabel_1);
 
        
        
        
        btnNewButton_1.addActionListener(e -> {
            String enteredUsername = textField.getText().trim();
            if (!enteredUsername.isEmpty()) {
                String enteredPassword = promptForPassword();
                if (enteredPassword != null && !enteredPassword.isEmpty()) {
                    new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            deleteUsername(enteredUsername, enteredPassword);
                            return null;
                        }
                        @Override
                        protected void done() {

                            textField.setText("");
                            passwordField.setText("");
                        }
                    }.execute();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Password is required to delete account.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Please Enter a Valid Username.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JLabel lblNewLabel_8 = new JLabel();
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ImageIcon backImg = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\bg.png");
        Image bg = backImg.getImage().getScaledInstance(2000, 1500, Image.SCALE_SMOOTH);
        lblNewLabel_8.setBounds(-13, 0, 1655, 1093);
        ImageIcon resizedBG = new ImageIcon(bg);
        lblNewLabel_8.setIcon(resizedBG);
        contentPane.add(lblNewLabel_8);

        btnNewButton.addActionListener(e -> {
            String enteredUsername = textField.getText().trim();
            String enteredPassword = new String(passwordField.getPassword());
            new SwingWorker<Boolean, Void>() {
                @Override
                protected Boolean doInBackground() throws Exception {
                    return checkPassword(enteredUsername, enteredPassword);
                }
                
                @Override
                protected void done() {
                    try {
                        if (get()) {
                        	homePage newFrame = new homePage(enteredUsername);
                            newFrame.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Invalid Username or Password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }.execute();
        });

        btnCreate.addActionListener(e -> {
            String enteredUsername = textField.getText().trim();
            String enteredPassword = new String(passwordField.getPassword());
            if (!enteredUsername.isEmpty() && !enteredPassword.isEmpty()) {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        createNewUsername(enteredUsername, enteredPassword);
                        return null;
                    }
                }.execute();
            } else {
                JOptionPane.showMessageDialog(contentPane, "Please Enter a Valid Username and Password.", "Error", JOptionPane.ERROR_MESSAGE);
                
        JLabel lblNewLabel_4 = new JLabel();
        lblNewLabel_4.setBounds(493, 24, 66, 58);
        contentPane.add(lblNewLabel_4);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setIcon(resizedBG2);
            }
        });
    }

    private boolean checkUsernameExists(String user) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String password = "allocare";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, password)) {
            String sql = "SELECT * FROM \"Username\" WHERE \"user\" = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error Checking Account Existence: " + ex.getMessage());
            return false;
        }
    }

    private void createNewUsername(String user, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String dbPassword = "allocare";

        if (checkUsernameExists(user)) {
            JOptionPane.showMessageDialog(contentPane, "Account Already Exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword)) {
            String insertUserSQL = "INSERT INTO \"Username\" (\"user\", \"user_pass\", \"user_DATE\") VALUES (?, ?, ?)";
            try (PreparedStatement insertUserStatement = connection.prepareStatement(insertUserSQL)) {
                insertUserStatement.setString(1, user);
                insertUserStatement.setString(2, password);

                Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
                Calendar cal = Calendar.getInstance();
                cal.setTime(currentTimestamp);
                cal.set(Calendar.MILLISECOND, 0);
                cal.set(Calendar.SECOND, 0);
                Timestamp noSecondsTimestamp = new Timestamp(cal.getTimeInMillis());

                insertUserStatement.setTimestamp(3, noSecondsTimestamp); 

                int rowsInserted = insertUserStatement.executeUpdate();
                if (rowsInserted > 0) {
                    String createTableSQL = "CREATE TABLE \"" + user + "_BUDGET\" (" +
                                            "ID SERIAL PRIMARY KEY," +
                                            "BUDGET DOUBLE PRECISION NOT NULL," +
                                            "BUDGET_DATE DATE NOT NULL" +
                                            ");" +
                                            "CREATE TABLE \"" + user + "_EXPENSE\" (" +
                                            "ID SERIAL PRIMARY KEY," +
                                            "EXPENSE_CATEGORY VARCHAR(255) NOT NULL," +
                                            "EXPENSE_NAME VARCHAR(255) NOT NULL," +
                                            "EXPENSE_AMOUNT DOUBLE PRECISION NOT NULL," +
                                            "EXPENSE_DATE DATE NOT NULL" +
                                            ");" +
                                            "CREATE TABLE \"" + user + "_TARGET\" (" +
                                            "ID SERIAL PRIMARY KEY," +
                                            "TARGET_SPAN DATE NOT NULL," +
                                            "ENTERED_DATE DATE NOT NULL" +
                                            ");" +
                                            "CREATE TABLE \"" + user + "_TOTAL\" (" +
                                            "ID SERIAL PRIMARY KEY," +
                                            "TOTAL_EXPENSE DOUBLE PRECISION NOT NULL," +
                                            "TOTAL_SAVINGS DOUBLE PRECISION NOT NULL," +
                                            "TOTAL_DATE DATE NOT NULL" +
                                            ")";
                    try (PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL)) {
                        createTableStatement.executeUpdate();
                        JOptionPane.showMessageDialog(contentPane, "Account Creation Was Successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException createEx) {
                        System.out.println("Error creating Tables: " + createEx.getMessage());
                        JOptionPane.showMessageDialog(contentPane, "Failed to Create Account.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Failed to Create Username.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error creating username: " + ex.getMessage());
            JOptionPane.showMessageDialog(contentPane, "Failed to Create Username.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
	private boolean checkPassword(String user, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String dbPassword = "allocare";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword)) {
            String sql = "SELECT * FROM \"Username\" WHERE \"user\" = ? AND \"user_pass\" = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error Checking Password: " + ex.getMessage());
            return false;
        }
    }

    private String promptForPassword() {
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter Password to Confirm Deletion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            return new String(passwordField.getPassword());
        }
        return null;
    }

    private void deleteUsername(String user, String password) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String dbPassword = "allocare";

        if (!checkUsernameExists(user)) {
            JOptionPane.showMessageDialog(contentPane, "Username is not Registered.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!checkPassword(user, password)) {
            JOptionPane.showMessageDialog(contentPane, "Incorrect Password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to Delete this Account?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword)) {
                String sql = "DELETE FROM \"Username\" WHERE \"user\" = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, user);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        String[] dropTableSQLs = {
                            "DROP TABLE IF EXISTS \"" + user + "_BUDGET\"",
                            "DROP TABLE IF EXISTS \"" + user + "_EXPENSE\"",
                            "DROP TABLE IF EXISTS \"" + user + "_TARGET\"",
                            "DROP TABLE IF EXISTS \"" + user + "_TOTAL\""
                        };

                        boolean allTablesDeleted = true;
                        for (String dropTableSQL : dropTableSQLs) {
                            try (PreparedStatement dropTableStatement = connection.prepareStatement(dropTableSQL)) {
                                dropTableStatement.executeUpdate();
                            } catch (SQLException dropEx) {
                                System.out.println("Error dropping table: " + dropEx.getMessage());
                                allTablesDeleted = false;
                            }
                        }

                        if (allTablesDeleted) {
                            JOptionPane.showMessageDialog(contentPane, "Account Deleted.", "Username Status", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Account Deleted, but some tables could not be deleted.", "Partial Success", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Failed to Delete Account.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error deleting username: " + ex.getMessage());
            }
        }
    }
}
