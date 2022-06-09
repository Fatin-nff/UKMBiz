import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
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
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class BuyerHomePage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_search;
	private JList lst_product;
	private JTextField txt_stock;
	private JTextField txt_colour;
	private JTextField txt_price;
	private JTextField txt_name;
	private JTextField txt_productID;
	private JTextField txt_category;
	private JTextField txt_quantity;
	private JTextPane txt_description;
	private JLabel lbl_images;
	private JButton btn_cart;
	private JButton btn_addtocart;

	
	ArrayList<Product> productList = new ArrayList<Product>();
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	
//	int ImageIndex = 0;
//	String ImageName = "";
//	private String classes[] = {"B01.jpg", "B02.jpg", "B03.jpg", "B04.jpg", "B05.jpg", "S01.jpg", "S02.jpg", "S03.jpg", "S04.jpg", "S05.jpg", "H01.jpg", "H02.jpg", "H03.jpg", "H04.jpg", "H05.jpg"};
//	private ImageIcon graphics[] = {new ImageIcon(classes[0]),new ImageIcon(classes[1]),new ImageIcon(classes[2]),new ImageIcon(classes[3]),new ImageIcon(classes[4]),new ImageIcon(classes[5]),new ImageIcon(classes[6]),new ImageIcon(classes[7]),new ImageIcon(classes[8]),new ImageIcon(classes[9])};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerHomePage frame = new BuyerHomePage();
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
	public BuyerHomePage() throws IOException {
		ReadProductFile();
		readCartFile();
		initialize();
	}
	public void initialize() {
		setTitle("UKMBiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 576);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 890, 51);
		panel_4.setLayout(null);
		panel_4.setBackground(Color.RED);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(174, 0, 244, 51);
		panel_4.add(lblNewLabel_1);
		
		JButton btn_LogOut = new JButton("Log Out");
		btn_LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();					
			}
		});
		btn_LogOut.setBounds(779, 10, 85, 31);
		panel_4.add(btn_LogOut);
		btn_LogOut.setForeground(Color.BLACK);
		btn_LogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_LogOut.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("pictures/ukmbiz logo3.jpg"));
		lblNewLabel_2.setBounds(0, 0, 164, 51);
		panel_4.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 50, 890, 51);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBackground(Color.PINK);
		contentPane.add(panel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.RED);
		separator.setBackground(Color.RED);
		separator.setBounds(176, 10, 9, 31);
		panel_1_1.add(separator);
		
		JButton btn_AllProduct = new JButton("All Products");
		btn_AllProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_AllProduct.setBorderPainted(false);
		btn_AllProduct.setBackground(Color.PINK);
		btn_AllProduct.setBounds(7, 5, 160, 41);
		panel_1_1.add(btn_AllProduct);
		
		txt_search = new JTextField();
		txt_search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_search.setBounds(230, 18, 135, 19);
		panel_1_1.add(txt_search);
		txt_search.setColumns(10);
		
		JLabel lbl_search = new JLabel("");
		lbl_search.setIcon(new ImageIcon("pictures/searchicon.png"));
		lbl_search.setBounds(195, 10, 30, 31);
		panel_1_1.add(lbl_search);
		
		JButton btn_search = new JButton("Search");
//		btn_search.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				SearchProduct search = new SearchProduct();
//				search.setVisible(true);
//			}
//		});
		
		btn_search.setForeground(Color.WHITE);
		btn_search.setBackground(Color.RED);
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_search.setBounds(375, 17, 74, 21);
		panel_1_1.add(btn_search);
		
		btn_cart = new JButton("Cart");
//		btn_cart.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				ProductinCart cart = new ProductinCart();
//				cart.setVisible(true);
//			}
//		});
		btn_cart.setBackground(Color.RED);
		btn_cart.setForeground(Color.WHITE);
		btn_cart.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btn_cart.setIcon(new ImageIcon("pictures/cartIcon.png"));
		btn_cart.setBounds(716, 10, 135, 31);
		panel_1_1.add(btn_cart);
		
		lst_product = new JList();
		lst_product.setBackground(new Color(255, 228, 225));
		lst_product.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lst_product.setBounds(31, 152, 205, 300);
		
		if(lst_product.getModel().getSize() == 0) {
			
			DefaultListModel ArrList = new DefaultListModel();
			for(int i=0; i<productList.size(); i++) {
			
			ArrList.addElement((i+1)+ ". "+ productList.get(i).getName());
		};
			lst_product.setModel(ArrList);
		}
		
		lst_product.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				int selectedIndex = lst_product.getSelectedIndex();
				setTextFieldValues(selectedIndex);
				
