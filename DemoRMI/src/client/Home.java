package client;

import javax.swing.JPanel;

import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfMoney;
	private JLabel lblMoney;

	/**
	 * Create the panel.
	 */
	public Home(Client client) {
		
		JButton btnNewButton = new JButton("Enter moneys");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int moneys;
				try {
					moneys = Integer.parseInt(tfMoney.getText());
					if(client.intf.enter(client.getUsername(), client.getPassword(), moneys)) {
						JOptionPane.showMessageDialog(new JFrame(), "Enter success");
						lblMoney.setText(client.intf.getMoney(client.getUsername(), client.getPassword()) + "");
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Withdraw moneys");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int moneys;
				try {
					moneys = Integer.parseInt(tfMoney.getText());
					if(client.intf.withdraw(client.getUsername(), client.getPassword(), moneys)) {
						JOptionPane.showMessageDialog(new JFrame(), "Withdraw success");
						lblMoney.setText(client.intf.getMoney(client.getUsername(), client.getPassword()) + "");
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Withdraw failed");
					}
				}catch(NumberFormatException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		JLabel lblNewLabel = new JLabel("Moneys: ");
		
		lblMoney = new JLabel("1");
		int moneys;
		try {
			moneys = client.intf.getMoney(client.getUsername(), client.getPassword());
			lblMoney.setText(moneys + "");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		tfMoney = new JTextField();
		tfMoney.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(146)
							.addComponent(lblNewLabel)
							.addGap(26)
							.addComponent(lblMoney))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(tfMoney, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(84)
									.addComponent(btnNewButton_1)))))
					.addContainerGap(441, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblMoney))
					.addGap(102)
					.addComponent(tfMoney, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(814, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
