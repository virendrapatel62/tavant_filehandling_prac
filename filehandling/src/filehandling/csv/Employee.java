package filehandling.csv;

public class Employee {

	private String name ; 
	private float salary ; 
	private int sno;
	
	public Employee() {}
	
	public Employee(int sno , String name , float salary) {
		super();
		this.name = name;
		this.salary = salary;
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", sno=" + sno + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	

}
