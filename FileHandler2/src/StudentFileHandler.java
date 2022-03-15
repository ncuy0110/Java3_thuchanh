import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentFileHandler {
	private List<Student> students;
	private String filePath;

	public StudentFileHandler(String filename) throws ClassNotFoundException, IOException {
		this.filePath = System.getProperty("user.dir") + "/src/" + filename;
		students = new ArrayList<Student>();
		readFromFile();
	}
	
	public void writeToFile() throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(students);
	}
	
	public void readFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		ArrayList<Student> stds = (ArrayList<Student>) obj;
		students.clear();
		students = stds;
	}
	
	public void printListStudent() {
		students.forEach(student -> System.out.println(student));
	}
	
	public void addStudent(Student s) {
		students.add(s);
	}
	
	public void updateStudent(Student s, int i) {
		students.set(i, s);
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		StudentFileHandler sfh = new StudentFileHandler("students.bat");
		sfh.updateStudent(new Student("Pho", 2003), 0);
		sfh.writeToFile();
		sfh.printListStudent();
	}
}
