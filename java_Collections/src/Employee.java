import java.util.*;
import java.io.Serializable;

public class Employee implements  Comparable<Employee>,java.io.Serializable {
	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int compareTo(Employee d) {
		//return (this.name).compareTo(d.name);
		return this.id-d.id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

//	public int compare(Employee d, Employee d1) {
//		return d.id - d1.id;
//	}

}
