import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class TestLoggingEx {
	static Logger log = Logger.getLogger(TestLoggingEx.class); // need to pass
																// class

	// which information
	// logger need to record

	public static void main(String[] args) throws IOException {
		//BasicConfigurator.configure(); // this is inbuilt basic appender, Here
										// debug msg is print in console and it
										// will also formated
		
		// write your own appender
		//Layout layout =new SimpleLayout(); //create basic layout
		//log.addAppender(new ConsoleAppender(layout));
		
		//Customize layout
		//SimpleLayout layout =new SimpleLayout();
		// //Appender appnd = new ConsoleAppender(layout);
		//Appender appnd = new FileAppender(layout,"mylog.text");
		//log.addAppender(appnd);
		
		
		log.setLevel(Level.TRACE); 
		//if we use Level.TRACE then all msg will be visible
		// if we use Level.debug then trace msg is not visible as lover level than trace;
		// in this way we manage our msgs
		// lower to hire msg level ALL(show all msgs)==trace<debug<info<warn<error<fatal<off(this will off all msgs
		
		log.debug("This is debug msg");
		log.info("this is a info msg");
		log.trace("this is a trace msg");
		log.fatal("This is a fatal msg");
		log.error("this is a error msg");
		log.warn("this is a warn msg");
		System.out.println("end");		
	}

}
