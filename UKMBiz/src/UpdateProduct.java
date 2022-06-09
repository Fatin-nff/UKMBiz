import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;  
import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;

public class UpdateProduct extends JFrame implements ActionListener{

//	ArrayList<Product> updateProductList = Product.updateProductList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProduct frame = new UpdateProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 	* @throws IOException
	 */
	private JPanel contentPane;
	private JTextField txt_SellerID;
	private JTextField txt_SellerName;
	private JTextField txt_Name;
	private JTextField txt_Stock;
	private JTextField txt_Category;
	private JTextField txt_Price;
	private JTextField txt_Colour;
	private JTextField txt_ProductID;
	private JTable tbl_Product;
	private JButton btnRegisterProduct;
	private JButton btnUpdateProduct;
	private JButton btnViewProduct;
	private JButton btn_logout;
	private JButton btn_Delete;
	private JButton btn_Update;
	private JTextPane txt_Description;
	
	DefaultTableModel model;
	
	ArrayList<Product> regProductList = new ArrayList<Product>();
	

	
	public UpdateProduct() throws IOException {
		//ReadFile();
		//ReadFile1();
		setTitle("UKMBiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(0, 0, 890, 51);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Seller Panel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(174, 0, 244, 51);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pictures/ukmbiz logo3.jpg"));
		lblNewLabel.setBounds(0, 0, 164, 51);
		panel_4.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBackground(Color.PINK);
		panel_1_1.setBounds(0, 50, 890, 51);
		contentPane.add(panel_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.RED);
		separator_1.setBackground(Color.RED);
		separator_1.setBounds(345, 10, 12, 31);
		panel_1_1.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.RED);
		separator.setBackground(Color.RED);
		separator.setBounds(176, 10, 9, 31);
		panel_1_1.add(separator);
		
		btnRegisterProduct = new JButton("Register Product");
		btnRegisterProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegisterProduct.setBorderPainted(false);
		btnRegisterProduct.setBackground(Color.PINK);
		btnRegisterProduct.setBounds(7, 5, 160, 41);
		panel_1_1.add(btnRegisterProduct);
		
		
		btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateProduct.setBorderPainted(false);
		btnUpdateProduct.setBackground(Color.PINK);
		btnUpdateProduct.setBounds(186, 5, 154, 41);
		panel_1_1.add(btnUpdateProduct);
		
		
		btnViewProduct = new JButton("View Product");
		btnViewProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewProduct.setBorderPainted(false);
		btnViewProduct.setBackground(Color.PINK);
		btnViewProduct.setBounds(355, 5, 154, 41);
		panel_1_1.add(btnViewProduct);
		
		
		btn_logout = new JButton("Log Out");
		btn_logout.setForeground(Color.WHITE);
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_logout.setBackground(Color.RED);
		btn_logout.setBounds(780, 10, 85, 31);
		panel_1_1.add(btn_logout);
		
		JLabel lblSellerId = new JLabel("Seller ID :");
		lblSellerId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSellerId.setBounds(10, 111, 84, 22);
		contentPane.add(lblSellerId);
		
		txt_SellerID = new JTextField();
		txt_SellerID.setColumns(10);
		txt_SellerID.setBounds(89, 111, 96, 24);
		contentPane.add(txt_SellerID);
		
		JLabel lblSellerName = new JLabel("Seller Name :");
		lblSellerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSellerName.setBounds(195, 111, 113, 22);
		contentPane.add(lblSellerName);
		
		txt_SellerName = new JTextField();
		txt_SellerName.setColumns(10);
		txt_SellerName.setBounds(302, 111, 189, 22);
		contentPane.add(txt_SellerName);
		
		JLabel lblUpdateProduct = new JLabel("Update Product");
		lblUpdateProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateProduct.setForeground(Color.RED);
		lblUpdateProduct.setFont(new Font("Siro-Bold", Font.BOLD, 28));
		lblUpdateProduct.setBounds(303, 138, 247, 40);
		contentPane.add(lblUpdateProduct);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 394, 890, 207);
		contentPane.add(panel);
		
		JLabel lbl_Name = new JLabel("Name :");
		lbl_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Name.setBounds(21, 40, 94, 33);
		panel.add(lbl_Name);
		
		txt_Name = new JTextField();
		txt_Name.setColumns(10);
		txt_Name.setBounds(103, 46, 164, 25);
		panel.add(txt_Name);
		
		JLabel lbl_Stock = new JLabel("Stock :");
		lbl_Stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Stock.setBounds(394, 77, 44, 33);
		panel.add(lbl_Stock);
		
		txt_Stock = new JTextField();
		txt_Stock.setColumns(10);
		txt_Stock.setBounds(448, 83, 54, 25);
		panel.add(txt_Stock);
		
		btn_Delete = new JButton("Delete");
		btn_Delete.setForeground(Color.WHITE);
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Delete.setBackground(Color.RED);
		btn_Delete.setBounds(719, 97, 108, 48);
		panel.add(btn_Delete);
		
		
		btn_Update = new JButton("Update");		
		btn_Update.setForeground(Color.RED);
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Update.setBackground(Color.WHITE);
		btn_Update.setBounds(719, 26, 108, 48);
		panel.add(btn_Update);
		
		
		btnRegisterProduct.addActionListener(this);
		btnViewProduct.addActionListener(this);
		btn_Delete.addActionListener(this);
		btn_Update.addActionListener(this);
		btn_logout.addActionListener(this);
		
		txt_Category = new JTextField();
		txt_Category.setColumns(10);
		txt_Category.setBounds(363, 46, 139, 25);
		panel.add(txt_Category);
		
		txt_Price = new JTextField();
		txt_Price.setColumns(10);
		txt_Price.setBounds(296, 83, 88, 25);
		panel.add(txt_Price);
		
		JLabel lbl_Category = new JLabel("Category :");
		lbl_Category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Category.setBounds(290, 40, 79, 33);
		panel.add(lbl_Category);
		
		JLabel lbl_Price = new JLabel("Price (RM):");
		lbl_Price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Price.setBounds(216, 77, 70, 33);
		panel.add(lbl_Price);
		
		JLabel lbl_Description = new JLabel("Description :");
		lbl_Description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Description.setBounds(21, 110, 82, 33);
		panel.add(lbl_Description);
		
		JLabel lbl_colour = new JLabel("Colour :");
		lbl_colour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_colour.setBounds(21, 75, 70, 33);
		panel.add(lbl_colour);
		
		txt_Colour = new JTextField();
		txt_Colour.setColumns(10);
		txt_Colour.setBounds(103, 83, 108, 25);
		panel.add(txt_Colour);
		
		JLabel lbl_ProductId = new JLabel("Product ID :");
		lbl_ProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ProductId.setBounds(21, 3, 94, 33);
		panel.add(lbl_ProductId);
		
		txt_ProductID = new JTextField();
		txt_ProductID.setColumns(10);
		txt_ProductID.setBounds(103, 9, 164, 25);
		panel.add(txt_ProductID);
		
		txt_Description = new JTextPane();
		txt_Description.setBounds(103, 117, 399, 68);
		panel.add(txt_Description);

		
		// Table Product
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 189, 794, 178);
		contentPane.add(scrollPane);
		
		tbl_Product = new JTable();
		tbl_Product.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tbl_Product.getSelectedRow();
				
				DefaultTableModel model = (DefaultTableModel)tbl_Product.getModel();
				txt_ProductID.setText(model.getValueAt(i,0).toString());
				txt_Name.setText(model.getValueAt(i,1).toString());
				txt_Price.setText(model.getValueAt(i,2).toString());
				txt_Colour.setText(model.getValueAt(i,3).toString());
				txt_Category.setText(model.getValueAt(i,4).toString());
				txt_Stock.setText(model.getValueAt(i,5).toString());
				txt_Description.setText(model.getValueAt(i,6).toString());
			}
		});
		
		tbl_Product.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(tbl_Product.getSelectedRow() > -1) {
					int i = tbl_Product.getSelectedRow();
					
					Product p = regProductList.get(i);
					
					String [] choices = {"Yes", "No"};
		            int c = JOptionPane.showOptionDialog(null,"Delete Product ?","Please Select",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
		            
		            if(c == 0) {
		            	regProductList.remove(i);
		            	WriteFileUpdateProduct();
		            	JOptionPane.showMessageDialog(null,"Delete Successfull");
			                try {
			                	regProductList.clear();
		            	
							refreshFrame();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	
		            }
		            else if(c == 1) {
		            	
		            }
				}
			}
		});
		tbl_Product.setForeground(new Color(0, 0, 0));
		tbl_Product.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tbl_Product);
		tbl_Product.setBackground(new Color(255, 228, 225));
		//model = new DefaultTableModel();
		tbl_Product.setRowHeight(28);
		tbl_Product.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			"Product ID", "Name", "Price", "Colour", "Category", "Stock", "Description"
			}
		));
		tbl_Product.getColumnModel().getColumn(0).setPreferredWidth(91);
		ReadFile();
