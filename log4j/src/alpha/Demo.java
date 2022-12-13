package alpha;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	public static Logger Log = LogManager.getLogger(Demo.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Log.debug("clicked the button");
Log.fatal("button is missing");
Log.error("button is not clicked");
Log.info("i cliced the of submit");
	}

}
