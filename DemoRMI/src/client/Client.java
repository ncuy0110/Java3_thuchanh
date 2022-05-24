package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmi.Interf;

public class Client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Interf intf;
	private String username;
	private String password;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
					Registry registry = LocateRegistry.getRegistry("localhost", 2021); 
					frame.intf = (Interf) registry.lookup(Interf.class.getSimpleName());
					frame.changeLayout(new Login(frame));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void changeLayout(JPanel panel) {
		Client.this.getContentPane().removeAll();
		Client.this.getContentPane().add(panel);
		Client.this.revalidate();
		Client.this.repaint();
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
