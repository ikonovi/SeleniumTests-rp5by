package ik.selen.exprimental;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;

public class LogExample {

	private final static Log loggerCl = LogFactory.getLog(LogExample.class); // commons-logging
	private final static Logger logger4j = Logger.getLogger(LogExample.class); // log4j

	public static void main(String[] args) {

		loggerCl.info("commons-logging facade \n");

		// **********************

		logger4j.info(".getLevel() = " + logger4j.getLevel());
		logger4j.info(".getEffectiveLevel() = " + logger4j.getEffectiveLevel());
		logger4j.info(".getRootLogger().getLevel() = " + Logger.getRootLogger().getLevel());

		logger4j.trace("This is trace msg.");
		logger4j.debug("This is debug msg.");
		logger4j.info("This is info msg.");
		logger4j.warn("This is warn msg.");
		logger4j.error("This is error msg.");
		logger4j.fatal("This is fatal msg.");		

		Logger root = Logger.getRootLogger();
		root.error("root: error");
		root.info("root: info");

		logger4j.assertLog(false, "FALSE in assetLog()");
		logger4j.error("Exception happened", new Exception("some fault in app2"));		
		logger4j.info("This message is hedden by filter. It shouldn't apper in logs.");

		// nested diagnostic contexts		
		NDC.push("Nested");
		NDC.push("Diagnostic");
		NDC.push("Context");		
		logger4j.info("NDC");
		NDC.pop();
		logger4j.info("NDC");		
		NDC.remove();
		
		
		
		LogManager.shutdown(); // HTMLLayout requires it.
	}

}