//				lbl_images.setText(null); //set the label to null ready for the image to be displayed
//				lbl_images.setIcon(graphics[selectedIndex]); //display the selected image
				
			}
		});
		contentPane.add(lst_product);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(272, 92, 618, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lbl_productID = new JLabel("Product ID :");
		lbl_productID.setBounds(10, 36, 84, 22);
		panel.add(lbl_productID);
		lbl_productID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_productID = new JTextField();
		txt_productID.setEditable(false);
		txt_productID.setBounds(96, 36, 303, 25);
		panel.add(txt_productID);
		txt_productID.setBackground(Color.WHITE);
		txt_productID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_productID.setColumns(10);
		
		JLabel lbl_name = new JLabel("Name :");
		lbl_name.setBounds(10, 73, 74, 22);
		panel.add(lbl_name);
		lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_name = new JTextField();
		txt_name.setEditable(false);
		txt_name.setBounds(96, 73, 303, 25);
		panel.add(txt_name);
		txt_name.setBackground(Color.WHITE);
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_name.setColumns(10);
		
		JLabel lbl_price = new JLabel("Price (RM):");
		lbl_price.setBounds(10, 114, 84, 22);
		panel.add(lbl_price);
		lbl_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_price = new JTextField();
		txt_price.setEditable(false);
		txt_price.setBounds(96, 118, 303, 25);
		panel.add(txt_price);
		txt_price.setBackground(Color.WHITE);
		txt_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_price.setColumns(10);
		
		JLabel lbl_colour = new JLabel("Colour:");
		lbl_colour.setBounds(10, 157, 74, 22);
		panel.add(lbl_colour);
		lbl_colour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_colour = new JTextField();
		txt_colour.setEditable(false);
		txt_colour.setBounds(96, 157, 303, 26);
		panel.add(txt_colour);
		txt_colour.setBackground(Color.WHITE);
		txt_colour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_colour.setColumns(10);
		
		JLabel lbl_category = new JLabel("Category:");
		lbl_category.setBounds(10, 198, 74, 22);
		panel.add(lbl_category);
		lbl_category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_category = new JTextField();
		txt_category.setEditable(false);
		txt_category.setBounds(96, 197, 303, 26);
		panel.add(txt_category);
		txt_category.setBackground(Color.WHITE);
		txt_category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_category.setColumns(10);
		
		JLabel lbl_stock = new JLabel("Stock :");
		lbl_stock.setBounds(10, 233, 74, 36);
		panel.add(lbl_stock);
		lbl_stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_stock = new JTextField();
		txt_stock.setEditable(false);
		txt_stock.setBounds(96, 239, 303, 26);
		panel.add(txt_stock);
		txt_stock.setBackground(Color.WHITE);
		txt_stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_stock.setColumns(10);
		
		JLabel lbl_description = new JLabel("Description :");
		lbl_description.setBounds(10, 279, 99, 22);
		panel.add(lbl_description);
		lbl_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_quantity = new JLabel("Quantity :");
		lbl_quantity.setBounds(10, 389, 74, 22);
		panel.add(lbl_quantity);
		lbl_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_quantity = new JTextField();
		txt_quantity.setBounds(96, 385, 155, 31);
		panel.add(txt_quantity);
		txt_quantity.setBackground(Color.WHITE);
		txt_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_quantity.setColumns(10);
		
		btn_addtocart = new JButton("Add To Cart");
		btn_addtocart.setBounds(418, 385, 155, 31);
		panel.add(btn_addtocart);
		btn_addtocart.setForeground(Color.WHITE);
		btn_addtocart.setBackground(Color.RED);
		btn_addtocart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lbl_images = new JLabel("");
		lbl_images.setIcon(new ImageIcon("pictures/default.jpg"));
		lbl_images.setBackground(SystemColor.control);
		lbl_images.setBounds(430, 82, 155, 155);
		panel.add(lbl_images);
		
		txt_description = new JTextPane();
		txt_description.setEditable(false);
		txt_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_description.setBounds(96, 281, 303, 93);
		panel.add(txt_description);
		
		JLabel lblNewLabel = new JLabel("Select to view the Product Details :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 128, 237, 13);
		contentPane.add(lblNewLabel);
		
		btn_addtocart.addActionListener(this);
		btn_cart.addActionListener(this);
	}
	
	public void ReadProductFile() throws IOException {
		FileReader file = new FileReader("Product.txt");
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
				
				productList.add(pr);
				
				
			}
		}
	}
	
	public void setTextFieldValues(int selectedIndex) {
		Product item = (Product)productList.get(selectedIndex);
		
		txt_productID.setText(item.getProductID());
		txt_name.setText(item.getName());
		txt_price.setText(String.valueOf(item.getPrice()));
		txt_colour.setText(item.getColour());
		txt_category.setText(item.getCategory());
		txt_stock.setText(String.valueOf(item.getStock()));
		txt_description.setText(item.getDescription());
		
		//set images icon
		lbl_images.setText(null); //set the label to null ready for the image to be displayed
		lbl_images.setIcon(new ImageIcon("pictures/"+item.getProductID()+".jpg")); //display the selected images
		}
	
//	public void searchProduct() {
//		for(int i=0; i<productList.size(); i++) {
//		Product pr = productList.get(i);
//		if(txt_search.getText().equals("Blouse")) {
//			pr.getCategory()
//		}
//	}
//}
	
	public void goToCart() throws IOException {
		ProductinCart cart = new ProductinCart();
		cart.setVisible(true);
		this.dispose();
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
			JOptionPane.showMessageDialog(null,"Add To Cart Successfully!");
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
	
	public void refreshFrame() throws IOException{
		BuyerHomePage fresh = new BuyerHomePage();
		fresh.setVisible(true);
		this.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int index = lst_product.getSelectedIndex();
		
		if(e.getActionCommand().equals("Add To Cart")) {

			String productID = txt_productID.getText();
			String name = txt_name.getText();
			double price = Double.parseDouble(txt_price.getText());
			String colour = txt_colour.getText();
			String category = txt_category.getText();
			int stock = Integer.parseInt(txt_stock.getText());
			String description = txt_description.getText();
			int quantity = Integer.parseInt(txt_quantity.getText());
			
			Product pr = new Product(productID,name,price,colour,category,stock,description);
			Cart cr = new Cart (quantity, pr);
			
			cartList.add(cr);
			writeCartListToFile();
			try {
				refreshFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
		else if(e.getActionCommand().equals("Search")) {
			
		}
		else if(e.getActionCommand().equals("Cart")) {
			try {
				goToCart();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
