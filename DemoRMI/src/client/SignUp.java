package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfRpPassword;
	private JTextField tfCMND;

	/**
	 * Create the panel.
	 */
	public SignUp(Client client) {
		
		JLabel lblNewLabel = new JLabel("Username");
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		
		JLabel lblNewLabel_2 = new JLabel("Repeat password");
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		
		tfRpPassword = new JTextField();
		tfRpPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmnd = tfCMND.getText();
				String username = tfUsername.getText();
				String password = tfPassword.getText();
//				String rpPassword = tfRpPassword.getText();
				try {
					if(client.intf.createAccount(username, password, cmnd)) {
						JOptionPane.showMessageDialog(new JFrame(), "Signed up, please login!");
						client.changeLayout(new Login(client));
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Username is used!");
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("CMND");
		
		tfCMND = new JTextField();
		tfCMND.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_1)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel)))
								.addComponent(lblNewLabel_2))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfCMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfRpPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(273)
							.addComponent(btnNewButton)))
					.addContainerGap(479, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(tfCMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(tfRpPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addComponent(btnNewButton)
					.addContainerGap(690, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
