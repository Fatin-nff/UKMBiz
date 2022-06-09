import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ProductDetails extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt_productid;
	private JTextField txt_name;
	private JTextField txt_category;
	private JTextField txt_colour;
	private JTextField txt_price;
	private JTextField txt_stock;
	private JTextField txt_description;
	private JButton btn_AddToCart;
	private JButton btn_Back;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductDetails frame = new ProductDetails();
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
	public ProductDetails() {
		setTitle("UKMBiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 497);
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
		
		JLabel lbl_title = new JLabel("Product Information");
		lbl_title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lbl_title.setBounds(196, 0, 360, 51);
		panel_4.add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pictures/ukmbiz logo3.jpg"));
		lblNewLabel.setBounds(0, 0, 172, 51);
		panel_4.add(lblNewLabel);
		
		JLabel lbl_ProductId = new JLabel("Product ID :");
		lbl_ProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ProductId.setBounds(39, 89, 84, 22);
		contentPane.add(lbl_ProductId);
		
		txt_productid = new JTextField();
		txt_productid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_productid.setColumns(10);
		txt_productid.setBounds(127, 88, 303, 25);
		contentPane.add(txt_productid);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_name.setColumns(10);
		txt_name.setBounds(127, 125, 303, 25);
		contentPane.add(txt_name);
		
		JLabel lbl_Name = new JLabel("Name :");
		lbl_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Name.setBounds(39, 126, 74, 22);
		contentPane.add(lbl_Name);
		
		JLabel lbl_Category = new JLabel("Category :");
		lbl_Category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Category.setBounds(39, 233, 84, 22);
		contentPane.add(lbl_Category);
		
		txt_category = new JTextField();
		txt_category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_category.setColumns(10);
		txt_category.setBounds(127, 232, 303, 26);
		contentPane.add(txt_category);
		
		txt_colour = new JTextField();
		txt_colour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_colour.setColumns(10);
		txt_colour.setBounds(127, 196, 303, 26);
		contentPane.add(txt_colour);
		
		JLabel lbl_Colour = new JLabel("Colour :");
		lbl_Colour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Colour.setBounds(39, 197, 74, 22);
		contentPane.add(lbl_Colour);
		
		JLabel lbl_Price = new JLabel("Price :");
		lbl_Price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Price.setBounds(39, 161, 58, 22);
		contentPane.add(lbl_Price);
		
		txt_price = new JTextField();
		txt_price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_price.setColumns(10);
		txt_price.setBounds(127, 160, 303, 26);
		contentPane.add(txt_price);
		
		txt_stock = new JTextField();
		txt_stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_stock.setColumns(10);
		txt_stock.setBounds(127, 270, 303, 26);
		contentPane.add(txt_stock);
		
		JLabel lbl_Stock = new JLabel("Stock :");
		lbl_Stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Stock.setBounds(39, 265, 74, 36);
		contentPane.add(lbl_Stock);
		
		JLabel lbl_Description = new JLabel("Description :");
		lbl_Description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Description.setBounds(39, 306, 84, 22);
		contentPane.add(lbl_Description);
		
		txt_description = new JTextField();
		txt_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_description.setColumns(10);
		txt_description.setBounds(127, 308, 303, 83);
		contentPane.add(txt_description);
		
		JPanel panel = new JPanel();
		panel.setBounds(591, 113, 181, 215);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_pic = new JLabel("Product Picture");
		lbl_pic.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pic.setBounds(0, 0, 181, 215);
		panel.add(lbl_pic);
		lbl_pic.setBackground(Color.LIGHT_GRAY);
		
		btn_AddToCart = new JButton("Add To Cart");
		btn_AddToCart.setForeground(Color.WHITE);
		btn_AddToCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_AddToCart.setBackground(Color.RED);
		btn_AddToCart.setBounds(541, 385, 160, 36);
		contentPane.add(btn_AddToCart);
		
		btn_Back = new JButton("Back");
		btn_Back.setForeground(Color.WHITE);
		btn_Back.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Back.setBackground(Color.RED);
		btn_Back.setBounds(722, 385, 107, 36);
		contentPane.add(btn_Back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(0, 51, 473, 409);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Quantity = new JLabel("Quantity :");
		lbl_Quantity.setBounds(41, 350, 77, 17);
		lbl_Quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lbl_Quantity);
		
		JSpinner spinner_quantity = new JSpinner();
		spinner_quantity.setBounds(128, 346, 62, 29);
		panel_1.add(spinner_quantity);
		
		btn_AddToCart.addActionListener(this);
		btn_Back.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
