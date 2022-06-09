import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginSeller extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	JButton btn_Login;
	JButton btnCreateAnAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSeller frame = new LoginSeller();
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
	public LoginSeller() {
		
		String Username, Password;
		int ln;
		setTitle("UKMBiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		panel.setBounds(362, 0, 383, 458);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("pictures/ukm2.jpg"));
		lblNewLabel_2.setBounds(0, 28, 99, 59);
		panel.add(lblNewLabel_2);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblRegister.setBounds(107, 156, 161, 40);
		panel.add(lblRegister);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account? Register Now!");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(67, 195, 256, 22);
		panel.add(lblNewLabel_3);
		
		btnCreateAnAccount = new JButton("Create an Account");
		btnCreateAnAccount.setForeground(Color.RED);
		btnCreateAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateAnAccount.setBackground(Color.WHITE);
		btnCreateAnAccount.setBounds(77, 227, 223, 40);
		panel.add(btnCreateAnAccount);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("pictures/ukmbizlogo2.jpg"));
		lblNewLabel_1.setBounds(260, 11, 210, 85);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(120, 103, 110, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Username");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(57, 170, 96, 13);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(57, 187, 242, 32);
		contentPane.add(txtEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(57, 242, 78, 13);
		contentPane.add(lblPassword);
		
		JCheckBox showPassword = new JCheckBox("Show Password");
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(showPassword.isSelected()) {
					txtPass.setEchoChar((char)0);
				}
				else {
					txtPass.setEchoChar('*');
				}
			}
		});
		showPassword.setForeground(Color.GRAY);
		showPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		showPassword.setBackground(Color.WHITE);
		showPassword.setBounds(57, 300, 136, 21);
		contentPane.add(showPassword);
		
		btn_Login = new JButton("Log In");
		btn_Login.setForeground(Color.WHITE);
		btn_Login.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_Login.setBackground(Color.RED);
		btn_Login.setBounds(120, 360, 110, 40);
		contentPane.add(btn_Login);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(57, 265, 242, 32);
		contentPane.add(txtPass);
		
		btn_Login.addActionListener(this);
		btnCreateAnAccount.addActionListener(this);
	}

	public void submitLogIn() {
		String username = txtEmail.getText(); 
		String password = txtPass.getPassword().toString(); 
		if(username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username/Password cannot empty", "Error",JOptionPane.ERROR_MESSAGE);
		}
		else {
			String user,pass,aUser,aPass;
			
			boolean found = false;
			aUser = txtEmail.getText();
			aPass = txtPass.getText();
			
			try {
				FileReader reader = new FileReader("SellerList.txt");
				
				Scanner a = new Scanner(reader);
				
				while(a.hasNextLine()) {
					String line = a.nextLine();
					StringTokenizer st = new StringTokenizer(line, ";");
					
					user = st.nextToken();
					pass = st.nextToken();
					
					if(user.equals(aUser) && pass.equals(aPass)) {
						found = true;
						break;
					}
				}
				if(found) {
					JOptionPane.showMessageDialog(null, "Access Granted! Welcome to UKMBiz! " + aUser," Login Valid",JOptionPane.INFORMATION_MESSAGE);
					showRegisterProduct();
					
				}
				else
					JOptionPane.showMessageDialog(null, "Access Denied! Username/Password does not match. Please register an account first if you are a new user", "Login Invalid",JOptionPane.ERROR_MESSAGE);
				
				reader.close();
			}catch(Exception e1) {
				System.out.print(e1.toString());
			}
		}
	}
	
	public void regSeller() throws IOException {
		RegisterSeller s = new RegisterSeller();
		s.setVisible(true);
		dispose();
	}
	
	public void showRegisterProduct() throws IOException {
		RegisterProduct s = new RegisterProduct();
		s.setVisible(true);
		dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Log In"))
		{
			submitLogIn();							
		}
		else if (e.getActionCommand().equals("Create an Account")) {
			try {
				regSeller();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		

	}
}
