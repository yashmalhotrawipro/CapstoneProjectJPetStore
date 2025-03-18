package Utility;

import org.apache.log4j.Logger;

public class log4j {
static Logger log = Logger.getLogger(log4j.class.getName());
	public void writeLog(String messsage) {
		log.info(messsage);
	}
}
