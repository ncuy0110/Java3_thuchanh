package client;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfUsername;
	private JPasswordField tfPassword;

	/**
	 * Create the panel.
	 */
	public Login(Client client) {
		
		JLabel lblNewLabel = new JLabel("Username");
		
		JLabel lbPw = new JLabel("Password");
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				String password= new String(tfPassword.getPassword());
				try {
					if(client.intf.login(username, password)) {
						JOptionPane.showMessageDialog(new JFrame(), "Logged!");
						client.setUsername(username);
						client.setPassword(password);
						client.changeLayout(new Home(client));
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Username or password incorrect!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				client.changeLayout(new SignUp(client));
			}
		});
		
		tfPassword = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(88))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbPw, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
					.addGap(508))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(190)
					.addComponent(btnLogin)
					.addGap(37)
					.addComponent(btnSignUp)
					.addContainerGap(569, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbPw)
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnSignUp))
					.addContainerGap(793, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
