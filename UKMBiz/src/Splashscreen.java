import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Splashscreen extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splashscreen frame = new Splashscreen();
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
	public Splashscreen() {
		setTitle("Splashscreen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuyer = new JButton("Buyer");
		btnBuyer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuyer.setBounds(158, 140, 232, 29);
		contentPane.add(btnBuyer);
		
		JButton btnSeller = new JButton("Seller");
		btnSeller.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSeller.setBounds(158, 190, 232, 29);
		contentPane.add(btnSeller);
		
		JLabel lblNewLabel = new JLabel("Are you a Buyer or Seller? Choose One.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(126, 90, 323, 29);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 59, 272, 296);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 255));
		panel_2.setBounds(273, 59, 272, 296);
		contentPane.add(panel_2);
		
		btnSeller.addActionListener(this);
		btnBuyer.addActionListener(this);
	}
	
	public void showLoginSeller() {
		LoginSeller s = new LoginSeller();
		s.setVisible(true);
		dispose();
	}
	
	public void showLoginBuyer() {
		LoginBuyer b = new LoginBuyer();
		b.setVisible(true);
		dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getActionCommand().equals("Seller"))
		{
			showLoginSeller();
		}
		else if (e.getActionCommand().equals("Buyer"))
		{
			showLoginBuyer();
		}
		else {
			JOptionPane.showMessageDialog(null, "Choose one");
		}
			
		
	
	}

}
