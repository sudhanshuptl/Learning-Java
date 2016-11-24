import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.codecops.test.Welcome;


public class Caller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource res = new ClassPathResource("mySpringConfig.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Welcome welcome = (Welcome) factory.getBean("wBean");
		welcome.greet();
		System.out.println(welcome.getName());
		
	}

}