//		String ProductID, Name, Price, Colour, Category, Stock, Description;
		
		btn_Delete.addActionListener(this);
		
	}
	public void registerProduct() {		
		RegisterProduct register = null;
		try {
			register = new RegisterProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		register.setVisible(true);
		this.dispose();
	}
	
	public void viewProduct() {		
		ViewProduct view = new ViewProduct();
		view.setVisible(true);
		this.dispose();
	}
	
	public void refreshFrame() throws IOException
	{
		UpdateProduct main = new UpdateProduct();    
		main.setVisible(true);
		this.setVisible(false);			
	}
	
	public void ReadFile() {
		String fileName = "RegisteredProduct.txt";
		File file = new File(fileName);
	
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
		
			DefaultTableModel model = (DefaultTableModel)tbl_Product.getModel();
			Object [] lines = br.lines().toArray();
			for(int i=0; i<lines.length; i++) {
				String[] row = lines[i].toString().split(";");
				model.addRow(row);
			}
			reader.close();
			br.close();
		
		} catch (FileNotFoundException ex) {
			Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
		
		} catch (IOException ex) {
			Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
		
		}
	}
	
	public void ReadFile1() throws IOException {
		FileReader file = new FileReader("RegisteredProduct.txt");
		try(BufferedReader in = new BufferedReader(file)){
			String input = "";
			
			while((input = in.readLine()) !=null) {
				StringTokenizer word = new StringTokenizer(input, ";");
				
				String productID = word.nextToken();
				String name = word.nextToken();
				double price = Double.parseDouble(word.nextToken());
				String colour = word.nextToken();
				String category = word.nextToken();
				int stock = Integer.parseInt(word.nextToken());
				String description = word.nextToken();
				
				Product pr = new Product(productID,name,price,colour,category,stock,description);
				
				regProductList.add(pr);
		
			}
		}
		
		for(int i=0; i<regProductList.size(); i++) {
			Product s = (Product)regProductList.get(i);
			System.out.println(s.getProductID()+ s.getName()+ s.getPrice()+ s.getColour()+ s.getCategory()+ s.getStock()+ s.getDescription());
		}
	}
	
	public void WriteFileUpdateProduct() {
		String productID, name, price,category, color, stock, description;

		DefaultTableModel model = (DefaultTableModel)tbl_Product.getModel();
		if(tbl_Product.getSelectedRowCount() == 1) {
		
//			model.removeRow(tbl_product.getSelectedRow());
			
			productID = txt_ProductID.getText();
			name = txt_Name.getText();
			price = txt_Price.getText();
			category = txt_Category.getText();
			color = txt_Colour.getText();			
			stock = txt_Stock.getText();
			description = txt_Description.getText();
		
			model.setValueAt(productID, tbl_Product.getSelectedRow(), 0);
			model.setValueAt(name, tbl_Product.getSelectedRow(), 1);
			model.setValueAt(price, tbl_Product.getSelectedRow(), 2);
			model.setValueAt(color, tbl_Product.getSelectedRow(), 3);
			model.setValueAt(category, tbl_Product.getSelectedRow(), 4);
			model.setValueAt(stock, tbl_Product.getSelectedRow(), 5);
			model.setValueAt(description, tbl_Product.getSelectedRow(), 6);
	
			try {
				
				FileWriter file = new FileWriter("RegisteredProduct.txt");
				BufferedWriter bw = new BufferedWriter(file);
				
				for(int i=0; i<tbl_Product.getRowCount();i++) {
					for(int j=0; j<tbl_Product.getColumnCount();j++) {
						bw.write(tbl_Product.getValueAt(i,j).toString()+";");
					}
					bw.newLine();
				}
				bw.close();
				file.close();
			}
			catch(IOException ex) {
				Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
			}
			JOptionPane.showMessageDialog(null, "Data Updated!");
		}
			else {
				if(tbl_Product.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is Empty.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select the row to update.");
				}
		}
		
	}
	
	public void deleteRowProduct() {		
		
//		//DefaulTableModel tblModel = (DefaultTableModel) tbl_
//		if(tbl_Product.getSelectedRowCount() != 0) {
//			regProductList.remove(tbl_Product.getSelectedRow());
//			JOptionPane.showMessageDialog(null, "Delete Successfull");
//		}
//		else if(tbl_Product.getSelectedRowCount() == 0){
//			JOptionPane.showMessageDialog(null, "No item to be deleted");
//		}
		int i = tbl_Product.getSelectedRow();
		
		System.out.println(tbl_Product.getSelectedRow());
		
		String [] choices = {"Yes", "No"};
        int c = JOptionPane.showOptionDialog(null,"Delete Product ?","Please Select",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
        
        if(c == 0) {
        	regProductList.remove(i);
        	WriteFileUpdateProduct();
        	JOptionPane.showMessageDialog(null,"Delete Successfull");
                try {
                	regProductList.clear();
        	
				refreshFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }
        else if(c == 1) {
        	
        }
	}
	
//	public void removeSelectedRows(JTable tbl_Product){
//		   DefaultTableModel model = (DefaultTableModel) this.tbl_Product.getModel();
//		   int[] rows = tbl_Product.getSelectedRows();
//		   for(int i=0;i<rows.length;i++){
//			   model.removeRow(rows[i]-i);
//		   }
//		}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Register Product")) {
			registerProduct();
		}
		else if(e.getActionCommand().equals("View Product")) {
			viewProduct();
		}
		else if(e.getActionCommand().equals("Update")) {
			WriteFileUpdateProduct();
			try {
				refreshFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Delete")) {
			deleteRowProduct();
		}
		
		else if(e.getActionCommand().equals("Log Out")) {
			dispose();
		}
	}
}
