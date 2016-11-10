
import java.io.*;

public class Learningserial {

	public static void main(String[] args) {
		Employee emp1 = new Employee(11, "sud");
		Employee emp2 = new Employee(12, "ram");
		Employee emp3 = new Employee(13, "sud");
		try {
	         FileOutputStream fileOut = new FileOutputStream("employee.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(emp1);
	         out.writeObject(emp2);
	         out.writeObject(emp3);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in employee.ser");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }

	}

}
