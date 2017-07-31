package ik.log.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;


public class LogExample {

	private final static Log cmnlogger = LogFactory.getLog(LogExample.class); // commons-logging
	private final static Logger l4jlogger = Logger.getLogger(LogExample.class); // log4j

	public static void main(String[] args) {

		cmnlogger.debug("debug");
		l4jlogger.info("info");

	}

}
