
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.myapp.persist.Employee2;

public class HibernatePractice3 {
	//create table
	
	public static void main(String[] args) {
//		Employee2 emp1 =new Employee2();
//		emp1.setEmployeeId(1001);
//		emp1.setEmployeeName("Sudhanshu");
//		emp1.setPhoneNumber(297429742);
//		emp1.setSalary(20000);
//		emp1.setCity("varanasi");
//		emp1.setPincode(221005);
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//inserting
		//session.save(emp1);
		//session.save(emp2);
		
		//Update
//		Employee emp3 =new Employee();
//		emp3.setEmployeeId(1002);
//		emp3.setEmployeeName("shan");
//		emp3.setPhoneNumber(2423423);
//		emp3.setSalary(23234);
//		session.update(emp3);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
}
