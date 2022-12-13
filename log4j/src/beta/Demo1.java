package beta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo1 {

	public static Logger Log = LogManager.getLogger(Demo1.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Log.debug("This is the debug");
Log.fatal("this is the fatal");
Log.error("this is the error");
Log.info("this is the info");
	}

}
