import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterProduct extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_SellerID;
	private JTextField txt_SellerName;
	private JTextField txtName;
	private JTextField txt_colour;
	private JTextField txt_description;
	private JTextField textField_8;
	private JTextField txt_stock;
	private JTextField txtProductID;
	private JComboBox cmb_category;
	DefaultTableModel model;
	
	private final JFileChooser openFileChooser;
	private final JFileChooser saveFileChooser;
	private BufferedImage originalBI;
	private BufferedImage newBI;
	private int [][] pixels;
	private JTextField txt_price;
	private JButton btnBrowse;
	private JButton btnRegProduct;
	private JButton btnUpdateProduct;
	private JButton btnRegisterProduct;
	private JButton btnViewProduct;
	
	ArrayList<Product> productRegList = new ArrayList<Product>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterProduct frame = new RegisterProduct();
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

	public RegisterProduct() throws IOException {
		ReadFile();
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File(""));
		openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png", "jpeg"));
		
		saveFileChooser = new JFileChooser();
		saveFileChooser.setCurrentDirectory(new File("C:\\Users\\User\\Documents\\A.OOSE\\UKMBizLATESTTTT\\UKMBizNew\\products"));
		saveFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png", "jpeg"));
		
		setTitle("UKMBiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 580);
		contentPane = new JPanel();
		contentPane.setLocation(-615, -209);
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
		lblNewLabel_1.setBounds(218, 0, 244, 51);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("pictures/ukmbizlogo2.jpg"));
		lblNewLabel.setBounds(0, 0, 208, 51);
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
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setBounds(783, 10, 85, 31);
		panel_1_1.add(btnLogOut);
		
		JLabel lblSellerId = new JLabel("Seller ID :");
		lblSellerId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSellerId.setBounds(10, 113, 84, 22);
		contentPane.add(lblSellerId);
		
		txt_SellerID = new JTextField();
		txt_SellerID.setColumns(10);
		txt_SellerID.setBounds(89, 113, 96, 24);
		contentPane.add(txt_SellerID);
		
		JLabel lblSellerName = new JLabel("Seller Name :");
		lblSellerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSellerName.setBounds(195, 113, 113, 22);
		contentPane.add(lblSellerName);
		
		txt_SellerName = new JTextField();
		txt_SellerName.setColumns(10);
		txt_SellerName.setBounds(302, 113, 189, 22);
		contentPane.add(txt_SellerName);
		
		JLabel lblTitle = new JLabel("Register Product");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(new Font("Siro-Bold", Font.BOLD, 28));
		lblTitle.setBounds(341, 142, 247, 45);
		contentPane.add(lblTitle);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(47, 234, 74, 22);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(133, 234, 303, 25);
		contentPane.add(txtName);
		
		JLabel lblCategory = new JLabel("Price:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategory.setBounds(47, 275, 84, 22);
		contentPane.add(lblCategory);
		
		JLabel lblVariation = new JLabel("Colour:");
		lblVariation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariation.setBounds(47, 318, 74, 22);
		contentPane.add(lblVariation);
		
		txt_colour = new JTextField();
		txt_colour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_colour.setColumns(10);
		txt_colour.setBounds(133, 318, 303, 26);
		contentPane.add(txt_colour);
		
		JLabel lblPrice = new JLabel("Category:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(47, 359, 74, 22);
		contentPane.add(lblPrice);
		
		JLabel lblStock = new JLabel("Stock :");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(47, 394, 74, 36);
		contentPane.add(lblStock);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(47, 440, 99, 22);
		contentPane.add(lblDescription);
		
		txt_description = new JTextField();
		txt_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_description.setColumns(10);
		txt_description.setBounds(133, 443, 303, 60);
		contentPane.add(txt_description);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(561, 381, 160, 31);
		contentPane.add(textField_8);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBrowse.setForeground(Color.WHITE);
		btnBrowse.setBackground(Color.RED);
		btnBrowse.setBounds(741, 380, 92, 30);
		contentPane.add(btnBrowse);
		
		btnRegProduct = new JButton("Register Product");
		btnRegProduct.setForeground(Color.WHITE);
		btnRegProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegProduct.setBackground(Color.RED);
		btnRegProduct.setBounds(594, 467, 219, 36);
		contentPane.add(btnRegProduct);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(615, 197, 160, 170);
		contentPane.add(panel_3);
		
		JLabel lbl_image = new JLabel("");
		lbl_image.setIcon(null);
		lbl_image.setBackground(Color.GRAY);
		lbl_image.setBounds(0, -35, 160, 179);
		panel_3.add(lbl_image);
		
		txt_stock = new JTextField();
		txt_stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_stock.setColumns(10);
		txt_stock.setBounds(133, 400, 303, 26);
		contentPane.add(txt_stock);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductId.setBounds(47, 197, 84, 22);
		contentPane.add(lblProductId);
		
		txtProductID = new JTextField();
		txtProductID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProductID.setColumns(10);
		txtProductID.setBounds(133, 197, 303, 25);
		contentPane.add(txtProductID);
		model = new DefaultTableModel();
		
		JButton btnNewButton = new JButton("Save Image");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//convert the original image to Array
				imageToArray();
			//make a filtered image
				makeFilteredImage();
			//save the image
				saveImage();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(594, 421, 219, 36);
		contentPane.add(btnNewButton);
		
		String type[] = {"Blouse", "Shoes", "Handbag"};
		cmb_category = new JComboBox(type);
		cmb_category.setSelectedIndex(0);
		cmb_category.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cmb_category.setBounds(133, 359, 303, 24);
		contentPane.add(cmb_category);
		
		txt_price = new JTextField();
		txt_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_price.setColumns(10);
		txt_price.setBounds(133, 279, 303, 25);
		contentPane.add(txt_price);
		
		btnRegProduct.addActionListener(this);
		btnUpdateProduct.addActionListener(this);
		btnBrowse.addActionListener(this);
		btnViewProduct.addActionListener(this);
		btnRegisterProduct.addActionListener(this);
		
	}

	//Read Values from File
//	public void ReadFile() throws IOException
//	{
//		
//		FileReader file = new FileReader("RegisteredProduct.txt");
//		BufferedReader br = new BufferedReader(file);
//		
//		if (br.readLine() == null) {
//		    System.out.println("No errors, and file empty");
//		}
//		else{
//			 try (BufferedReader in = new BufferedReader(file)) {
//					String input = "";
//					//studentList = null;
//					while((input = in.readLine())!= null)
//					{
//						StringTokenizer word = new StringTokenizer(input,";");
//						
//						String productID = word.nextToken();
//						String name = word.nextToken();
//						double price = Double.parseDouble(word.nextToken());
//						String colour = word.nextToken();
//						String category = word.nextToken();
//						int stock = Integer.parseInt(word.nextToken());
//						String description = word.nextToken();
//						
//			   			
//						Product v =null;
//						
//						String categoryType = "";
//						
//						if(categoryType.equals("Blouse")) //Bus
//						{
//							v = new Blouse(name, productID, price, colour, category, stock, description);
//						}
//						else if(categoryType.equals("Shoes"))//Car
//						{
//							v = new Shoes(name, productID, price, colour, category, stock, description);
//						}
//						else if(categoryType.equals("Handbag"))//Motorcycle
//						{
//							v = new Handbag(name, productID, price, colour, category, stock, description);
//						}
//
//
//						Product pr = new Product(name, productID, price, colour, category, stock, description);
//						
//						productRegList.add(pr);
//						
//					}
//				}
//		}
//		
//       
//	}
	
	public void ReadFile() throws IOException {
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
				
				productRegList.add(pr);
		
			}
		}
		
		for(int i=0; i<productRegList.size(); i++) {
			Product s = (Product)productRegList.get(i);
			System.out.println(s.getProductID()+ s.getName()+ s.getPrice()+ s.getColour()+ s.getCategory()+ s.getStock()+ s.getDescription());
		}
	}
	
	public void writeListToFile() {
		try {
			
			FileWriter file = new FileWriter("RegisteredProduct.txt");
			PrintWriter out = new PrintWriter(file);
			
			for(int i=0; i<productRegList.size(); i++) 
			{
				Product s = productRegList.get(i);
				
				//System.out.println(s.getColour());
				
				out.print(s.getProductID()+";"+s.getName()+";"+s.getPrice()+";"+s.getColour()+";");
				
				if(s.getCategory().equals("Blouse"))
                {
                	out.print("Blouse"+";");
                }
                else if(s.getCategory().equals("Shoes"))
                {
                	out.print("Shoes"+";");
                }
                else if(s.getCategory().equals("Handbag"))
                {
                	out.print("Handbag"+";");
                }
				out.print(s.getStock()+";"+s.getDescription()+";");
				out.println();
			}
			JOptionPane.showMessageDialog(null,"List Updated.");
            out.close();
		}
        catch(IOException ex){System.out.println("There's no such file!");}
	}
	
	private void saveImage() {
	int returnValue = saveFileChooser.showSaveDialog(this);
	
	if (returnValue == JFileChooser.APPROVE_OPTION) {
		try {
			ImageIO.write(newBI, "png",saveFileChooser.getSelectedFile());
			JOptionPane.showMessageDialog(null, "Image File Saved!");
		}catch (IOException e2) {
			JOptionPane.showMessageDialog(null, "Fail to save Image File");
		}
	}
	else {
		JOptionPane.showMessageDialog(null, "No File Choosen");
	}
	
	//JFileChooser chooser = new JFileChooser();
	//FileNameExtensionFilter filter = new FileNameExtensionFilter(
	//        "JPG, GIF, and PNG Images", "jpg", "gif", "png");
	//chooser.setFileFilter(filter);
	//int returnVal = chooser.showOpenDialog(this);
	//if (returnVal == JFileChooser.APPROVE_OPTION) {
	//    File file = chooser.getSelectedFile();
	//    System.out.println("You chose to open this file: "
	//            + file.getName());
	//    BufferedImage image;
	//    try {
	//        image = ImageIO.read(file);
	//        ImageIO.write(image, "jpg",new File("C:\\path\\to\\destination\\" + file.getName()));
	//    } catch (IOException ex) {
	//        Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
	//    }              
	//}
	
	//JFileChooser fileChooser = new JFileChooser();
	//fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
	//if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	//    File file = fileChooser.getSelectedFile();
	//    try {
	//        ImageIO.write((BufferedImage) newBI, "png", new File(file.getAbsolutePath()));
	//    } catch (IOException ex) {
	//        System.out.println("Failed to save image!");
	//    }
	//} else {
	//    System.out.println("No file choosen!");
	//}
	//}
	}
	
	private void chooseImage() {
	int returnValue = openFileChooser.showOpenDialog(this);
	
	if (returnValue == JFileChooser.APPROVE_OPTION) {
		try {
			originalBI = ImageIO.read(openFileChooser.getSelectedFile());
			JOptionPane.showMessageDialog(null, "Image File Load Successfully");
		}catch (IOException e2) {
			JOptionPane.showMessageDialog(null, "Fail to load image");
		}
	}
	else {
		JOptionPane.showMessageDialog(null, "No File Choosen");
	}
	}
	
	private void imageToArray() {
	int width = originalBI.getWidth();
	int height = originalBI.getHeight();
	
	newBI = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	
	pixels = new int[width][height];
	for(int a=0; a<width; a++) {
		for(int b=0; b<height; b++) {
			pixels[a][b] = originalBI.getRGB(a, b);
		}
	}
	}
	
	private void makeFilteredImage() {
	
	}

	
	public void updateProductForm() throws IOException {		
		UpdateProduct up = new UpdateProduct();
		up.setVisible(true);
		dispose();
	}

	public void viewProduct() {		
		ViewProduct view = new ViewProduct();
		view.setVisible(true);
		dispose();
	}
	
		//Refresh current JFrame 
		public void refreshFrame() throws IOException
		{
			RegisterProduct main = new RegisterProduct();    
			main.setVisible(true);
			this.setVisible(false);
				
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Register Product")) {
		
			if(txtProductID.getText().equals("")|| txtName.getText().equals("")||txt_price.getText().equals("")||txt_colour.getText().equals("")||txt_stock.getText().equals("")||txt_description.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Form is not complete.");
			}
			
			else {
				
				String new_id  = txtProductID.getText();
				boolean found = false;
				
				for(int i=0; i<productRegList.size(); i++)
				{
				    Product p = (Product)productRegList.get(i);
	
				    if(p.getProductID().equals(new_id))
				    {
				        found=true;
				        break;
				   }
				
				}
	
				if (found == true)
				{
				    JOptionPane.showMessageDialog(null,"Hey, already ID exist lah!");
				}
			
			else{
				
				int category = cmb_category.getSelectedIndex();

				String productID = txtProductID.getText();
				String name = txtName.getText();
				double price = Double.parseDouble(txt_price.getText());
				String colour = txt_colour.getText();
				int stock = Integer.parseInt(txt_stock.getText());
				String description = txt_description.getText();
				
				String p = null;

				if(category == 0) {
					p = "Blouse";
				}
				else if(category == 1) {
					p = "Shoes";
				}
				else if(category == 2) {
					p = "Handbag";
				}
				
				
//				if(txtProductID.equals("")|| txtName.equals("")||txt_price.equals("")||txt_colour.equals("")||txt_stock.equals("")||txt_description.equals("")) {
//					JOptionPane.showMessageDialog(null,"Form is not complete.");
//				}
				
				
				Product pr = new Product(productID,name,price,colour,p,stock,description);
				
				productRegList.add(pr);
				
				for(int i=0; i<productRegList.size(); i++) {
					Product s = (Product)productRegList.get(i);
					System.out.println(s.getProductID()+ s.getName()+ s.getPrice()+ s.getColour()+ s.getCategory()+ s.getStock()+ s.getDescription());
				}
			
				writeListToFile();
			
				try {
					refreshFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		}
		

//			else {
//			
//			Product pr = new Product(productID,name,price,colour,p,stock,description);
//			
//			productRegList.add(pr);
//			for(int i=0; i<productRegList.size(); i++) {
//				Product s = (Product)productRegList.get(i);
//				System.out.println(s.getProductID()+ s.getName()+ s.getPrice()+ s.getColour()+ s.getCategory()+ s.getStock()+ s.getDescription());
//			}
//			
//			writeListToFile();
//			
//			try {
//				refreshFrame();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}	
		
	
		else if(e.getActionCommand().equals("Browse")) {
			chooseImage();
		}
		
		else if(e.getActionCommand().equals("Save Image")) {
			saveImage();
		}
		
		else if(e.getActionCommand().equals("Update Product")) {
			try {
				updateProductForm();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(e.getActionCommand().equals("View Product")) {
			viewProduct();
		}
	}
}
