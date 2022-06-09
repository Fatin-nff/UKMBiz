import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;

public class ViewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField txt_SellerName;
	private JTextField txt_SellerID;
	private JTable tbl_product;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduct frame = new ViewProduct();
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
	public ViewProduct() {
		setTitle("UKMBiz ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 562);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ViewProduct = new JLabel("View Product");
		lbl_ViewProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ViewProduct.setForeground(Color.RED);
		lbl_ViewProduct.setFont(new Font("Siro-Bold", Font.BOLD, 28));
		lbl_ViewProduct.setBounds(303, 154, 247, 40);
		contentPane.add(lbl_ViewProduct);
		
		txt_SellerName = new JTextField();
		txt_SellerName.setColumns(10);
		txt_SellerName.setBounds(302, 111, 189, 22);
		contentPane.add(txt_SellerName);
		
		JLabel lbl_SellerName = new JLabel("Seller Name :");
		lbl_SellerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_SellerName.setBounds(195, 111, 113, 22);
		contentPane.add(lbl_SellerName);
		
		txt_SellerID = new JTextField();
		txt_SellerID.setColumns(10);
		txt_SellerID.setBounds(89, 111, 96, 24);
		contentPane.add(txt_SellerID);
		
		JLabel lbl_SellerId = new JLabel("Seller ID :");
		lbl_SellerId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_SellerId.setBounds(10, 111, 84, 22);
		contentPane.add(lbl_SellerId);
		
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
		
		JButton btn_RegisterProduct = new JButton("Register Product");
		btn_RegisterProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterProduct nw = null;
				try {
					nw = new RegisterProduct();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.setVisible(true);
			}
		});
		btn_RegisterProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_RegisterProduct.setBorderPainted(false);
		btn_RegisterProduct.setBackground(Color.PINK);
		btn_RegisterProduct.setBounds(7, 5, 160, 41);
		panel_1_1.add(btn_RegisterProduct);
		
		JButton btn_UpdateProduct = new JButton("Update Product");
		btn_UpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateProduct nw = null;
				try {
					nw = new UpdateProduct();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nw.setVisible(true);
			}
		});
		btn_UpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_UpdateProduct.setBorderPainted(false);
		btn_UpdateProduct.setBackground(Color.PINK);
		btn_UpdateProduct.setBounds(186, 5, 154, 41);
		panel_1_1.add(btn_UpdateProduct);
		
		JButton btn_ViewProduct = new JButton("View Product");
		btn_ViewProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_ViewProduct.setBorderPainted(false);
		btn_ViewProduct.setBackground(Color.PINK);
		btn_ViewProduct.setBounds(355, 5, 154, 41);
		panel_1_1.add(btn_ViewProduct);
		
		JButton btn_LogOut = new JButton("Log Out");
		btn_LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_LogOut.setForeground(Color.WHITE);
		btn_LogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_LogOut.setBackground(Color.RED);
		btn_LogOut.setBounds(782, 10, 85, 31);
		panel_1_1.add(btn_LogOut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(0, 0, 890, 51);
		contentPane.add(panel_4);
		
		JLabel lbl_title = new JLabel("Seller Panel");
		lbl_title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lbl_title.setBounds(174, 0, 244, 51);
		panel_4.add(lbl_title);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("pictures/ukmbiz logo3.jpg"));
		lblNewLabel.setBounds(0, 0, 155, 51);
		panel_4.add(lblNewLabel);
		
		tbl_product = new JTable();
		tbl_product.setBackground(SystemColor.menu);
		tbl_product.setBounds(29, 192, 829, 301);
		contentPane.add(tbl_product);
	}
}