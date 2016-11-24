import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.codecops.test.SimpleMovieLister;
import com.codecops.test.Welcome;


public class Caller2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource res = new ClassPathResource("mySpringConfig.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		SimpleMovieLister welcome = (SimpleMovieLister) factory.getBean("mMovie");
		System.out.println(welcome.getMovieFinder());		
		
	}

}
