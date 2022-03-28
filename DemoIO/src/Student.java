import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private double average;
	
	public Student() {}
	
	public Student(String ID, String name, double average) {
		this.ID = ID;
		this.name = name;
		this.average = average;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	public int compare(Student s1) {
		if(average>s1.getAverage()) return 1;
		return -1;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", average=" + average + "]";
	}
	
}
