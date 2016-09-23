package com.mightydanp.eot.common.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mightydanp.eot.common.lib.Reference;


public class EoTLogger {
	
	private static final Logger instance = LogManager.getLogger(Reference.MODID);
	
	public static void logErrorMessage(String error) {
		instance.log(Level.ERROR, error);
	}
	
	public static void logWarningMessage(String warning) {
		instance.log(Level.WARN, warning);
	}
	
	public static void logInfoMessage(String info) {
		instance.log(Level.INFO, info);
	}
	
	public static void logDebugMessage(String debug) {
		instance.log(Level.DEBUG, debug);
	}

	public static void logFatalMessage(String fatal) {
		instance.log(Level.FATAL, fatal);
	}
	
}
