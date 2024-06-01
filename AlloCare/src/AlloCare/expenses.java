package AlloCare;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;



public class expenses extends JFrame {
	private Connection connection;
	private double totalExpenses = 0.0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_1;
    private boolean isEditable = false;
	protected AbstractTableModel model;
    boolean isToggled = false;
    boolean isToggled1 = false;
    boolean isToggled2 = false;
    private JTextField searchField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expenses frame = new expenses("");
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
	public expenses(String username) {
		establishDBConnection();
		updateTotalExpenses(username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(2000, 2000, 2000, 2000);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

		// Get screen dimensions
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
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(23, 37, img.getWidth(null), img.getHeight(null));

        panel.setLayout(null);
        panel.add(lblNewLabel);
        
        RoundedButton btnNewButton_2 = new RoundedButton("HOME", 20);
        btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
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
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnNewButton_2.setBackground(new Color(46, 66, 77));
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
        
        RoundedButton btnNewButton_2_1_1 = new RoundedButton("EXPENSES", 20);
        btnNewButton_2_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
        btnNewButton_2_1_1.setBackground(new Color(255, 255, 255));
        btnNewButton_2_1_1.setForeground(new Color(46, 66, 77));
        btnNewButton_2_1_1.setBorderPainted(false);
        btnNewButton_2_1_1.setBounds(23, 364, 120, 52);
        panel.add(btnNewButton_2_1_1);
       
        JButton btnNewButton_3_1_1 = new JButton("");
        btnNewButton_3_1_1.addActionListener(new ActionListener() {
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
        
      
        
        AlloCare.RoundedButton btnNewButton_2_1_1_1 = new AlloCare.RoundedButton("NOTES", 20);
        btnNewButton_2_1_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		   int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
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
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(46, 66, 77));
        panel_1.setBounds(234, 106, 1199, 3);
        contentPane.add(panel_1);
        
        JLabel lblNewLabel_1 = new JLabel("Dig more details to your expenses.");
        lblNewLabel_1.setForeground(new Color(46, 66, 77));
        lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
        lblNewLabel_1.setBounds(234, 35, 655, 61);
        contentPane.add(lblNewLabel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(46, 66, 77), null, null, null));
        panel_2.setBounds(234, 157, 278, 61);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Total Budget:");
        lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(10, 10, 258, 41);
        panel_2.add(lblNewLabel_2);
        
        double budgetAmount = getBudgetAmountFromDB(username);
    	DecimalFormat df = new DecimalFormat("₱#,##0.##");
    	String formattedBudgetAmount = df.format(budgetAmount);
        
        JLabel lblNewLabel_3 = new JLabel(formattedBudgetAmount);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(126, 10, 142, 41);
        panel_2.add(lblNewLabel_3);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(256, 161, 265, 69);
        contentPane.add(panel_3);
        panel_3.setBackground(new Color(27, 43, 66));
        panel_3.setLayout(null);
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(46, 66, 77), null, null, null));
        panel_2_1.setBounds(584, 157, 278, 61);
        contentPane.add(panel_2_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Expenses:");
        lblNewLabel_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblNewLabel_2_1.setBounds(10, 10, 258, 41);
        panel_2_1.add(lblNewLabel_2_1);
        
        String totalExpensesString = df.format(totalExpenses);
        JLabel lblNewLabel_3_1 = new JLabel(totalExpensesString);
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_1.setBounds(126, 10, 142, 41);
        panel_2_1.add(lblNewLabel_3_1);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setLayout(null);
        panel_3_1.setBackground(new Color(27, 43, 66));
        panel_3_1.setBounds(606, 161, 265, 69);
        contentPane.add(panel_3_1);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setLayout(null);
        panel_2_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(46, 66, 77), null, null, null));
        panel_2_2.setBounds(918, 157, 278, 61);
        contentPane.add(panel_2_2);
        
        JLabel lblNewLabel_2_2 = new JLabel("Savings:");
        lblNewLabel_2_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblNewLabel_2_2.setBounds(10, 10, 258, 41);
        panel_2_2.add(lblNewLabel_2_2);
        
        double budget = getBudgetAmountFromDB(username);
        double estimatedSavings = budget - totalExpenses;
        String estimatedSavingsString;
        if (estimatedSavings % 1 == 0) {
            estimatedSavingsString = "₱" + String.format("%.0f", estimatedSavings);
        } else {
            estimatedSavingsString = "₱" + String.format("%.2f", estimatedSavings);
        }
        JLabel lblNewLabel_3_2 = new JLabel(estimatedSavingsString);
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3_2.setBounds(126, 10, 142, 41);
        panel_2_2.add(lblNewLabel_3_2);
        
        JPanel panel_3_2 = new JPanel();
        panel_3_2.setLayout(null);
        panel_3_2.setBackground(new Color(27, 43, 66));
        panel_3_2.setBounds(940, 161, 265, 69);
        contentPane.add(panel_3_2);
        
        JLabel lblNewLabel_4 = new JLabel("For the latest details:");
        lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setBounds(234, 240, 180, 43);
        contentPane.add(lblNewLabel_4);
        

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBackground(new Color(46, 66, 77));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        ImageIcon plus1 = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-plus-96.png");
        Image plusimg1 = plus1.getImage();
        Image plusresized1 = plusimg1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedplus1 = new ImageIcon(plusresized1);
        btnNewButton.setIcon(resizedplus1);

        btnNewButton.setHorizontalTextPosition(JButton.LEFT); 

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

       	                updateTotalExpenses(username);

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
       	            } catch (NumberFormatException ex) {
       	                JOptionPane.showMessageDialog(null, "Expense Amount must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
       	            }
       	        }
       	    }
            }
        });  
        
     
        btnNewButton.setBounds(1145, 298, 111, 61);
        contentPane.add(btnNewButton);	        
        
        ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\notepad-edit-svgrepo-com.png");
        Image originalImage1 = originalIcon1.getImage();
        Image resizedImage1 = originalImage1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
        
        JButton btnNewButton1 = new JButton("Edit");
        btnNewButton1.setBorderPainted(false);
        btnNewButton1.setFocusPainted(false);
        btnNewButton1.setBackground(new Color(46, 66, 77));
        btnNewButton1.setForeground(new Color(255, 255, 255));
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnNewButton1.setIcon(resizedIcon1);
       
        
        btnNewButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isToggled) {
                    btnNewButton1.setBackground(new Color(46, 66, 77));
                } else {
                    btnNewButton1.setBackground(new Color(255, 165, 0)); 
                }
                isToggled = !isToggled;
            }
        });
        
        searchField = new JTextField();
        searchField.setBounds(234, 311, 380, 43);
        contentPane.add(searchField);
        searchField.setColumns(10);

        btnNewButton1.setHorizontalTextPosition(JButton.LEFT);     
    
        String[] columnNames = {"Expense Number","Category", "Date", "Expense Name", "Amount"};
        Object[][] data = getExpensesFromDB(username);

      
        class CustomTableModel extends DefaultTableModel {
            private static final long serialVersionUID = 1L;

            public CustomTableModel(Object[][] data, Object[] columnNames) {
                super(data, columnNames);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
            	  if (column == 0 || column == 2 ||!isEditable) {
                    return false;
                }
            	
                return super.isCellEditable(row, column);
            }
        }
        
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 isEditable = !isEditable;
            }
        });
        btnNewButton1.setBounds(1322, 298, 111, 61);
        contentPane.add(btnNewButton1);

        CustomTableModel model = new CustomTableModel(data, columnNames);
        this.model = model; 
        JTable table = new JTable(model);

        table.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer(table));
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table.setRowHeight(73); 
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setBounds(234, 380, 1199, 419);
        contentPane.add(scrollPane);
        
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setFont(new Font("Tahoma", Font.PLAIN, 20));
                label.setHorizontalAlignment(JLabel.CENTER); 
                return label;
            }
        });
        
        
        JButton btnNewButton_1 = new JButton("Delete");
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setFocusPainted(false);

        
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    Object newValue = model.getValueAt(row, column);
                    String dbColumnName = getDatabaseColumnName(columnNames[column]);
                    updateDatabase(username, row, dbColumnName, newValue);
                }
            }
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	if (row != -1) {
            		int id = (int) model.getValueAt(row, 0);
            		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this expense?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            		if (confirm == JOptionPane.YES_OPTION) {
            			deleteFromDatabase(username, id);
            			updateTotalExpenses(username);
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
            			((DefaultTableModel) model).removeRow(row);
            		}
            	}
            }
        });
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTableWithSearch(searchField.getText(), username);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTableWithSearch(searchField.getText(), username);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTableWithSearch(searchField.getText(), username);
            }
        });

        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTableWithSearch(searchField.getText(), username);
            }
        });
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1.setBackground(new Color(46, 66, 77));
		btnNewButton_1.setBounds(940, 298, 137, 61);
		contentPane.add(btnNewButton_1);
		
		ImageIcon del = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\icons8-cross-90.png");
	    Image delimg = del.getImage();
	    Image delresized = delimg.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	    ImageIcon resizeddel = new ImageIcon(delresized);
	    btnNewButton_1.setIcon(resizeddel);
        
        JLabel lblNewLabel_8 = new JLabel("New label");
		ImageIcon backImg = new ImageIcon("C:\\Users\\earlo\\OneDrive\\Desktop\\ECLIPSE\\PICTURES\\logos\\bg.png");
		Image bg = backImg.getImage().getScaledInstance(2000, 1500, Image.SCALE_SMOOTH);
		lblNewLabel_8.setBounds(71, -24, 1571, 1093);
		ImageIcon resizedBG = new ImageIcon(bg);
		lblNewLabel_8.setIcon(resizedBG);
		contentPane.add(lblNewLabel_8);	
	}
	
    private void saveToDatabase(String category, String expenseName, double expenseAmount, String username) {
        String query = "INSERT INTO \"" + username + "_EXPENSE\" (EXPENSE_CATEGORY, EXPENSE_NAME, EXPENSE_AMOUNT, EXPENSE_DATE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	preparedStatement.setString(1, category);
        	preparedStatement.setString(2, expenseName);
        	preparedStatement.setDouble(3, expenseAmount);
        	  preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save expense to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateTableWithSearch(String searchText, String username) {
        try {
            List<Object[]> results = searchExpensesFromDB(searchText, username);
            ((DefaultTableModel) model).setRowCount(0);
            for (Object[] row : results) {
                ((DefaultTableModel) model).addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "Error fetching search results.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private List<Object[]> searchExpensesFromDB(String searchText, String username) throws SQLException {
        List<Object[]> expensesList = new ArrayList<>();
        String query = "SELECT id, expense_category, expense_name, expense_amount, expense_date " +
                       "FROM \"" + username + "_EXPENSE\" " +
                       "WHERE expense_category ILIKE ? OR expense_name ILIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            String searchPattern = "%" + searchText + "%";
            statement.setString(1, searchPattern);
            statement.setString(2, searchPattern);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String category = resultSet.getString("expense_category");
                String expenseName = resultSet.getString("expense_name");
                double amount = resultSet.getDouble("expense_amount");
                Date date = resultSet.getDate("expense_date");

                DecimalFormat amountFormat = new DecimalFormat("₱#,##0.##");
                Object[] row = {id, category, date, expenseName, amountFormat.format(amount)};
                expensesList.add(row);
            }
        }

        return expensesList;
    }

    private void deleteFromDatabase(String username, int id) {
        String sql = "DELETE FROM \"" + username + "_EXPENSE\" WHERE id =?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to delete from the database.", "Database Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
	
	private Object[][] getExpensesFromDB(String username) {
	    List<Object[]> expensesList = new ArrayList<>();

	    try {
	        String sql = "SELECT id, expense_category, EXPENSE_NAME, EXPENSE_AMOUNT, EXPENSE_DATE FROM \"" + username + "_EXPENSE\"";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();

	        DecimalFormat amountFormat = new DecimalFormat("₱#,##0.##"); 

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String category = resultSet.getString("expense_category");
	            String expensename = resultSet.getString("EXPENSE_NAME");
	            double amount = resultSet.getDouble("EXPENSE_AMOUNT");
	            Date date = resultSet.getDate("EXPENSE_DATE");

	            Object[] row = {id, category, date, expensename, amountFormat.format(amount)}; 
	            expensesList.add(row);
	        }

	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    Object[][] expensesArray = new Object[expensesList.size()][5];
	    for (int i = 0; i < expensesList.size(); i++) {
	        expensesArray[i] = expensesList.get(i);
	    }

	    return expensesArray;
	}
	
	
	  private String getDatabaseColumnName(String displayColumnName) {
		    switch (displayColumnName) {
		        case "Category":
		            return "expense_category";
		        case "Expense Name":
		            return "expense_name";
		        case "Amount":
		            return "expense_amount";
		        case "Date":
		            return "expense_date";
		        default:
		            throw new IllegalArgumentException("Invalid column name: " + displayColumnName);
		    }
		}

	  private void updateDatabase(String username, int row, String columnName, Object newValue) {
		    String sql = "UPDATE \"" + username + "_EXPENSE\" SET " + columnName + " =? WHERE id =?";

		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		        if (columnName.equals("expense_amount")) {
		            statement.setDouble(1, Double.parseDouble(newValue.toString())); 
		        } else {
		            statement.setObject(1, newValue);
		        }
		        statement.setInt(2, (int) model.getValueAt(row, 0));
		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(this, "Failed to update the database.", "Database Update Error", JOptionPane.ERROR_MESSAGE);
		    }
		}

	
	private void updateEstimatedSavings(String username) throws SQLException {
	    double budget = getBudgetAmountFromDB(username);
		String estimatedSavingsString = "₱" + String.format("%.2f", budget - totalExpenses);
		if (lblNewLabel_3_2 != null) { 
			lblNewLabel_3_2.setText(estimatedSavingsString);
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
	
	private void establishDBConnection() {
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

	        if (lblNewLabel_3_1 != null) {
	        	lblNewLabel_3_1.setText("₱" + String.format("%.2f", totalExpenses));
	        }
	        
	        updateEstimatedSavings(username);

	        resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Failed to calculate total expenses from the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}


