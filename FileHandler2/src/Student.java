import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int birthday;
	
	public Student() {
		
	}
	
	public Student(String name, int birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", birthday=" + birthday + "]";
	}
	
}
