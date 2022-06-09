import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class RegisterSeller extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtMobile;
	private JPasswordField txtPass;
	private JButton btnSignUp;
	private JButton btnBacktoLogin;
	private JTextField txt_SellerID;
	
	ArrayList<Seller> sellerList = new ArrayList<Seller> ();
	ArrayList<User> userList = new ArrayList<User>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSeller frame = new RegisterSeller();
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
	public RegisterSeller() throws IOException {
		initialize();
		randomnumbers();
	}
	public void initialize() {
		//randomnumbers();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 351, 508);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("pictures/ukmbizlogo2.jpg"));
		lblNewLabel_1.setBounds(58, 162, 208, 100);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("letak la motto kita hahah");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(82, 291, 170, 22);
		panel.add(lblNewLabel_2);
		
		btnBacktoLogin = new JButton("Already have an account? Login");
		btnBacktoLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnBacktoLogin.setForeground(Color.WHITE);
		btnBacktoLogin.setBackground(Color.RED);
		btnBacktoLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBacktoLogin.setBounds(0, 10, 227, 21);
		panel.add(btnBacktoLogin);
		
		txt_SellerID = new JTextField();
		txt_SellerID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_SellerID.setForeground(Color.WHITE);
		txt_SellerID.setBackground(Color.RED);
		txt_SellerID.setBounds(72, 444, 194, 39);
		panel.add(txt_SellerID);
		txt_SellerID.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Seller ID:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(127, 421, 100, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Registration Form");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_3.setBounds(481, 33, 258, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(424, 109, 64, 22);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(425, 132, 378, 41);
		contentPane.add(txtName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(424, 195, 64, 22);
		contentPane.add(lblPassword);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setForeground(Color.GRAY);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNumber.setBounds(425, 361, 115, 22);
		contentPane.add(lblMobileNumber);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(425, 381, 378, 41);
		contentPane.add(txtMobile);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignUp.setBackground(Color.RED);
		btnSignUp.setBounds(487, 445, 216, 41);
		contentPane.add(btnSignUp);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(425, 217, 378, 41);
		contentPane.add(txtPass);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(425, 288, 64, 22);
		contentPane.add(lblEmail);
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(425, 310, 378, 41);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JCheckBox showPassword = new JCheckBox("Show Password");
		showPassword.setBounds(424, 264, 150, 30);
		contentPane.add(showPassword);
		showPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		showPassword.setBackground(Color.WHITE);
		
		btnSignUp.addActionListener(this);
		btnBacktoLogin.addActionListener(this);
	}
	public void randomnumbers() {
		Random ran = new Random();
		int n = ran.nextInt(1000000)+1;
		String val = String.valueOf(n);
		txt_SellerID.setText(val);
	}
	public void ReadFile() throws IOException
	{
		
		FileReader file = new FileReader("SellerList2.txt");
        try (BufferedReader in = new BufferedReader(file)) {
			String input = "";
			//studentList = null;
			while((input = in.readLine())!= null)
			{
				StringTokenizer word = new StringTokenizer(input,";");
				
				String sellerID = word.nextToken();
				String name = word.nextToken();
				String email = word.nextToken();
				String password = word.nextToken();
				//int stock = Integer.parseInt(word.nextToken());
				String mobile = word.nextToken();
				
				User u = new User (name, email, password, mobile);
				Seller s = new Seller (sellerID, u);
				
				sellerList.add(s);
				
			}
		}
	}
	public void clearForm() throws IOException {
		dispose();
		RegisterSeller s = new RegisterSeller();
	}
	public void writeListToFile() {
		try {
			
			FileWriter file = new FileWriter("SellerList2.txt");
			PrintWriter out = new PrintWriter(file);
			
			for(int i=0; i<sellerList.size(); i++) 
			{
				Seller s = sellerList.get(i);
			
				out.print(s.getSellerID()+";"+s.getUser().getUsername()+";"+s.getUser().getPassword()+";"+s.getUser().getPhoneNumber()+";"+s.getUser().getEmail());
				out.println();
			}
			JOptionPane.showMessageDialog(null,"Registered Successfully!");
            out.close();
		}
        catch(IOException ex){System.out.println("There's no such file!");}
	}

			
	public void backLogin() {
				dispose();
				LoginSeller nw = new LoginSeller();
				nw.setVisible(true);
			}
	
	public void goToLoginSeller() {
		LoginSeller login = new LoginSeller();
		login.setVisible(true);
		login.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Sign Up"))
		{
			
			String name = txtName.getText();
			String email = txtEmail.getText();
			String password = txtPass.getText();
			String mobile = txtMobile.getText();
			String sellerID = txt_SellerID.getText();
			
			if(name.isEmpty() || email.isEmpty() || password.isEmpty() || mobile.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Data cannot empty", "Error",JOptionPane.ERROR_MESSAGE);
			}
			else {
				String new_id = txt_SellerID.getText();
				String new_user = txtName.getText();
				boolean found = false;
				
				for(int i=0; i<sellerList.size();i++) {
					Seller sell = (Seller)sellerList.get(i);
					User use =(User) userList.get(i);
					
					if(sell.getSellerID().equals(new_user) || use.getUsername().equals(new_user) ){
						found=true;
						break;
					}
				}
				if (found==true) {
					JOptionPane.showMessageDialog(null, "Username Already Exist");
					try {
						clearForm();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					User u = new User (name, email, password, mobile);
					Seller s = new Seller (sellerID, u);
					
					
					sellerList.add(s);
					try {
						ReadFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					writeListToFile();
					goToLoginSeller();
				}
			}

		}
		else if ((e.getActionCommand().equals("Already have an account? Login")))
		{
			backLogin();
			dispose();
		}
		
	}
	}

