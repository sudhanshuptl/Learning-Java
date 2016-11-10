import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class LearningDeserial {

	public static void main(String[] args) {
		try{
		FileInputStream fin= new FileInputStream("employee.ser");
		ObjectInputStream oin = new ObjectInputStream(fin);
		Employee e = (Employee) oin.readObject();
		System.out.println(e.getName());
		oin.close();
		fin.close();
		
		}catch(IOException i){
			i.printStackTrace();
		}catch(ClassNotFoundException b){
			b.printStackTrace();
		}
	}
}
