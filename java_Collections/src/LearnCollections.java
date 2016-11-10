import java.util.*;

public class LearnCollections {

	public static void main(String[] args) {

		ArrayList<Employee> list = new ArrayList<Employee>();
		// Collection list = new ArrayList();
		Employee emp1 = new Employee(11, "sud");
		Employee emp2 = new Employee(12, "ram");
		Employee emp3 = new Employee(13, "sud");
		Employee emp4 = new Employee(14, "sud");
		Employee emp5 = new Employee(15, "ram");
		Employee emp6 = new Employee(16, "sud");

		// Collection list= new TreeSet();
		list.add(emp1);
		// list.add(1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		list.add(emp6);
		//Iterator<Employee> it = list.iterator();
		// while(it.hasNext()){
		// Employee ee = it.next();
		// System.out.println(ee.getId());
		// }
//		for (Employee ee : list) {
//			System.out.println(ee.getId());
//		}
		Date d = new Date();
		System.out.println(d.getDate());
	}

	

}
