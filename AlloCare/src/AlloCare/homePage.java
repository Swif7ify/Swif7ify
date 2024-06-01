package AlloCare;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;


class RoundedPanel extends JPanel {
	 private static final long serialVersionUID = 1L;
	    private int radius;

	    public RoundedPanel(int radius) {
	        this.radius = radius;
	        setOpaque(false); 
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Dimension arcs = new Dimension(radius, radius);
	        int width = getWidth();
	        int height = getHeight();
	        Graphics2D graphics = (Graphics2D) g;
	        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        
	        graphics.setColor(getBackground());
	        graphics.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);
	    }
	    
	    public Dimension getPreferredSize() {
	        return new Dimension(radius * 2, radius * 2);
	    }
	    
	    public int getRadius() {
	        return radius;
	    }

	    public void setRadius(int radius) {
	        this.radius = radius;
	        repaint();
	    }
}
public class homePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private double totalExpenses = 0.0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	homePage frame = new homePage("");
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    

    public homePage(String username) {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(2000, 2000, 2000, 2000);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true); 

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth();
		int height = (int) toolkit.getScreenSize().getHeight();
		setSize(width, height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(46, 66, 77));
        panel.setBounds(0, 0, 170, 970);
        contentPane.add(panel);
        
        Image img = new ImageIcon(this.getClass().getResource("/Untitled.png")).getImage();
        Image img2 = new ImageIcon(this.getClass().getResource("/pig.png")).getImage();
        
        JLabel lblNewLabel = new JLabel("");
        JLabel label2 = new JLabel(new ImageIcon(img2));
        label2.setBounds(392, 55, img2.getWidth(null), img2.getHeight(null));
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(23, 37, img.getWidth(null), img.getHeight(null));

        panel.setLayout(null);
        panel.add(lblNewLabel);
        Image resizedImg = img2.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        JLabel label21 = new JLabel(resizedIcon);
        label21.setBounds(783, 212, 689, 554);
        contentPane.add(label21);
        
        RoundedButton btnNewButton_2 = new RoundedButton("HOME", 20);
        btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        btnNewButton_2.setForeground(new Color(46, 66, 77));
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setBounds(23, 209, 120, 52);
        panel.add(btnNewButton_2);
        
        RoundedButton btnNewButton_2_1 = new RoundedButton("LIST", 20);
        btnNewButton_2_1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 TimerTask task = new TimerTask() {
                     public void run() {
                         listInformation mydash = new listInformation(username);
                         mydash.setVisible(true);
                         dispose();
                     }
                 };
                 int delay = 50;
                 Timer timer = new Timer();
                 timer.schedule(task, delay);
             }
         });
        btnNewButton_2_1.setForeground(new Color(255, 255, 255));
        btnNewButton_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnNewButton_2_1.setBackground(new Color(46, 66, 77));
        btnNewButton_2_1.setBounds(23, 288, 120, 52);
        panel.add(btnNewButton_2_1);
        
        AlloCare.RoundedButton btnNewButton_2_1_1_1 = new AlloCare.RoundedButton("NOTES", 20);
        btnNewButton_2_1_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		   int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION); // Dispose the current AllocareGUI frame
        		   if (confirm == JOptionPane.YES_OPTION) {
        			   	dispose();
        	            logIn usernameFrame = new logIn(); 
        	            usernameFrame.setVisible(true); 
        	        }
        	}
        });
        btnNewButton_2_1_1_1.setText("LOG OUT");
        btnNewButton_2_1_1_1.setForeground(Color.WHITE);
        btnNewButton_2_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnNewButton_2_1_1_1.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        btnNewButton_2_1_1_1.setBackground(new Color(46, 66, 77));
        btnNewButton_2_1_1_1.setBounds(23, 889, 120, 52);
        panel.add(btnNewButton_2_1_1_1);
        
        AlloCare.RoundedButton btnNewButton_2_1_1 = new AlloCare.RoundedButton("LIST", 20);
        btnNewButton_2_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                TimerTask task = new TimerTask() {
                    public void run() {
                        expenses mydash = new expenses(username);
                        mydash.setVisible(true);
                        dispose();
                    }
                };
                int delay = 50;
                Timer timer = new Timer();
                timer.schedule(task, delay);
            }
        });
        btnNewButton_2_1_1.setText("EXPENSES");
        btnNewButton_2_1_1.setForeground(Color.WHITE);
        btnNewButton_2_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnNewButton_2_1_1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btnNewButton_2_1_1.setBackground(new Color(46, 66, 77));
        btnNewButton_2_1_1.setBounds(23, 364, 120, 52);
        panel.add(btnNewButton_2_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("WELCOME, " + username);
        lblNewLabel_1.setForeground(new Color(46, 66, 77));
        lblNewLabel_1.setBounds(206, 38, 1192, 120);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", lblNewLabel_1.getFont().getStyle(), 60));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(46, 66, 77));
        panel_1.setBounds(206, 168, 1258, 4);
        contentPane.add(panel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Monitor your budget with AlloCare.");
        lblNewLabel_2.setForeground(new Color(114, 114, 114));
        lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(206, 135, 779, 36);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Your Current Budget:");
        lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(211, 255, 278, 48);
        contentPane.add(lblNewLabel_3);
        
        RoundedPanel panel_2 = new RoundedPanel(50);
        panel_2.setBackground(new Color(46, 66, 77));
        panel_2.setBounds(206, 313, 237, 58);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
         
        double budgetAmount = getBudgetAmountFromDB(username);
        double totalExpenses = updateTotalExpenses(username);
        double savings = budgetAmount - totalExpenses;
        double savingsPercentage = (savings / budgetAmount) * 100;
        DecimalFormat df = new DecimalFormat("₱#,##0.##");
        String formattedSavings = df.format(savings);
        String savingWithCurrency = formattedSavings;

	     String message;
	     if (savingsPercentage >= 50) {
	         message = "You are doing a great job!";
	     } else if (savingsPercentage >= 40) {
	         message = "You are managing your expenses well.";
	     } else if (savingsPercentage >= 20) {
	         message = "Be mindful of your expenses.";
	     } else {
	         message = "You need to review your expenses immediately!.";
	     }
       
	    String formattedBudgetAmount = df.format(budgetAmount);
        RoundedLabel lblNewLabel_4 = new RoundedLabel(formattedBudgetAmount, 20);
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
        	
            @Override
            public void mouseClicked(MouseEvent e) {
                String budgetAmountString = JOptionPane.showInputDialog(null, "Enter budget amount:");
                if (budgetAmountString != null && !budgetAmountString.isEmpty()) {
                    try {
                        double newBudgetAmount = Double.parseDouble(budgetAmountString);
                        saveBudgetAmount(username, newBudgetAmount);
                        String formattedNewBudgetAmount = newBudgetAmount % 1 == 0 ?
                                String.format("₱%.0f", newBudgetAmount) : String.format("₱%.2f", newBudgetAmount);
                        lblNewLabel_4.setText(formattedNewBudgetAmount);
                        TimerTask task = new TimerTask() {
                            public void run() {
                                homePage mydash = new homePage(username);
                                mydash.setVisible(true);
                                dispose();
                            }
                        };
                        int delay = 50;
                        Timer timer = new Timer();
                        timer.schedule(task, delay);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    }
                }
            }
        });

        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(10, 10, 217, 40);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 33));
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel_4.setBackground(new Color(46, 66, 77)); 
        lblNewLabel_4.setOpaque(false); 
        lblNewLabel_4.setContentAreaFilled(false); 
        lblNewLabel_4.setBorderPainted(false);
        panel_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_3_1 = new JLabel(message);
        lblNewLabel_3_1.setForeground(new Color(86, 86, 88));
        lblNewLabel_3_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        lblNewLabel_3_1.setBounds(206, 442, 522, 48);
        contentPane.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_5 = new JLabel("Navigate where your money goes. ");
        lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
        lblNewLabel_5.setBounds(954, 848, 347, 42);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("All rights reserved.");
        lblNewLabel_3_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_3_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        lblNewLabel_3_1_1.setBounds(206, 844, 393, 48);
        contentPane.add(lblNewLabel_3_1_1);
        
     
        RoundedButton btnNewButton_1 = new RoundedButton("<html>Update Your List Here</html>", 20); // No need for <center> tag
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TimerTask task = new TimerTask() {
                    public void run() {
                        listInformation mydash = new listInformation(username);
                        mydash.setVisible(true);
                        dispose();
                    }
                };
                int delay = 50;
                Timer timer = new Timer();
                timer.schedule(task, delay);
            }
        });
       
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setVerticalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        btnNewButton_1.setIconTextGap(20);
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(46, 66, 77));
        btnNewButton_1.setBounds(921, 789, 393, 49);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Close Program?", JOptionPane.YES_NO_OPTION);
        		if (confirm == JOptionPane.YES_OPTION) {
        			System.exit(0);
        		}
        	}
        });
        btnNewButton_3.setBackground(new Color(255, 0, 0));
        ImageIcon plus = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-cross-90.png");
        btnNewButton_3.setBorderPainted(false);
        btnNewButton_3.setFocusPainted(false); 
        Image plusimg = plus.getImage();
        Image resizedplus = plusimg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon plusicon = new ImageIcon(resizedplus);
        btnNewButton_3.setIcon(plusicon);
        btnNewButton_3.setBounds(1489, 10, 34, 36);
        contentPane.add(btnNewButton_3);
        
        JButton btnNewButton_3_1 = new JButton("");
        btnNewButton_3_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		setExtendedState(JFrame.ICONIFIED);
        	}
        });
        ImageIcon hrline = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-horizontal-line-100.png");
        Image lineimage = hrline.getImage();  
        btnNewButton_3_1.setOpaque(false);
        btnNewButton_3_1.setFocusPainted(false);
        btnNewButton_3_1.setBorderPainted(false);
        Image resizedhr = lineimage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedline = new ImageIcon(resizedhr);
        btnNewButton_3_1.setIcon(resizedline);
        btnNewButton_3_1.setBackground(new Color(255, 255, 255));
        btnNewButton_3_1.setBounds(1433, 10, 34, 36);
        contentPane.add(btnNewButton_3_1);
        
       
        JButton btnNewButton_3_1_1 = new JButton("");
        btnNewButton_3_1_1.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
          
                 TimerTask task = new TimerTask() {
                     public void run() {
                         homePage mydash = new homePage(username);
                         mydash.setVisible(true);
                         dispose();
                     }
                 };
                 int delay = 50;
                 Timer timer = new Timer();
                 timer.schedule(task, delay);
             }
         });
        ImageIcon refresh = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-refresh-480.png");
        Image refreshimg = refresh.getImage();
        btnNewButton_3_1_1.setFocusPainted(false);
        btnNewButton_3_1_1.setOpaque(false);
        btnNewButton_3_1_1.setBorderPainted(false);
        Image resizedrefresh = refreshimg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedref = new ImageIcon(resizedrefresh);
        btnNewButton_3_1_1.setIcon(resizedref);
        btnNewButton_3_1_1.setBackground(new Color(255, 255, 255));
        btnNewButton_3_1_1.setBounds(1376, 10, 34, 36);
        contentPane.add(btnNewButton_3_1_1);
        
        JLabel lblNewLabel_7 = new JLabel("Savings:");
        lblNewLabel_7.setForeground(new Color(123, 123, 123));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_7.setBounds(216, 381, 81, 36);
        contentPane.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel(savingWithCurrency);
        lblNewLabel_8.setForeground(new Color(123, 123, 123));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setBounds(297, 381, 219, 36);
        contentPane.add(lblNewLabel_8);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\bg.png");
        Image originalImage1 = originalIcon1.getImage().getScaledInstance(2000, 1500, Image.SCALE_SMOOTH);
        lblNewLabel_6.setBounds(75, -18, 1546, 1093);

        ImageIcon resizedIcon1 = new ImageIcon(originalImage1);
        lblNewLabel_6.setIcon(resizedIcon1);
        contentPane.add(lblNewLabel_6);
    }
    
    private double updateTotalExpenses(String username) {
    	 String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
         String dbUsername = "postgres";
         String password = "allocare";

         try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, password)) {
            String query = "SELECT SUM(EXPENSE_AMOUNT) AS total FROM \"" + username + "_EXPENSE\"";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalExpenses = resultSet.getDouble("total");
            } else {
                totalExpenses = 0.0;
            }
            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to calculate total expenses from the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
		return totalExpenses;
    }
    

    
    private double getBudgetAmountFromDB(String username) {
        double budgetAmount = 0.0;
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String password = "allocare";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, password)) {
            String selectBudgetSQL = "SELECT BUDGET FROM \"" +username+ "_BUDGET\" ORDER BY id DESC LIMIT 1";
            try (PreparedStatement selectBudgetStatement = connection.prepareStatement(selectBudgetSQL);
                 ResultSet resultSet = selectBudgetStatement.executeQuery()) {
                if (resultSet.next()) {
                    budgetAmount = resultSet.getDouble("BUDGET");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error retrieving budget amount from the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return budgetAmount;
    }
    
    private void saveBudgetAmount(String username, double budgetAmount) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String password = "allocare";

        LocalDate currentDate = LocalDate.now();

        Timestamp timestamp = Timestamp.valueOf(currentDate.atStartOfDay());

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, password)) {
            String insertBudgetSQL = "INSERT INTO \"" + username + "_BUDGET\" (BUDGET, BUDGET_DATE) VALUES (?, ?)";
            try (PreparedStatement insertBudgetStatement = connection.prepareStatement(insertBudgetSQL)) {
                insertBudgetStatement.setDouble(1, budgetAmount);
                insertBudgetStatement.setTimestamp(2, timestamp);
                int rowsInserted = insertBudgetStatement.executeUpdate();
                if (rowsInserted > 0) {

                    String formattedBudgetAmount = budgetAmount % 1 == 0 ?
                    String.format("₱%.0f", budgetAmount) : String.format("₱%.2f", budgetAmount);
                    JOptionPane.showMessageDialog(contentPane, "Budget Was Set Successfully: " + formattedBudgetAmount, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Failed to Add Budget, Please Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(contentPane, "Error connecting to the database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
}
class RoundedButton extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cornerRadius;

	public RoundedButton(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        // Call the superclass method to paint the text and icon
        super.paintComponent(g2);
        g2.dispose();
    }
    
}


class RoundedLabel extends JLabel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cornerRadius;

    public RoundedLabel(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
        setOpaque(false); 
    }

    public void setContentAreaFilled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setBorderPainted(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        super.paintComponent(g2);
        g2.dispose();
    }
}
class CustomPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image bgImage;

    public CustomPanel(Image bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            Dimension size = getSize();
            g.drawImage(bgImage, 0, 0, size.width, size.height, this);
        }
    }
}