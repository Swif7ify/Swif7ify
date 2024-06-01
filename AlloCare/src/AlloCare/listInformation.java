package AlloCare;

import java.awt.Color; 
import java.awt.Cursor;
import java.awt.Dimension; 
import java.awt.EventQueue; 
import java.awt.Font; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image; 
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder; 
import javax.swing.JComboBox; 
import javax.swing.JFormattedTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl; 
import org.jdatepicker.impl.UtilDateModel;

public class listInformation extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JPanel contentPane_1;
private JPanel panel_2;
private JPanel panelContainer;
private int panelGroupCount = 0;
private Connection connection;
private boolean deleteMode = false;
private String enteredDate = null;
private String targetSpanDate = null;
private JLabel lblTotalValue;
private JLabel lblNewLabel_7_4;
private double totalExpenses = 0.0;
 

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				listInformation frame = new listInformation("");
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}


/**
 * Create the frame.
 */
public listInformation(String username) {
	establishDBConnection();
	updateTotalExpenses(username);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(2000, 2000, 2000, 2000);
	setExtendedState(JFrame.MAXIMIZED_BOTH); 
	setUndecorated(true); 

	Toolkit toolkit = Toolkit.getDefaultToolkit();
	int width = (int) toolkit.getScreenSize().getWidth();
	int height = (int) toolkit.getScreenSize().getHeight();
	setSize(width, height);
    
    contentPane_1 = new JPanel();
    contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane_1);
    
    contentPane_1.setLayout(null);
    JPanel panel = new JPanel();
    panel.setBackground(new Color(46, 66, 77));
    panel.setBounds(0, 0, 170, 970);
    contentPane_1.add(panel);

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	Image img = new ImageIcon(this.getClass().getResource("/Untitled.png")).getImage();

	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(img));
	lblNewLabel.setBounds(23, 37, img.getWidth(null), img.getHeight(null));
	
	panel.setLayout(null);
	panel.add(lblNewLabel);

	RoundedButton btnNewButton_2 = new RoundedButton("HOME", 20);
	btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
	btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
	btnNewButton_2.setBackground(new Color(46, 66, 77));
	btnNewButton_2.setForeground(new Color(255, 255, 255));
	btnNewButton_2.setBounds(23, 209, 120, 52);
	panel.add(btnNewButton_2);
	btnNewButton_2.addActionListener(new ActionListener() {
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

	RoundedButton btnNewButton_2_1 = new RoundedButton("LIST", 20);
	btnNewButton_2_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_2_1.setForeground(new Color(255, 255, 255));
    btnNewButton_2_1.setBorderPainted(false);
	btnNewButton_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
	btnNewButton_2_1.setForeground(new Color(46, 66, 77));
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
    
    
    
    JButton btnNewButton3 = new JButton("");
    btnNewButton3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	}
    });
    btnNewButton3.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Close Program?", JOptionPane.YES_NO_OPTION);
    		if (confirm == JOptionPane.YES_OPTION) {
    			System.exit(0);
    		}
    	}
    });
    btnNewButton3.setBackground(new Color(255, 0, 0));
    ImageIcon plus = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-cross-90.png");
    btnNewButton3.setBorderPainted(false);
    btnNewButton3.setFocusPainted(false);
    Image plusimg = plus.getImage();
    Image resizedplus = plusimg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon plusicon = new ImageIcon(resizedplus);
    btnNewButton3.setIcon(plusicon);
    btnNewButton3.setBounds(1489, 10, 34, 36);
    contentPane_1.add(btnNewButton3);
    
    JButton btnNewButton31 = new JButton("");
    btnNewButton31.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		setExtendedState(JFrame.ICONIFIED);
    	}
    });
    ImageIcon hrline = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-horizontal-line-100.png");
    Image lineimage = hrline.getImage();  
    btnNewButton31.setOpaque(false);
    btnNewButton31.setFocusPainted(false);
    btnNewButton31.setBorderPainted(false);
    Image resizedhr = lineimage.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
    ImageIcon resizedline = new ImageIcon(resizedhr);
    btnNewButton31.setIcon(resizedline);
    btnNewButton31.setBackground(new Color(255, 255, 255));
    btnNewButton31.setBounds(1433, 10, 34, 36);
    contentPane_1.add(btnNewButton31);
    
   
    JButton btnNewButton311 = new JButton("");
    btnNewButton311.addActionListener(new ActionListener() {
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

    ImageIcon refresh = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-refresh-480.png");
    Image refreshimg = refresh.getImage();
    btnNewButton311.setFocusPainted(false);
    btnNewButton311.setOpaque(false);
    btnNewButton311.setBorderPainted(false);
    Image resizedrefresh = refreshimg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); 
    ImageIcon resizedref = new ImageIcon(resizedrefresh);
    btnNewButton311.setIcon(resizedref);
    btnNewButton311.setBackground(new Color(255, 255, 255));
    btnNewButton311.setBounds(1376, 10, 34, 36);
    contentPane_1.add(btnNewButton311);
    
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
    
    btnNewButton_2_1_1_1.setText("LOG OUT");
    btnNewButton_2_1_1_1.setForeground(Color.WHITE);
    btnNewButton_2_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
    btnNewButton_2_1_1_1.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
    btnNewButton_2_1_1_1.setBackground(new Color(46, 66, 77));
    btnNewButton_2_1_1_1.setBounds(23, 889, 120, 52);
    panel.add(btnNewButton_2_1_1_1);
	
    RoundedPanel panel_1 = new RoundedPanel(30);
    panel_1.setBackground(new Color(255, 255, 255));
	panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_1.setBounds(380, 217, 233, 90);
	contentPane_1.add(panel_1);
	panel_1.setLayout(null);
	
	RoundedPanel panel_1_1 = new RoundedPanel(30);
	panel_1_1.setBackground(new Color(255, 255, 255));
	panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_1_1.setBounds(380, 339, 233, 90);
	contentPane_1.add(panel_1_1);
	panel_1_1.setLayout(null);
	
	JLabel lblNewLabel_1_1 = new JLabel("Target Span");
	lblNewLabel_1_1.setBounds(53, 6, 127, 24);
	lblNewLabel_1_1.setForeground(new Color(46, 66, 77));
	lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
	panel_1_1.add(lblNewLabel_1_1);
	
	RoundedPanel panel_5_1 = new RoundedPanel(30);
	panel_5_1.setLayout(null);
	panel_5_1.setForeground(Color.WHITE);
	panel_5_1.setBackground(new Color(46, 66, 77));
	panel_5_1.setBounds(10, 43, 213, 37);
	panel_1_1.add(panel_5_1);
	
	JLabel lblNewLabel_7_1 = new JLabel();
	lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_7_1.setForeground(Color.WHITE);
	lblNewLabel_7_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
	lblNewLabel_7_1.setBounds(0, 0, 213, 37);
	panel_5_1.add(lblNewLabel_7_1);
	
	JLabel lblNewLabel_1 = new JLabel("Enter Date");
	lblNewLabel_1.setBounds(61, 6, 110, 24);
	lblNewLabel_1.setForeground(new Color(46, 66, 77));
	panel_1.add(lblNewLabel_1);
	lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	
	RoundedPanel panel_5 = new RoundedPanel(30);
	panel_5.setForeground(new Color(255, 255, 255));
	panel_5.setBackground(new Color(46, 66, 77));
	panel_5.setBounds(10, 43, 213, 37);
	panel_1.add(panel_5);
	panel_5.setLayout(null);
	
	JLabel lblNewLabel_7 = new JLabel();
	lblNewLabel_7.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	createDatePickerPanel(lblNewLabel_7, "entered_date" ,username);
	        createDatePickerPanel(lblNewLabel_7_1, "target_span" ,username);
	    }
	});
	lblNewLabel_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
	lblNewLabel_7.setForeground(new Color(255, 255, 255));
	lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_7.setBounds(0, 0, 213, 37);
	panel_5.add(lblNewLabel_7);
	
	
	lblNewLabel_7_1.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	createDatePickerPanel(lblNewLabel_7_1, "target_span" ,username);
	        createDatePickerPanel(lblNewLabel_7, "target_span" ,username);
        }
    });
	
	RoundedPanel panel_1_2 = new RoundedPanel(30);
	panel_1_2.setBackground(new Color(255, 255, 255));
	panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_1_2.setBounds(380, 455, 233, 90);
	contentPane_1.add(panel_1_2);
	panel_1_2.setLayout(null);
	
	JLabel lblNewLabel_1_2 = new JLabel("Your Budget");
	lblNewLabel_1_2.setBounds(52, 6, 128, 24);
	lblNewLabel_1_2.setForeground(new Color(46, 66, 77));
	lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
	panel_1_2.add(lblNewLabel_1_2);
	
	double budgetAmount = getBudgetAmountFromDB(username);
	DecimalFormat df = new DecimalFormat("₱#,##0.##");
	String formattedBudgetAmount = df.format(budgetAmount);
	
	
	RoundedLabel lblNewLabel_7_2 = new RoundedLabel(formattedBudgetAmount, 30);
	lblNewLabel_7_2.setBounds(10, 43, 213, 37);
	panel_1_2.add(lblNewLabel_7_2);
	lblNewLabel_7_2.setBackground(new Color(46, 66, 77));
	lblNewLabel_7_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String budgetAmountString = JOptionPane.showInputDialog(null, "Enter budget amount:");
            if (budgetAmountString != null && !budgetAmountString.isEmpty()) {
                try {
                    double newBudgetAmount = Double.parseDouble(budgetAmountString);
                    saveBudgetAmount(username, newBudgetAmount);
                    String formattedNewBudgetAmount = newBudgetAmount % 1 == 0 ?
                    String.format("₱%.0f", newBudgetAmount) : String.format("₱%.2f", newBudgetAmount);
                    lblNewLabel_7_2.setText(formattedNewBudgetAmount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        }
    });
	RoundedPanel panel_5_2 = new RoundedPanel(30);
	panel_5_2.setBounds(10, 43, 213, 37);
	panel_1_2.add(panel_5_2);
	panel_5_2.setLayout(null);
	panel_5_2.setForeground(Color.WHITE);
	panel_5_2.setBackground(new Color(46, 66, 77));
	lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_7_2.setForeground(Color.WHITE);
	lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
	RoundedPanel panel_1_3 = new RoundedPanel(30);
	panel_1_3.setBackground(new Color(255, 255, 255));
	panel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_1_3.setBounds(380, 607, 233, 90);
	contentPane_1.add(panel_1_3);
	panel_1_3.setLayout(null);
	
	JLabel lblTotalExpenses = new JLabel("Total Expenses");
	lblTotalExpenses.setBounds(37, 6, 158, 24);
	lblTotalExpenses.setForeground(new Color(46, 66, 77));
	lblTotalExpenses.setHorizontalAlignment(SwingConstants.CENTER);
	lblTotalExpenses.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
	panel_1_3.add(lblTotalExpenses);
	
	RoundedPanel panel_5_3 = new RoundedPanel(30);
	panel_5_3.setLayout(null);
	panel_5_3.setForeground(Color.WHITE);
	panel_5_3.setBackground(new Color(46, 66, 77));
	panel_5_3.setBounds(10, 43, 213, 37);
	panel_1_3.add(panel_5_3);
	
	String totalExpensesString = df.format(totalExpenses);
	JLabel lblTotalValue = new JLabel(totalExpensesString);
	lblTotalValue.setHorizontalAlignment(SwingConstants.CENTER);
	lblTotalValue.setForeground(Color.WHITE);
	lblTotalValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblTotalValue.setBounds(0, 0, 213, 37);
	panel_5_3.add(lblTotalValue);
	
	RoundedPanel panel_1_4 = new RoundedPanel(30);
	panel_1_4.setBackground(new Color(255, 255, 255));
	panel_1_4.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_1_4.setBounds(380, 731, 233, 90);
	contentPane_1.add(panel_1_4);
	panel_1_4.setLayout(null);
	
	JLabel lblNewLabel_1_4 = new JLabel("Estimated Savings");
	lblNewLabel_1_4.setBounds(20, 6, 192, 24);
	lblNewLabel_1_4.setForeground(new Color(46, 66, 77));
	lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
	panel_1_4.add(lblNewLabel_1_4);
	
	RoundedPanel panel_5_4 = new RoundedPanel(30);
	panel_5_4.setLayout(null);
	panel_5_4.setForeground(Color.WHITE);
	panel_5_4.setBackground(new Color(46, 66, 77));
	panel_5_4.setBounds(10, 43, 213, 37);
	panel_1_4.add(panel_5_4);
	
	double budget = getBudgetAmountFromDB(username);
	double estimatedSavings = budget - totalExpenses;
	String estimatedSavingsString = "₱" + (estimatedSavings % 1 == 0 ? String.format("%.0f", estimatedSavings) : String.format("%.2f", estimatedSavings));
	JLabel lblNewLabel_7_4 = new JLabel(estimatedSavingsString);
	lblNewLabel_7_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_7_4.setForeground(Color.WHITE);
	lblNewLabel_7_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_7_4.setBounds(0, 0, 213, 37);
	panel_5_4.add(lblNewLabel_7_4);
	
	panel_2 = new JPanel();
    panel_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(46, 66, 77), null, null, null), null));
    panel_2.setBounds(772, 190, 669, 647);
    panel_2.setLayout(null);
    contentPane_1.add(panel_2);

    panelContainer = new JPanel();
    panelContainer.setLayout(new GridBagLayout());

    JScrollPane scrollPane = new JScrollPane(panelContainer);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(27, 105, 615, 435);
    panel_2.add(scrollPane);

    RoundedButton btnNewButton = new RoundedButton("+", 20);
    btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 59));
    btnNewButton.setBackground(new Color(92, 196, 157));
    btnNewButton.setBorderPainted(false);
    btnNewButton.setContentAreaFilled(true);
    btnNewButton.setOpaque(true);
    btnNewButton.setBounds(57, 562, 197, 56);
    panel_2.add(btnNewButton);

    RoundedButton btnDelete = new RoundedButton("DELETE", 20);
    btnDelete.addActionListener(e -> {
        deleteMode = !deleteMode;
        btnDelete.setText(deleteMode ? "CANCEL DELETE" : "DELETE");
        panelContainer.setCursor(deleteMode ? Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR) : Cursor.getDefaultCursor());
    });
    
    btnDelete.setForeground(new Color(255, 255, 255));
    btnDelete.setOpaque(true);
    btnDelete.setBorderPainted(false);
    btnDelete.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
    btnDelete.setContentAreaFilled(true);
    btnDelete.setBackground(new Color(255, 0, 0));
    btnDelete.setBounds(404, 562, 197, 56);
    panel_2.add(btnDelete);

    JLabel lblNewLabel_5 = new JLabel("LIST OF EXPENSES");
    lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
    lblNewLabel_5.setForeground(new Color(46, 66, 77));
    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_5.setBounds(0, 24, 669, 30);
    panel_2.add(lblNewLabel_5);

    JLabel lblNewLabel_6 = new JLabel("EXPENSES");
    lblNewLabel_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
    lblNewLabel_6.setForeground(new Color(46, 66, 77));
    lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_6.setBounds(27, 64, 265, 42);
    panel_2.add(lblNewLabel_6);

    JLabel lblNewLabel_6_1 = new JLabel("AMOUNT");
    lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_6_1.setForeground(new Color(46, 66, 77));
    lblNewLabel_6_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
    lblNewLabel_6_1.setBounds(359, 64, 265, 42);
    panel_2.add(lblNewLabel_6_1);
    
    RoundedPanel panel_4_1 = new RoundedPanel(30);
	panel_4_1.setBackground(new Color(46, 66, 77));
	panel_4_1.setBounds(234, 106, 1199, 3);
	contentPane_1.add(panel_4_1);
	
	JLabel lblNewLabel_4 = new JLabel("Manage your money wisely.");
	lblNewLabel_4.setForeground(new Color(46, 66, 77));
	lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
	lblNewLabel_4.setBounds(234, 35, 655, 61);
	contentPane_1.add(lblNewLabel_4);
	initializeDates(username, lblNewLabel_7, lblNewLabel_7_1);	
	fetchAndDisplayExpenses(username);
	
	JLabel lblNewLabel_8 = new JLabel("New label");
	ImageIcon backImg = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\bg.png");
	Image bg = backImg.getImage().getScaledInstance(2000, 1500, Image.SCALE_SMOOTH);
	lblNewLabel_8.setBounds(71, -24, 1571, 1093);
	ImageIcon resizedBG = new ImageIcon(bg);
	lblNewLabel_8.setIcon(resizedBG);
	contentPane_1.add(lblNewLabel_8);

	btnNewButton.addActionListener(e -> {
	    String[] categories = {"Food", "Education", "Bills", "Necessities", "Transportation", "Other"};
	    JComboBox<String> categoryComboBox = new JComboBox<>(categories);
	    JTextField expenseNameField = new JTextField();
	    JTextField expenseAmountField = new JTextField();

	    Object[] inputFields = {
	        "Select Category:", categoryComboBox,
	        "Expense Name:", expenseNameField,
	        "Expense Amount:", expenseAmountField
	    };

	    int option = JOptionPane.showConfirmDialog(null, inputFields, "New Expense", JOptionPane.OK_CANCEL_OPTION);
	    if (option == JOptionPane.OK_OPTION) {
	        String category = (String) categoryComboBox.getSelectedItem();
	        String expenseName = expenseNameField.getText();
	        String expenseAmountString = expenseAmountField.getText();

	        if (expenseName.isEmpty() || expenseAmountString.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Expense Name and Expense Amount cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	            try {
	                double expenseAmount = Double.parseDouble(expenseAmountString);

	                saveToDatabase(category, expenseName, expenseAmount, username);

	                panelGroupCount += 2;
	                addPanelGroup(panelGroupCount - 1, panelGroupCount, expenseName, expenseAmountString, option, username);
	                panelContainer.revalidate();
	                panelContainer.repaint();

	                updateTotalExpenses(username);

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
	                

	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(null, "Expense Amount must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }
	});

    }

private void updateEstimatedSavings(String username) throws SQLException {
    double budget = getBudgetAmountFromDB(username);
	String estimatedSavingsString = "₱" + String.format("%.2f", budget - totalExpenses);
	if (lblNewLabel_7_4 != null) { 
	    lblNewLabel_7_4.setText(estimatedSavingsString);
	    
	}
}

private void saveToTotal(String totalExpensesString, String estimatedSavingsString, String username) {
    double totalExpenses = Double.parseDouble(totalExpensesString.replaceAll("[^0-9.-]", ""));
    double estimatedSavings = Double.parseDouble(estimatedSavingsString.replaceAll("[^0-9.-]", ""));

    String query = "INSERT INTO \"" + username + "_TOTAL\" (TOTAL_EXPENSE, TOTAL_SAVINGS, TOTAL_DATE) VALUES (?,?,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setDouble(1, totalExpenses);
        preparedStatement.setDouble(2, estimatedSavings);
        preparedStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to save to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void fetchAndDisplayExpenses(String username) {
    try {
        String query = "SELECT ID, EXPENSE_NAME, EXPENSE_AMOUNT FROM \"" + username + "_EXPENSE\"";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String expenseName = resultSet.getString("EXPENSE_NAME");
            double expenseAmount = resultSet.getDouble("EXPENSE_AMOUNT");

            String expenseAmountString = String.valueOf(expenseAmount);
            if (expenseAmount % 1 == 0) {
                expenseAmountString = String.valueOf((int) expenseAmount);
            }
            
            updateEstimatedSavings(username);

            panelGroupCount += 2;
            addPanelGroup(panelGroupCount - 1, panelGroupCount, expenseName, expenseAmountString, id, username);
        }

        panelContainer.revalidate();
        panelContainer.repaint();

        resultSet.close();
        preparedStatement.close();
        
        updateTotalExpenses(username);
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to fetch expenses from the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void updateTotalExpenses(String username) {
    try {
        String query = "SELECT SUM(EXPENSE_AMOUNT) AS total FROM \"" + username + "_EXPENSE\"";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            totalExpenses = resultSet.getDouble("total");
        } else {
            totalExpenses = 0.0;
        }

        if (lblTotalValue!= null) { 
            String totalExpensesString = "₱" + String.format("%.2f", totalExpenses);
            lblTotalValue.setText(totalExpensesString);

            double budget = getBudgetAmountFromDB(username);
            String estimatedSavingsString = "₱" + String.format("%.2f", budget - totalExpenses);
            if (lblNewLabel_7_4!= null) { 
                lblNewLabel_7_4.setText(estimatedSavingsString);
            }

            saveToTotal(totalExpensesString, estimatedSavingsString, username);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to calculate total expenses from the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void addPanelGroup(int index1, int index2, String expenseName, String expenseAmount, final int id, final String username) {
    Color backgroundColor1 = (index1 % 4 == 1 || index1 % 4 == 2) ? new Color(46, 66, 77) : new Color(27, 43, 66);
    Color backgroundColor2 = (index2 % 4 == 1 || index2 % 4 == 2) ? new Color(46, 66, 77) : new Color(27, 43, 66);

    GridBagConstraints gbc1 = createGridBagConstraints(0, panelContainer.getComponentCount());
    JPanel panel1 = createPanel(index1, backgroundColor1, expenseName);
    panelContainer.add(panel1, gbc1);

    String formattedExpenseAmount = "₱" + expenseAmount;
    GridBagConstraints gbc2 = createGridBagConstraints(1, panelContainer.getComponentCount() - 1);
    JPanel panel2 = createPanel(index2, backgroundColor2, formattedExpenseAmount);
    panelContainer.add(panel2, gbc2);

    panel1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (deleteMode) {
            	deleteExpense(id, username, panel1, panel2);

            }
        }
    });

    panel2.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (deleteMode) {
            	deleteExpense(id, username, panel1, panel2);

            }
        }
    });
}

    private GridBagConstraints createGridBagConstraints(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = (x == 0) ? new Insets(5, 5, 5, 25) : new Insets(5, 25, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }
    
    private void deleteExpense(int id, String username, JPanel panel1, JPanel panel2) {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this expense?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE FROM \"" + username + "_EXPENSE\" WHERE ID = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    updateTotalExpenses(username); 
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
                    JOptionPane.showMessageDialog(this, "Expense deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Expense not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                
                String totalExpensesString = "₱" + (totalExpenses % 1 == 0 ? String.format("%.0f", totalExpenses) : String.format("%.2f", totalExpenses));
                double budget = getBudgetAmountFromDB(username);
            	String estimatedSavingsString = "₱" + String.format("%.2f", budget - totalExpenses);
                
               
                saveToTotal(totalExpensesString, estimatedSavingsString, username);
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to delete expense from the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JPanel createPanel(int index, Color backgroundColor, String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(backgroundColor);
        panel.setPreferredSize(new Dimension(265, 42));
        panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(46, 66, 77), null, null, null), null));

        JLabel lblIndex = new JLabel(labelText);
        lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
        lblIndex.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblIndex.setForeground(new Color(255, 255, 255));
        lblIndex.setBounds(10, 10, 245, 22);
        panel.add(lblIndex);
        
        return panel;
    }

    public void establishDBConnection() {
        try {
        	 String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
             String dbUsername = "postgres";
             String password = "allocare";
            connection = DriverManager.getConnection(jdbcURL, dbUsername, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Database Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saveToDatabase(String category, String expenseName, double expenseAmount, String username) {
        String query = "INSERT INTO \"" + username + "_EXPENSE\" (EXPENSE_CATEGORY, EXPENSE_NAME, EXPENSE_AMOUNT, EXPENSE_DATE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	preparedStatement.setString(1, category);
        	preparedStatement.setString(2, expenseName);
        	preparedStatement.setDouble(3, expenseAmount);
        	preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save expense to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
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
    
    private void createDatePickerPanel(JLabel targetLabel, String dateType, String username) {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        JPanel panel = new JPanel();
        panel.add(datePicker);

        int result = JOptionPane.showConfirmDialog(null, panel, "Select Date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Date selectedDate = (Date) datePicker.getModel().getValue();
            if (selectedDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(selectedDate);
                targetLabel.setText(formattedDate);

                if (dateType.equals("entered_date")) {
                    enteredDate = formattedDate;
                } else if (dateType.equals("target_span")) {
                    targetSpanDate = formattedDate;
                }

                if (enteredDate != null && targetSpanDate != null) {
                    saveDateToDatabase(enteredDate, targetSpanDate, username);
                }
            }
        }
    }
    
    private void saveDateToDatabase(String enteredDate, String targetSpanDate, String username) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String dbPassword = "allocare";

        String insertSQL = "INSERT INTO \"" + username + "_TARGET\" (target_span, entered_date) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setDate(1, java.sql.Date.valueOf(targetSpanDate));
            statement.setDate(2, java.sql.Date.valueOf(enteredDate));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Dates saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.enteredDate = null;
                this.targetSpanDate = null;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save dates.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void initializeDates(String username, JLabel lblNewLabel_7, JLabel lblNewLabel_7_1) {
        fetchAndDisplayDates(username, lblNewLabel_7, lblNewLabel_7_1);
    }

    private void fetchAndDisplayDates(String username, JLabel enteredDateLabel, JLabel targetSpanLabel) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/allocareDB";
        String dbUsername = "postgres";
        String dbPassword = "allocare";

        String selectSQL = "SELECT target_span, entered_date FROM \"" + username + "_TARGET\" ORDER BY id DESC LIMIT 1";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                String targetSpan = resultSet.getString("target_span");
                String enteredDate = resultSet.getString("entered_date");

                if (targetSpan != null) {
                    targetSpanLabel.setText(targetSpan);
                }
                if (enteredDate != null) {
                    enteredDateLabel.setText(enteredDate);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
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