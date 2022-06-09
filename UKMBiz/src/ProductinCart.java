import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProductinCart extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tbl_product;
	private JComboBox cmb_category;
	private JTextField txtName, txt_colour, txt_description,txt_Price, txt_stock;
	private JLabel txt_ProductID;
	private JTextField txt_total;
	private JButton btn_checkout;
	private JLabel lbl_total;
	
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductinCart frame = new ProductinCart();
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
	public ProductinCart() throws IOException {
		readCartFile();
		
		setTitle("UKMBiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(0, 0, 764, 51);
		contentPane.add(panel_4);
		
		JLabel lbl_title = new JLabel("Shopping Cart");
		lbl_title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lbl_title.setBounds(174, 0, 360, 51);
		panel_4.add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pictures/ukmbiz logo3.jpg"));
		lblNewLabel.setBounds(0, 0, 164, 51);
		panel_4.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 61, 678, 224);
		contentPane.add(scrollPane);
		
		tbl_product = addRowDataCart();
		
		tbl_product.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				if(tbl_product.getSelectedRow() > -1) {
					int i = tbl_product.getSelectedRow();
					
					Cart cr = cartList.get(i);
					
					String [] choices = {"Yes", "No"};
		            int c = JOptionPane.showOptionDialog(null,"Delete Product ?","Please Select",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
		            
		            if(c == 0) {
		            	cartList.remove(i);
		            	writeCartListToFile();
		            	 JOptionPane.showMessageDialog(null,"Delete Successfull");
			                try {
			                	cartList.clear();
		            	
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
		scrollPane.setViewportView(tbl_product);
		tbl_product.setBackground(SystemColor.menu);
		
		btn_checkout = new JButton("Check Out");
		btn_checkout.setForeground(Color.WHITE);
		btn_checkout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_checkout.setBackground(Color.RED);
		btn_checkout.setBounds(576, 349, 139, 36);
		contentPane.add(btn_checkout);
		
		JButton btn_back = new JButton("Back");

		btn_back.setForeground(Color.WHITE);
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_back.setBackground(Color.RED);
		btn_back.setBounds(37, 349, 107, 36);
		contentPane.add(btn_back);
		
		JLabel lbl_Total = new JLabel("Total :");
		lbl_Total.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_Total.setBounds(520, 302, 62, 36);
		contentPane.add(lbl_Total);
		
		txt_total = new JTextField();
		txt_total.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_total.setBounds(576, 305, 126, 33);
		contentPane.add(txt_total);
		txt_total.setColumns(10);
		
		TotalPrice();
		
		lbl_total = new JLabel("New label");
		lbl_total.setBounds(235, 324, 46, 14);
		contentPane.add(lbl_total);
		
		btn_checkout.addActionListener(this);
		
		
	}
	
	public void writeCartListToFile() {
		try {
			FileWriter file = new FileWriter("Cart.txt");
			PrintWriter out = new PrintWriter(file);
			
			for(int i=0; i<cartList.size(); i++) {
				Cart c = cartList.get(i);
				
				out.print(c.getProduct().getProductID() +";"+ c.getProduct().getName() +";"+ c.getProduct().getPrice() +";"+ c.getProduct().getColour() +";"+ c.getProduct().getCategory() +";"+ c.getProduct().getStock() +";"+ c.getProduct().getDescription() +";"+ c.getQuantity());
				out.println();
			}
			//JOptionPane.showMessageDialog(null,"Add To Cart Successfully!");
            out.close();
		}
        catch(IOException ex){System.out.println("There's no such file!");}
	}
	
	public void readCartFile() throws IOException {
			
			FileReader file = new FileReader("Cart.txt");
			try(BufferedReader in = new BufferedReader(file)){
				
				String input = " ";
				
				while((input = in.readLine()) !=null) 
				{
					StringTokenizer word = new StringTokenizer(input,";");
					
					String productID = word.nextToken();
					String name = word.nextToken();
					double price = Double.parseDouble(word.nextToken());
					String colour = word.nextToken();
					String category = word.nextToken();
					int stock = Integer.parseInt(word.nextToken());
					String description = word.nextToken();				
					int quantity = Integer.parseInt(word.nextToken());
					
					Product pr = new Product(productID,name,price,colour,category,stock,description);
					Cart cr = new Cart(quantity, pr);
					
					cartList.add(cr);
				}
			}
		}
	
	public JTable addRowDataCart() {
		JTable tbl_product;
		Object[] columns = {"Product ID", "Name", "Price (RM)", "Quantity"};
		Object data[][] = new Object[cartList.size()][4];
		
		for(int i=0; i<cartList.size(); i++) {
			Cart item = (Cart)cartList.get(i);
			
			data[i][0] = item.getProduct().getProductID();
			data[i][1] = item.getProduct().getName();
			data[i][2] = item.getProduct().getPrice();
			data[i][3] = item.getQuantity();
		}
		tbl_product = new JTable(data, columns);
		return tbl_product;
	}
	
	public void paymentMethod() {
		String[] ptype = {"Online Banking", "Credit Card", "COD"};
		int option=JOptionPane.showOptionDialog(null, "Choose your payment method.", "Payment Method", 0, JOptionPane.QUESTION_MESSAGE, null, ptype, ptype);
		if(option ==  0) {
			JOptionPane.showMessageDialog(null, "Your item is ready to be ship!");
		}
		if(option ==  1) {
			JOptionPane.showMessageDialog(null, "Your item is ready to be ship. Thank You for your purchase. Hope you have a nice day!");
		}
		if(option ==  2) {
			JOptionPane.showMessageDialog(null, "Your item is ready to be deliver!");
		}
		
	}
	
	//when click checkout
	public void checkout() {
		String fileName = "Cart.txt";
		File file = new File(fileName);
		
		try {
		//readfile
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		
		if(tbl_product.getRowCount()==0) {
			JOptionPane.showMessageDialog(null, "Cart is Empty, Please select the product.");
		}
		else {
			paymentMethod();
		}
		
		}catch(Exception  e1) {
			e1.printStackTrace();
		}
		
	}
	
	//open BuyerHomePage
	public void homepage() throws IOException {
		BuyerHomePage n = new BuyerHomePage();
		n.setVisible(true);
		dispose();
	}
	
	//calculate Total Price
	public void TotalPrice()  {
		String fileName = "Cart.txt";
		File file = new File(fileName);
		
		try {
		//readfile
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		
		double total = 0;
		double grandtotal = 0;
		
		for(int i=0; i<tbl_product.getRowCount();i++) {
			int quantity = Integer.valueOf(tbl_product.getValueAt(i, 3).toString());
			double price = Double.parseDouble(tbl_product.getValueAt(i, 2).toString());
			
			total = price*quantity;
			grandtotal += total ;
			
			
		}
			System.out.println(grandtotal);
			txt_total.setText(Double.toString(grandtotal));
			//lbl_total.setText(Double.toString(grandtotal));
		
		}catch(Exception  e1) {
		e1.printStackTrace();
	}
	}
	
	public void refreshFrame() throws IOException
	{
		ProductinCart main = new ProductinCart();    
	    main.setVisible(true);
	    this.dispose();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Check Out")) {
			checkout();
		
		}
	
}
}
