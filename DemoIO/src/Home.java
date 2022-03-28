import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfAvg;
	private JTable table;
	private DefaultTableModel defaulTableModel;
	private Main main;
	private JButton btnClose;

	private void reloadTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		List<String> columnNames = new ArrayList<>();
		columnNames.add("STT");
		columnNames.add("ID");
		columnNames.add("Name");
		columnNames.add("Average");

		ArrayList<String[]> values = new ArrayList<>();
		int i = 1;
		for (Student student : main.students) {
			values.add(new String[] { String.valueOf(i++), student.getID(), student.getName(),
					String.valueOf(student.getAverage()) });
		}

		dtm = new DefaultTableModel(values.toArray(new Object[][] {}), columnNames.toArray());
		table.setModel(dtm);
	}

	private void readFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("students.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
//		main.students.clear();
		main.students = (List<Student>) ois.readObject();
		ois.close();
	}

	private void writeToFile() throws IOException {
		FileOutputStream fos = new FileOutputStream("students.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(main.students);
		oos.close();
	}

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Home(Main main) throws ClassNotFoundException, IOException {
		this.main = main;
		readFromFile();
		main.sortStudent();
		JLabel lblNewLabel = new JLabel("Student management");

		tfID = new JTextField();
		tfID.setColumns(10);

		tfName = new JTextField();
		tfName.setColumns(10);

		tfAvg = new JTextField();
		tfAvg.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = tfID.getText();
				String name = tfName.getText();
				double average = Double.parseDouble(tfAvg.getText());

				Student st = new Student(ID, name, average);
				main.students.add(st);
				main.sortStudent();
				reloadTable();
			}
		});

		List<String> columnNames = new ArrayList<>();
		columnNames.add("STT");
		columnNames.add("ID");
		columnNames.add("Name");
		columnNames.add("Average");

		ArrayList<String[]> values = new ArrayList<>();
		int i = 1;
		for (Student student : main.students) {
			values.add(new String[] { String.valueOf(i++), student.getID(), student.getName(),
					String.valueOf(student.getAverage()) });
		}

		defaulTableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columnNames.toArray());

		JScrollPane scrollPane = new JScrollPane();

		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					writeToFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				main.dispose();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(245, Short.MAX_VALUE)
						.addComponent(lblNewLabel).addGap(124).addComponent(btnClose))
				.addGroup(groupLayout.createSequentialGroup().addGap(63)
						.addComponent(tfID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE).addGap(47)
						.addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addComponent(tfAvg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE).addComponent(btnAdd)
						.addGap(17))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(51, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
						.addGap(36)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(lblNewLabel))
								.addComponent(btnClose))
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfAvg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd))
						.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addGap(16)));

		table = new JTable(defaulTableModel);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
