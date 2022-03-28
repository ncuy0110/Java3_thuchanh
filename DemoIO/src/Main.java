import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public List<Student> students;

	/**
	 * Launch the application.
	 */

	public void changePanel(JPanel panel) {
		Main.this.getContentPane().removeAll();
		Main.this.getContentPane().add(panel);
		Main.this.revalidate();
		Main.this.repaint();
	}

	public void sortStudent() {
		Collections.sort(students, new Comparator<Student>() {
			// 5, 4, 2, 1
			@Override
			public int compare(Student o1, Student o2) {
				return o1.compare(o2);
//				if(o1.getAverage()<o2.getAverage()) return 1;
//				else return -1;
			}
		});
//		for (int i = 0; i < students.size() - 1; i++) {
//			for (int j = i + 1; j < students.size(); j++) {
//				if (students.get(i).getAverage() > students.get(j).getAverage()) {
//					Student tp = students.get(i);
//					students.set(i, students.get(j));
//					students.set(j, tp);
//				}
//			}
//		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main main = new Main();
					main.changePanel(new Home(main));
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		this.students = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
