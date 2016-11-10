
import java.io.OutputStream;
import java.io.PrintStream;
public class Output {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintStream ps=System.out;
		ps.println("Hello");
		System.out.write(74);
		System.out.flush();
		
//		PrintStream ps1=new PrintStream(System.out);
//		ps1.println("hellohdsjahd");
	}

}
