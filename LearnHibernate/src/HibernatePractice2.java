
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.myapp.persist.Employee;

public class HibernatePractice2 {
	//create table
	
	public static void main(String[] args) {
		Employee emp1 =new Employee();
		emp1.setEmployeeId(1001);
		emp1.setEmployeeName("Sudhanshu");
		emp1.setPhoneNumber(297429742);
		emp1.setSalary(20000);
		
		Employee emp2 =new Employee();
		emp2.setEmployeeId(1002);
		emp2.setEmployeeName("Sudhanshu");
		emp2.setPhoneNumber(297429742);
		emp2.setSalary(20000);
		
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory(); //create a schema as mention create in xml
		Session session = sessionFactory.openSession();
		

		Transaction transaction = session.beginTransaction();
		//inserting
		session.save(emp1);
		session.save(emp2);
		
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
